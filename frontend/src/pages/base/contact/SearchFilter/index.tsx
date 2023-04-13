import { Input } from 'antd';
import styles from '@/styles/search-filter.less';
import TextArea from 'antd/lib/input/TextArea';
interface SearchFilterProps {
  onSearch: () => void;
  searchProps: defs.ContactQueryDTO;
  changeSearchProps: (searchProps: defs.ContactQueryDTO) => void;
}

export default function SearchFilter(props: SearchFilterProps) {
  return (
    <div className={styles.filterPanel}>
      <div className={styles.filterItem}>
        <span className={styles.label}>关键词：</span>
        
        <Input.Search
          allowClear={true}
          value={props.searchProps.contactName}
          //value={props.searchProps.contactEmail}
          onSearch={props.onSearch}
          onChange={(e) =>
            props.changeSearchProps({
              contactName: e.target.value
              //contactEmail: e.target.value
            })
          }
          placeholder="请输入联系人姓名"
         
        />
        <Input.Search
          allowClear={true}
          //value={props.searchProps.contactName}
          value={props.searchProps.contactUnit}
          onSearch={props.onSearch}
          onChange={(e) =>
            props.changeSearchProps({
              //contactName: e.target.value
              contactUnit: e.target.value
            })
          }
          placeholder="请输入联系人工作单位"
        />
        <Input.Search
          allowClear={true}
          //value={props.searchProps.contactName}
          value={props.searchProps.contactNumber}
          onSearch={props.onSearch}
          onChange={(e) =>
            props.changeSearchProps({
              //contactName: e.target.value
              contactNumber: e.target.value
            })
          }
          placeholder="请输入联系人电话号码"
        />
        <Input.Search
          allowClear={true}
          //value={props.searchProps.contactName}
          value={props.searchProps.contactProvince}
          onSearch={props.onSearch}
          onChange={(e) =>
            props.changeSearchProps({
              //contactName: e.target.value
              contactProvince: e.target.value
            })
          }
          placeholder="请输入联系人省份"
        />
        <Input.Search
          allowClear={true}
          //value={props.searchProps.contactName}
          value={props.searchProps.contactEmail}
          onSearch={props.onSearch}
          onChange={(e) =>
            props.changeSearchProps({
              //contactName: e.target.value
              contactEmail: e.target.value
            })
          }
          placeholder="请输入联系人邮箱"
        />
        <Input.Search
          allowClear={true}
          //value={props.searchProps.contactName}
          value={props.searchProps.contactLocation}
          onSearch={props.onSearch}
          onChange={(e) =>
            props.changeSearchProps({
              //contactName: e.target.value
              contactLocation: e.target.value
            })
          }
          placeholder="请输入联系人住址"
        />
      </div>
    </div>
  );
}
