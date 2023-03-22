package com.ruoyi.evm.service;

import com.ruoyi.evm.domain.SysMonitoringEquipment;
import com.ruoyi.evm.domain.vo.SysMonitoringEquipmentVo;
import com.ruoyi.evm.domain.bo.SysMonitoringEquipmentBo;
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
public interface ISysMonitoringEquipmentService {

    /**
     * 查询电动车信息
     */
    SysMonitoringEquipmentVo queryById(Long monitoringEquipmentId);

    /**
     * 查询电动车信息列表
     */
    TableDataInfo<SysMonitoringEquipmentVo> queryPageList(SysMonitoringEquipmentBo bo, PageQuery pageQuery);

    /**
     * 查询电动车信息列表
     */
    List<SysMonitoringEquipmentVo> queryList(SysMonitoringEquipmentBo bo);

    /**
     * 新增电动车信息
     */
    Boolean insertByBo(SysMonitoringEquipmentBo bo);

    /**
     * 修改电动车信息
     */
    Boolean updateByBo(SysMonitoringEquipmentBo bo);

    /**
     * 校验并批量删除电动车信息信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
