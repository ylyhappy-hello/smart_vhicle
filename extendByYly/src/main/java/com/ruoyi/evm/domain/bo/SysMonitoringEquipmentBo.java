package com.ruoyi.evm.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电动车信息业务对象 sys_monitoring_equipment
 *
 * @author ylyhappy
 * @date 2023-02-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysMonitoringEquipmentBo extends BaseEntity {

    /**
     * 监控设备ID
     */
    @NotNull(message = "监控设备ID不能为空", groups = { EditGroup.class })
    private Long monitoringEquipmentId;

    /**
     * 监控设备名称
     */
    @NotBlank(message = "监控设备名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String monitoringEquipmentName;

    /**
     * 监控设备编号
     */
    @NotBlank(message = "监控设备编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String monitoringEquipmentNumber;

    /**
     * 监控状态（0正常 1涉事）
     */
    @NotBlank(message = "监控状态（0正常 1涉事）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}
