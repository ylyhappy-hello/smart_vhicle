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
import com.ruoyi.evm.domain.vo.SysElectricCarVo;
import com.ruoyi.evm.domain.bo.SysElectricCarBo;
import com.ruoyi.evm.service.ISysElectricCarService;
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
@RequestMapping("/evm/electricCar")
public class SysElectricCarController extends BaseController {
    private final ISysElectricCarService iSysElectricCarService;

    /**
     * 查询电动车信息列表
     */
    @SaCheckPermission("evm:electricCar:list")
    @GetMapping("/list")
    public TableDataInfo<SysElectricCarVo> list(SysElectricCarBo bo, PageQuery pageQuery) {
        return iSysElectricCarService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出电动车信息列表
     */
    @SaCheckPermission("evm:electricCar:export")
    @Log(title = "电动车信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SysElectricCarBo bo, HttpServletResponse response) {
        List<SysElectricCarVo> list = iSysElectricCarService.queryList(bo);
        ExcelUtil.exportExcel(list, "电动车信息", SysElectricCarVo.class, response);
    }

    /**
     * 获取电动车信息详细信息
     *
     * @param elecCarId 主键
     */
    @SaCheckPermission("evm:electricCar:query")
    @GetMapping("/{elecCarId}")
    public R<SysElectricCarVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long elecCarId) {
        return R.ok(iSysElectricCarService.queryById(elecCarId));
    }

    /**
     * 新增电动车信息
     */
    @SaCheckPermission("evm:electricCar:add")
    @Log(title = "电动车信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysElectricCarBo bo) {
        return toAjax(iSysElectricCarService.insertByBo(bo));
    }

    /**
     * 修改电动车信息
     */
    @SaCheckPermission("evm:electricCar:edit")
    @Log(title = "电动车信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysElectricCarBo bo) {
        return toAjax(iSysElectricCarService.updateByBo(bo));
    }

    /**
     * 删除电动车信息
     *
     * @param elecCarIds 主键串
     */
    @SaCheckPermission("evm:electricCar:remove")
    @Log(title = "电动车信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{elecCarIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] elecCarIds) {
        return toAjax(iSysElectricCarService.deleteWithValidByIds(Arrays.asList(elecCarIds), true));
    }
}
