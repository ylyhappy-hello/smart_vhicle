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
import com.ruoyi.evm.domain.vo.SysAiLogVo;
import com.ruoyi.evm.domain.bo.SysAiLogBo;
import com.ruoyi.evm.service.ISysAiLogService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI接口调用日志
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/evm/ailog")
public class SysAiLogController extends BaseController {

    private final ISysAiLogService iSysAiLogService;

    /**
     * 查询AI接口调用日志列表
     */
    @SaCheckPermission("evm:ailog:list")
    @GetMapping("/list")
    public TableDataInfo<SysAiLogVo> list(SysAiLogBo bo, PageQuery pageQuery) {
        return iSysAiLogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出AI接口调用日志列表
     */
    @SaCheckPermission("evm:ailog:export")
    @Log(title = "AI接口调用日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SysAiLogBo bo, HttpServletResponse response) {
        List<SysAiLogVo> list = iSysAiLogService.queryList(bo);
        ExcelUtil.exportExcel(list, "AI接口调用日志", SysAiLogVo.class, response);
    }

    /**
     * 获取AI接口调用日志详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("evm:ailog:query")
    @GetMapping("/{id}")
    public R<SysAiLogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iSysAiLogService.queryById(id));
    }

    /**
     * 新增AI接口调用日志
     */
    @SaCheckPermission("evm:ailog:add")
    @Log(title = "AI接口调用日志", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysAiLogBo bo) {
        return toAjax(iSysAiLogService.insertByBo(bo));
    }

    /**
     * 修改AI接口调用日志
     */
    @SaCheckPermission("evm:ailog:edit")
    @Log(title = "AI接口调用日志", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysAiLogBo bo) {
        return toAjax(iSysAiLogService.updateByBo(bo));
    }

    /**
     * 删除AI接口调用日志
     *
     * @param ids 主键串
     */
    @SaCheckPermission("evm:ailog:remove")
    @Log(title = "AI接口调用日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iSysAiLogService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
