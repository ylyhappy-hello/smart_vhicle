import request from '@/utils/request'

// 查询AI接口调用日志列表
export function listAilog(query) {
  return request({
    url: '/evm/ailog/list',
    method: 'get',
    params: query
  })
}

// 查询AI接口调用日志详细
export function getAilog(id) {
  return request({
    url: '/evm/ailog/' + id,
    method: 'get'
  })
}

// 新增AI接口调用日志
export function addAilog(data) {
  return request({
    url: '/evm/ailog',
    method: 'post',
    data: data
  })
}

// 修改AI接口调用日志
export function updateAilog(data) {
  return request({
    url: '/evm/ailog',
    method: 'put',
    data: data
  })
}

// 删除AI接口调用日志
export function delAilog(id) {
  return request({
    url: '/evm/ailog/' + id,
    method: 'delete'
  })
}
