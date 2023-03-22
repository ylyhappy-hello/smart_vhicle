package com.ruoyi.evm.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 电动车信息视图对象 sys_monitoring_equipment
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Data
@ExcelIgnoreUnannotated
public class SysMonitoringEquipmentVo {

    private static final long serialVersionUID = 1L;

    /**
     * 监控设备ID
     */
    @ExcelProperty(value = "监控设备ID")
    private Long monitoringEquipmentId;

    /**
     * 监控设备名称
     */
    @ExcelProperty(value = "监控设备名称")
    private String monitoringEquipmentName;

    /**
     * 监控设备编号
     */
    @ExcelProperty(value = "监控设备编号")
    private String monitoringEquipmentNumber;

    /**
     * 监控状态（0正常 1涉事）
     */
    @ExcelProperty(value = "监控状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=涉事")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
