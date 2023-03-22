package com.ruoyi.evm.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI接口调用日志业务对象 sys_ai_log
 *
 * @author ylyhappy
 * @date 2023-02-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysAiLogBo extends BaseEntity {

    /**
     * ID
     */
    @NotNull(message = "ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 调用的接口名
     */
    @NotBlank(message = "调用的接口名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String interfaceName;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}
