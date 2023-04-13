/*
 * @文件描述: 扩展面包屑
 * @公司: 山东大学
 * @作者: 李洪文
 * @Date: 2019-05-31 10:35:10
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-06-11 20:53:28
 */

export const routes = [
  {
    path: '/base',
    breadcrumbName: '基础管理',
    children: [
      {
        path: '/user',
        breadcrumbName: '用户管理',
        children: [
          { path: '/add', breadcrumbName: '新增' },
          { path: '/edit', breadcrumbName: '编辑' },
        ],
      },
      
      {
        path: '/contact',
        breadcrumbName: '联系人信息管理',
      },
    ],
  },
  {
    path: '/home',
    breadcrumbName: '联系人省份分布信息',
 },
];
