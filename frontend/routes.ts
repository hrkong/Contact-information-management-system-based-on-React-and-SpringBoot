/*
 * @文件描述: 路由
 * @公司: 山东大学
 * @作者: 李洪文
 * @Date: 2020-05-20 10:31:07
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2022-03-26 15:19:55
 */

export const routes = [
  {
    path: '/user',
    component: '@/layouts/UserLayout',
    routes: [
      { path: '/user', redirect: '/user/login' },
      { path: '/user/login', component: './login' },
    ],
  },
  {
    path: '/',
    component: '@/layouts/BasicLayout',
    routes: [
      {
        path: '/base',
        //wrappers: ['@/components/Authorized'],
        routes: [
          {
            path: '/base/department',
            component: './base/department',
          },
          {
            path: '/base/contact',
            component: './base/contact',
          },
        ],
      },
      /*
      {
        path: '/system',
        //wrappers: ['@/components/Authorized'],
        routes: [
          {
            path: '/system/admin',
            component: './system/admin/list',
          },
          {
            path: '/system/admin/edit',
            component: './system/admin/edit',
          },
          {
            path: '/system/admin/add',
            component: './system/admin/edit',
          },
        ],
      },
      */
      { path: '/', redirect: '/home' },
      {
        path: '/home',
        component: './home',
      },
    ],
  },
  {
    component: '404',
  },
];
