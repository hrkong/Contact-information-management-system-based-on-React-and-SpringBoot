/*
 * @文件描述: 首页
 * @公司: 山东大学
 * @作者: 李洪文
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2019-05-09 15:40:17
 * @LastEditTime: 2022-06-11 14:21:00
 */
import { useEffect } from 'react';
import styles from './index.less';
import { Input, Form, Modal } from 'antd';
import { useForm } from 'antd/lib/form/Form';
const layout = {
  labelCol: {
    span: 6,   //控制新增和修改联系人时每行首位与左侧边框的距离
  },
  wrapperCol: { span: 20 },   //控制新增和修改联系人时每个输入框的长度
};
const { TextArea } = Input;
export interface HomepageProps {
  visible: boolean;
  detailData?: defs.ContactDTO;
  onClose: () => void;
  onSubmit: (data: defs.ContactDTO) => void;
}

export default function InputForm(props: HomepageProps) {
  const [form] = useForm();
  useEffect(() => {
    if (props.detailData) {
      form.setFieldsValue(props.detailData);
    } else {
      form.resetFields();
    }
  }, [props.detailData, props.visible]);

  const onFinish = (values: any) => {
    props.onSubmit(values);
  };
  return (
    <Modal
      title={!!props.detailData ? '修改联系人' : '新增联系人'}
      visible={props.visible}
      width={600}
      okText="确定"
      centered
      getContainer={false}
      onCancel={() => {
        props.onClose();
      }}
      onOk={form.submit}
    >
      <Form
        {...layout}
        name="basic"
        form={form}
        className={styles.form}
        onFinish={onFinish}
      >
        <Form.Item
          label="联系人姓名："
          name="contactName"
          rules={[{ required: true, message: '请输入联系人姓名' }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="联系人电话号码："
          name="contactNumber"
          rules={[{ required: true, message: '请输入联系人电话号码' }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="联系人省份："
          name="contactProvince"
          rules={[{ required: true, message: '请输入联系人省份' }]}
        >
          <Input />
        </Form.Item>

        <Form.Item label="联系人工作单位：" name="contactUnit">
          <Input />
        </Form.Item>

        <Form.Item label="联系人邮箱：" name="contactEmail">
          <Input />
        </Form.Item>

        <Form.Item label="联系人住址：" name="contactLocation">
          <TextArea
            rows={1}
            placeholder="详细地址"
            allowClear={true}
            onChange={() => {}}
          />
        </Form.Item>
      </Form>
    </Modal>
  );
}

