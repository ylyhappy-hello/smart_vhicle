import request from '@/utils/request'

// 查询AI接口调用日志列表
export function helemetDetect(query) {
  return request({
    url: 'http://127.0.0.1:5000/api/ai/video-helmet-detect/' + query,
    method: 'get',
    timeout: 0,
  })
}
