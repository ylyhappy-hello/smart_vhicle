package com.ruoyi.evm.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.evm.domain.vo.SysMonitoringEquipmentVo;
import com.ruoyi.evm.domain.bo.SysMonitoringEquipmentBo;
import com.ruoyi.evm.service.ISysMonitoringEquipmentService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电动车信息
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/evm/monitoringEquipment")
public class SysMonitoringEquipmentController extends BaseController {

    private final ISysMonitoringEquipmentService iSysMonitoringEquipmentService;

    /**
     * 查询电动车信息列表
     */
    @SaCheckPermission("evm:monitoringEquipment:list")
    @GetMapping("/list")
    public TableDataInfo<SysMonitoringEquipmentVo> list(SysMonitoringEquipmentBo bo, PageQuery pageQuery) {
        return iSysMonitoringEquipmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出电动车信息列表
     */
    @SaCheckPermission("evm:monitoringEquipment:export")
    @Log(title = "电动车信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SysMonitoringEquipmentBo bo, HttpServletResponse response) {
        List<SysMonitoringEquipmentVo> list = iSysMonitoringEquipmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "电动车信息", SysMonitoringEquipmentVo.class, response);
    }

    /**
     * 获取电动车信息详细信息
     *
     * @param monitoringEquipmentId 主键
     */
    @SaCheckPermission("evm:monitoringEquipment:query")
    @GetMapping("/{monitoringEquipmentId}")
    public R<SysMonitoringEquipmentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long monitoringEquipmentId) {
        return R.ok(iSysMonitoringEquipmentService.queryById(monitoringEquipmentId));
    }

    /**
     * 新增电动车信息
     */
    @SaCheckPermission("evm:monitoringEquipment:add")
    @Log(title = "电动车信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysMonitoringEquipmentBo bo) {
        return toAjax(iSysMonitoringEquipmentService.insertByBo(bo));
    }

    /**
     * 修改电动车信息
     */
    @SaCheckPermission("evm:monitoringEquipment:edit")
    @Log(title = "电动车信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysMonitoringEquipmentBo bo) {
        return toAjax(iSysMonitoringEquipmentService.updateByBo(bo));
    }

    /**
     * 删除电动车信息
     *
     * @param monitoringEquipmentIds 主键串
     */
    @SaCheckPermission("evm:monitoringEquipment:remove")
    @Log(title = "电动车信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{monitoringEquipmentIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] monitoringEquipmentIds) {
        return toAjax(iSysMonitoringEquipmentService.deleteWithValidByIds(Arrays.asList(monitoringEquipmentIds), true));
    }
}
