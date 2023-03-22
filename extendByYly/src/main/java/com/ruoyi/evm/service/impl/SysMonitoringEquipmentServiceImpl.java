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
import com.ruoyi.evm.domain.bo.SysMonitoringEquipmentBo;
import com.ruoyi.evm.domain.vo.SysMonitoringEquipmentVo;
import com.ruoyi.evm.domain.SysMonitoringEquipment;
import com.ruoyi.evm.mapper.SysMonitoringEquipmentMapper;
import com.ruoyi.evm.service.ISysMonitoringEquipmentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 电动车信息Service业务层处理
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
@RequiredArgsConstructor
@Service
public class SysMonitoringEquipmentServiceImpl implements ISysMonitoringEquipmentService {

    private final SysMonitoringEquipmentMapper baseMapper;

    /**
     * 查询电动车信息
     */
    @Override
    public SysMonitoringEquipmentVo queryById(Long monitoringEquipmentId){
        return baseMapper.selectVoById(monitoringEquipmentId);
    }

    /**
     * 查询电动车信息列表
     */
    @Override
    public TableDataInfo<SysMonitoringEquipmentVo> queryPageList(SysMonitoringEquipmentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysMonitoringEquipment> lqw = buildQueryWrapper(bo);
        Page<SysMonitoringEquipmentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询电动车信息列表
     */
    @Override
    public List<SysMonitoringEquipmentVo> queryList(SysMonitoringEquipmentBo bo) {
        LambdaQueryWrapper<SysMonitoringEquipment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SysMonitoringEquipment> buildQueryWrapper(SysMonitoringEquipmentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SysMonitoringEquipment> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getMonitoringEquipmentName()), SysMonitoringEquipment::getMonitoringEquipmentName, bo.getMonitoringEquipmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getMonitoringEquipmentNumber()), SysMonitoringEquipment::getMonitoringEquipmentNumber, bo.getMonitoringEquipmentNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), SysMonitoringEquipment::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增电动车信息
     */
    @Override
    public Boolean insertByBo(SysMonitoringEquipmentBo bo) {
        SysMonitoringEquipment add = BeanUtil.toBean(bo, SysMonitoringEquipment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setMonitoringEquipmentId(add.getMonitoringEquipmentId());
        }
        return flag;
    }

    /**
     * 修改电动车信息
     */
    @Override
    public Boolean updateByBo(SysMonitoringEquipmentBo bo) {
        SysMonitoringEquipment update = BeanUtil.toBean(bo, SysMonitoringEquipment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SysMonitoringEquipment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除电动车信息
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
