import request from '@/utils/request'

// 查询电动车信息列表
export function listElectricCar(query) {
  return request({
    url: '/evm/electricCar/list',
    method: 'get',
    params: query
  })
}

// 查询电动车信息详细
export function getElectricCar(elecCarId) {
  return request({
    url: '/evm/electricCar/' + elecCarId,
    method: 'get'
  })
}

// 新增电动车信息
export function addElectricCar(data) {
  return request({
    url: '/evm/electricCar',
    method: 'post',
    data: data
  })
}

// 修改电动车信息
export function updateElectricCar(data) {
  return request({
    url: '/evm/electricCar',
    method: 'put',
    data: data
  })
}

// 删除电动车信息
export function delElectricCar(elecCarId) {
  return request({
    url: '/evm/electricCar/' + elecCarId,
    method: 'delete'
  })
}
