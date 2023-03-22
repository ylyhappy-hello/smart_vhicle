package com.ruoyi.evm.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电动车信息对象 sys_monitoring_equipment
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_monitoring_equipment")
public class SysMonitoringEquipment extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 监控设备ID
     */
    @TableId(value = "monitoring_equipment_id")
    private Long monitoringEquipmentId;
    /**
     * 监控设备名称
     */
    private String monitoringEquipmentName;
    /**
     * 监控设备编号
     */
    private String monitoringEquipmentNumber;
    /**
     * 监控状态（0正常 1涉事）
     */
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;
    /**
     * 备注
     */
    private String remark;

}
