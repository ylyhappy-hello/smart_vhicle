package com.ruoyi.evm.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI接口调用日志对象 sys_ai_log
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_ai_log")
public class SysAiLog extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 调用的接口名
     */
    private String interfaceName;
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
