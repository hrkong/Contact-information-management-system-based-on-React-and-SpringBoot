package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.ContactDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactQueryDTO;
import cn.edu.sdu.ise.labs.model.Calculate;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.service.vo.ContactVO;
import cn.edu.sdu.ise.labs.service.vo.ProvinceVO;

import java.util.List;

public interface ContactService {
    Page<ContactVO> listByPage(ContactQueryDTO queryDTO);

    /**
     * 新建部门
     *
     * @param contactDTO 部门输入对象
     * @return 部门编码
     */
    String addContact(ContactDTO contactDTO);

    /**
     * 更新部门数据
     *
     * @param contactDTO 部门输入对象
     * @return 部门编码
     */
    String updateContact(ContactDTO contactDTO);

    /**
     * 根据编码列表，批量删除部门
     *
     * @param ids 编码列表
     */
    void deleteByCodes(List<Integer> ids);

    /*
     * 计算省份联系人分布
     *
     *
     * @return 数量
     */
    Calculate<ProvinceVO> calculate();
}
