package com.ruoyi.evm.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电动车信息对象 sys_electric_car
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_electric_car")
public class SysElectricCar extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 电动车ID
     */
    @TableId(value = "elec_car_id")
    private Long elecCarId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 电动车名称
     */
    private String elecCarName;
    /**
     * 电动车车牌号
     */
    private String elecCarNumber;
    /**
     * 电动车状态（0正常 1涉事）
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
