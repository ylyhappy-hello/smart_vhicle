package com.ruoyi.evm.service;

import com.ruoyi.evm.domain.SysAiLog;
import com.ruoyi.evm.domain.vo.SysAiLogVo;
import com.ruoyi.evm.domain.bo.SysAiLogBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * AI接口调用日志Service接口
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
public interface ISysAiLogService {

    /**
     * 查询AI接口调用日志
     */
    SysAiLogVo queryById(Long id);

    /**
     * 查询AI接口调用日志列表
     */
    TableDataInfo<SysAiLogVo> queryPageList(SysAiLogBo bo, PageQuery pageQuery);

    /**
     * 查询AI接口调用日志列表
     */
    List<SysAiLogVo> queryList(SysAiLogBo bo);

    /**
     * 新增AI接口调用日志
     */
    Boolean insertByBo(SysAiLogBo bo);

    /**
     * 修改AI接口调用日志
     */
    Boolean updateByBo(SysAiLogBo bo);

    /**
     * 校验并批量删除AI接口调用日志信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
