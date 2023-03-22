package com.ruoyi.evm.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 电动车信息视图对象 sys_electric_car
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Data
@ExcelIgnoreUnannotated
public class SysElectricCarVo {

    private static final long serialVersionUID = 1L;

    /**
     * 电动车ID
     */
    @ExcelProperty(value = "电动车ID")
    private Long elecCarId;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    private Long userId;

    /**
     * 电动车名称
     */
    @ExcelProperty(value = "电动车名称")
    private String elecCarName;

    /**
     * 电动车车牌号
     */
    @ExcelProperty(value = "电动车车牌号")
    private String elecCarNumber;

    /**
     * 电动车状态（0正常 1涉事）
     */
    @ExcelProperty(value = "电动车状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=涉事")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
