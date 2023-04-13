/*
 * @文件描述: 首页
 * @公司: superv
 * @作者: 李洪文
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2019-05-09 15:40:17
 * @LastEditTime: 2022-06-11 20:31:00
 */
import { useEffect, useState } from 'react';
import styles from './index.less';
import Card from '@/components/Card';
export const interval = 5000;
export const MAX_MONITOR_RECORD_SIZE = 20;
import { Column } from '@ant-design/charts';
import { ContactProvinceVO, ContactVO } from '@/api/baseClass';
import { calculate } from '@/api/mods/contact';
import ReactDOM from 'react-dom';



export default function Component() {
  const [stats1, setStats1] = useState(0);
  const [stats2, setStats2] = useState(0);
  const [state,setState] = useState<defs.Calculate<defs.ContactProvinceVO>>();
  const fetchList=async(props: defs.Calculate<defs.ContactProvinceVO> | undefined)=>{
    const state = await API.contact.calculate.request({},props);
    setState(state);
  }
  useEffect(()=>{
    fetchList(state);
  },[]);

  function Getdata(props:defs.Calculate<defs.ContactProvinceVO>|undefined)
  {
    let result:any;
    if(props)
    {result=state?.list!?.map(item=>{return {province:item.province,number:item.number}})};
    if(!props){
      result=[{province:null,number:null},];
    }
    return result;
  }
  const data=Getdata(state);
  
  useEffect(() => {
    const timer = setInterval(() => {
      setStats1(stats1 + 1);
      setStats2(stats2 + 2);
    }, interval);
    return () => {
      clearInterval(timer);
    };
  }, []);
  const config = {
    data,
    xField: 'province',
    yField: 'number',

    xAxis: {
      label: {
        autoRotate: false,
      },
    },
  };
  
  return (
    <div className={styles.homeContainer}>
    <div><Column {...config} /></div>
    </div>
  );
}

