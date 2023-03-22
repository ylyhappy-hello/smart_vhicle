package com.ruoyi.evm.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电动车信息业务对象 sys_electric_car
 *
 * @author ylyhappy
 * @date 2023-02-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysElectricCarBo extends BaseEntity {

    /**
     * 电动车ID
     */
    @NotNull(message = "电动车ID不能为空", groups = { EditGroup.class })
    private Long elecCarId;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long userId;

    /**
     * 电动车名称
     */
    @NotBlank(message = "电动车名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String elecCarName;

    /**
     * 电动车车牌号
     */
    @NotBlank(message = "电动车车牌号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String elecCarNumber;

    /**
     * 电动车状态（0正常 1涉事）
     */
    @NotBlank(message = "电动车状态（0正常 1涉事）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}
