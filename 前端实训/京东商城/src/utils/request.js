import axios from 'axios'
// 如果不提交数据，默认为一个空对象
// 设置提交数据的格式为json格式
axios.defaults.headers.post['Content-Type'] = 'application/json'
const instance = axios.create({
  baseURL:
    'https://www.fastmock.site/mock/76be3c9b531d8ee9728d14c66fe0bff2/hatcher'
})
export const post = (url, data = {}) => {
  return new Promise((resolve, reject) => {
    instance
      .post(url, data, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(
        response => {
          resolve(response.data)
        },
        err => {
          reject(err)
        }
      )
  })
}

export const get = (url, params = {}) => {
  return new Promise((resolve, reject) => {
    instance.get(url, params).then(
      response => {
        resolve(response.data)
      },
      err => {
        reject(err)
      }
    )
  })
}
