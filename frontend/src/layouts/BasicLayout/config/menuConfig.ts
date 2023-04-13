/*
 * @文件描述: 路由
 * @公司: 山东大学
 * @作者: 李洪文
 * @Date: 2019-06-13 10:35:10
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-06-11 20:52:22
 */

import {
  HomeOutlined,
  SettingOutlined,
  AreaChartOutlined,
  UnorderedListOutlined,
} from '@ant-design/icons';

const menuConfig = [
  {
    key: 'home',
    name: '联系人省份信息',
    link: '/home',
    icon: HomeOutlined,
  },
  {
    key: 'base',
    name: '基础数据',
    icon: SettingOutlined,
    children: [
      {
        key: 'contact',
        link: '/base/contact',
        name: '联系人信息管理',
      },
    ],
  },
  
];

export { menuConfig };
