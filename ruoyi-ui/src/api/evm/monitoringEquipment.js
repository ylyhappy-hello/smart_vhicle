import request from '@/utils/request'

// 查询电动车信息列表
export function listMonitoringEquipment(query) {
  return request({
    url: '/evm/monitoringEquipment/list',
    method: 'get',
    params: query
  })
}

// 查询电动车信息详细
export function getMonitoringEquipment(monitoringEquipmentId) {
  return request({
    url: '/evm/monitoringEquipment/' + monitoringEquipmentId,
    method: 'get'
  })
}

// 新增电动车信息
export function addMonitoringEquipment(data) {
  return request({
    url: '/evm/monitoringEquipment',
    method: 'post',
    data: data
  })
}

// 修改电动车信息
export function updateMonitoringEquipment(data) {
  return request({
    url: '/evm/monitoringEquipment',
    method: 'put',
    data: data
  })
}

// 删除电动车信息
export function delMonitoringEquipment(monitoringEquipmentId) {
  return request({
    url: '/evm/monitoringEquipment/' + monitoringEquipmentId,
    method: 'delete'
  })
}
