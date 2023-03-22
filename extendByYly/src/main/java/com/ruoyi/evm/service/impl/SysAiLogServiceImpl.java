package com.ruoyi.evm.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.evm.domain.bo.SysAiLogBo;
import com.ruoyi.evm.domain.vo.SysAiLogVo;
import com.ruoyi.evm.domain.SysAiLog;
import com.ruoyi.evm.mapper.SysAiLogMapper;
import com.ruoyi.evm.service.ISysAiLogService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * AI接口调用日志Service业务层处理
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@RequiredArgsConstructor
@Service
public class SysAiLogServiceImpl implements ISysAiLogService {

    private final SysAiLogMapper baseMapper;

    /**
     * 查询AI接口调用日志
     */
    @Override
    public SysAiLogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询AI接口调用日志列表
     */
    @Override
    public TableDataInfo<SysAiLogVo> queryPageList(SysAiLogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysAiLog> lqw = buildQueryWrapper(bo);
        Page<SysAiLogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询AI接口调用日志列表
     */
    @Override
    public List<SysAiLogVo> queryList(SysAiLogBo bo) {
        LambdaQueryWrapper<SysAiLog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SysAiLog> buildQueryWrapper(SysAiLogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SysAiLog> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getInterfaceName()), SysAiLog::getInterfaceName, bo.getInterfaceName());
        return lqw;
    }

    /**
     * 新增AI接口调用日志
     */
    @Override
    public Boolean insertByBo(SysAiLogBo bo) {
        SysAiLog add = BeanUtil.toBean(bo, SysAiLog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改AI接口调用日志
     */
    @Override
    public Boolean updateByBo(SysAiLogBo bo) {
        SysAiLog update = BeanUtil.toBean(bo, SysAiLog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SysAiLog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除AI接口调用日志
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
