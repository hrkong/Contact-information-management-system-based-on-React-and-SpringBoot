/*
 * @文件描述: 首页
 * @公司: 山东大学
 * @作者: 李洪文
 * @LastEditors: 李洪文
 * @Date: 2019-05-09 15:40:17
 * @LastEditTime: 2020-04-01 12:20:23
 */
import { useCallback, useEffect, useState } from 'react';
import CustomTable from '@/components/CustomTable';
import FileAddOutlined from '@ant-design/icons/FileAddOutlined';
import DeleteOutlined from '@ant-design/icons/DeleteOutlined';
import GroupOutlined from '@ant-design/icons/GroupOutlined';
import SearchFilter from './SearchFilter';
import { Divider, message, Modal } from 'antd';
import { ButtonItem } from '@/data-type/common';
import { DEFAULT_SEARCH_PROPS, DEFAULT_PAGE_DATA } from '@/constants';
import InputDialog from './InputDialog';
export default function ContactPage() {
  const [ searchProps, changeSearchProps] = useState<defs.ContactQueryDTO>({
    ...DEFAULT_SEARCH_PROPS,
  });

  const [pageData, setPageData] = useState<defs.Page<defs.ContactVO>>(
    DEFAULT_PAGE_DATA,
  );
  const [selectedRowKeys, selectRow] = useState<number[] | string[]>([]);
  const [visible, setVisible] = useState(false);
  const [loading, setLoading] = useState(false);
  const [contact, setContact] = useState<defs.ContactDTO | undefined>(
    undefined,
  );
  const fetchList = useCallback((props) => {
    setLoading(true);
    API.contact.list.request({}, props).then((data) => {
      setLoading(false);
      data && setPageData(data);
    });
  }, []);
  useEffect(() => {
    if (!pageData.total) {
      fetchList(searchProps);
    }
  }, []);

  const columns = [
    { title: '联系人ID', width: 80, dataIndex: 'id' },
    {
      title: '联系人姓名',
      dataIndex: 'contactName',
      render: (v: string, record: defs.ContactVO) => {
        return (
          <a
            onClick={() => {
              setContact({ ...record });
              setVisible(true);
            }}
          >
            <GroupOutlined />
            <span style={{ marginLeft: 5 }}>{v}</span>
          </a>
        );
      },
    },
    { title: '联系人工作单位',width: 300, dataIndex: 'contactUnit' },
    { title: '联系人电话号码', width: 150, dataIndex: 'contactNumber' },
    { title: '联系人省份', width: 100, dataIndex: 'contactProvince' },
    { title: '联系人邮箱', width: 150, dataIndex: 'contactEmail' },
    { title: '联系人住址', width: 300, dataIndex: 'contactLocation' },
    {
      title: '操作',
      width: 120,
      render: (_: any, record: defs.ContactVO) => (
        <>
          <a
            onClick={() => {
              setContact({ ...record });
              setVisible(true);
            }}
          >
            修改
          </a>
          <Divider type="vertical" />
          <a
            onClick={() => {
              handleDelete([`${record.id}`]);
            }}
          >
            删除
          </a>
        </>
      ),
    },
  ];

  const handleDelete = async (ids: string[] | number[]) => {
    const modal = Modal.confirm({
      centered: true,
      title: `您确定要删除选定的${ids.length}个联系人吗？`,
      okText: '确定',
      cancelText: '取消',
      onOk: async () => {
        modal.update({
          okButtonProps: {
            loading: true,
          },
        });
        const success = await API.contact.remove.request(
          {},
          ids as number[],
        );
        if (success) {
          message.success("删除成功！")
          fetchList({
            ...searchProps,
            page: 1,
          });
          selectRow([]);
        }
      },
    });
  };

  const handleSave = (values: defs.ContactDTO) => {
    let result: Promise<string>;
    if (contact?.id) {
      result = API.contact.update.request(
        {},
        {
          id: contact.id,
          ...values,
        },
      );
    } else {
      result = API.contact.add.request({}, values);
    }
    result.then(() => {
      setVisible(false);
      message.success('保存成功！');
      fetchList({
        ...searchProps,
      });
    });
  };

  const buttons: ButtonItem[] = [
    {
      text: '新增',
      icon: <FileAddOutlined />,
      type: 'primary',
      onClick: () => {
        setContact(undefined);
        setVisible(true);
      },
    },
    {
      text: '删除',
      icon: <DeleteOutlined />,
      disabled: selectedRowKeys.length === 0,
      type: 'primary',
      onClick: () => handleDelete(selectedRowKeys),
    },
  ];
  const { list, page, total } = pageData;
  return (
    <>
      <CustomTable
        loading={loading}
        columns={columns}
        buttons={buttons}
        dataSource={list || []}
        current={page}
        size="middle"
        total={total}
        genRowKey={(record: defs.ContactVO) => `${record.id}`}
        onPagination={(current: number) => {
          const newSearchProps = {
            ...searchProps,
            page: current,
          };
          changeSearchProps(newSearchProps);
          fetchList(newSearchProps);
        }}
        rowSelection={{
          columnTitle: '选择',
          columnWidth: 50,
          selectedRowKeys,
          onChange: (keys: string[]) => selectRow(keys),
        }}
      >
        <SearchFilter
          searchProps={searchProps}
          changeSearchProps={(props) => {
            changeSearchProps({
              ...searchProps,
              ...props,
            });
          }}
          onSearch={() => {
            fetchList(searchProps);
          }}
        />
      </CustomTable>

      <InputDialog
        visible={visible}
        detailData={contact}
        onClose={() => setVisible(false)}
        onSubmit={handleSave}
      />
    </>
  );
}