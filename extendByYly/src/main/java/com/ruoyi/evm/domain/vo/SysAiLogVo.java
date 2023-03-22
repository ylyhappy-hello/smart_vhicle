package com.ruoyi.evm.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * AI接口调用日志视图对象 sys_ai_log
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Data
@ExcelIgnoreUnannotated
public class SysAiLogVo {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ExcelProperty(value = "ID")
    private Long id;

    /**
     * 调用的接口名
     */
    @ExcelProperty(value = "调用的接口名")
    private String interfaceName;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
