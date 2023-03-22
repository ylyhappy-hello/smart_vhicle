package com.ruoyi.evm.service;

import com.ruoyi.evm.domain.SysElectricCar;
import com.ruoyi.evm.domain.vo.SysElectricCarVo;
import com.ruoyi.evm.domain.bo.SysElectricCarBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 电动车信息Service接口
 *
 * @author ylyhappy
 * @date 2023-02-11
 */
public interface ISysElectricCarService {

    /**
     * 查询电动车信息
     */
    SysElectricCarVo queryById(Long elecCarId);

    /**
     * 查询电动车信息列表
     */
    TableDataInfo<SysElectricCarVo> queryPageList(SysElectricCarBo bo, PageQuery pageQuery);

    /**
     * 查询电动车信息列表
     */
    List<SysElectricCarVo> queryList(SysElectricCarBo bo);

    /**
     * 新增电动车信息
     */
    Boolean insertByBo(SysElectricCarBo bo);

    /**
     * 修改电动车信息
     */
    Boolean updateByBo(SysElectricCarBo bo);

    /**
     * 校验并批量删除电动车信息信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
