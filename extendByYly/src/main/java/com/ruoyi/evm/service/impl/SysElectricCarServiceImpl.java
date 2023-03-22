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
import com.ruoyi.evm.domain.bo.SysElectricCarBo;
import com.ruoyi.evm.domain.vo.SysElectricCarVo;
import com.ruoyi.evm.domain.SysElectricCar;
import com.ruoyi.evm.mapper.SysElectricCarMapper;
import com.ruoyi.evm.service.ISysElectricCarService;

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
public class SysElectricCarServiceImpl implements ISysElectricCarService {

    private final SysElectricCarMapper baseMapper;

    /**
     * 查询电动车信息
     */
    @Override
    public SysElectricCarVo queryById(Long elecCarId){
        return baseMapper.selectVoById(elecCarId);
    }

    /**
     * 查询电动车信息列表
     */
    @Override
    public TableDataInfo<SysElectricCarVo> queryPageList(SysElectricCarBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysElectricCar> lqw = buildQueryWrapper(bo);
        Page<SysElectricCarVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询电动车信息列表
     */
    @Override
    public List<SysElectricCarVo> queryList(SysElectricCarBo bo) {
        LambdaQueryWrapper<SysElectricCar> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SysElectricCar> buildQueryWrapper(SysElectricCarBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SysElectricCar> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, SysElectricCar::getUserId, bo.getUserId());
        lqw.like(StringUtils.isNotBlank(bo.getElecCarName()), SysElectricCar::getElecCarName, bo.getElecCarName());
        lqw.eq(StringUtils.isNotBlank(bo.getElecCarNumber()), SysElectricCar::getElecCarNumber, bo.getElecCarNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), SysElectricCar::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增电动车信息
     */
    @Override
    public Boolean insertByBo(SysElectricCarBo bo) {
        SysElectricCar add = BeanUtil.toBean(bo, SysElectricCar.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setElecCarId(add.getElecCarId());
        }
        return flag;
    }

    /**
     * 修改电动车信息
     */
    @Override
    public Boolean updateByBo(SysElectricCarBo bo) {
        SysElectricCar update = BeanUtil.toBean(bo, SysElectricCar.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SysElectricCar entity){
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
