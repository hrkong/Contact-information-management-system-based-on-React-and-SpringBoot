package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.ContactMapper;
import cn.edu.sdu.ise.labs.dto.ContactDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactQueryDTO;
import cn.edu.sdu.ise.labs.model.*;
import cn.edu.sdu.ise.labs.service.ContactService;
import cn.edu.sdu.ise.labs.service.utils.ContactUtils;
import cn.edu.sdu.ise.labs.service.vo.ContactVO;
import cn.edu.sdu.ise.labs.service.vo.ProvinceVO;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Resource
    private ContactMapper contactMapper;

    @Override
    public Page<ContactVO> listByPage(ContactQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new ContactQueryDTO();
        }
        queryDTO.setContactName(FormatUtils.makeFuzzySearchTerm(queryDTO.getContactName()));

        queryDTO.setContactEmail(FormatUtils.makeFuzzySearchTerm(queryDTO.getContactEmail()));
        queryDTO.setContactUnit(FormatUtils.makeFuzzySearchTerm(queryDTO.getContactUnit()));
        queryDTO.setContactProvince(FormatUtils.makeFuzzySearchTerm(queryDTO.getContactProvince()));
        queryDTO.setContactNumber(FormatUtils.makeFuzzySearchTerm(queryDTO.getContactNumber()));
        queryDTO.setContactLocation(FormatUtils.makeFuzzySearchTerm(queryDTO.getContactLocation()));


        Token token = TokenContextHolder.getToken();

        Integer size = contactMapper.count(queryDTO);
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<ContactVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            // 没有命中，则返回空数据。
            return pageData;
        }


        List<Contact> list = contactMapper.list(queryDTO, pageUtils.getOffset(), pageUtils.getLimit());
        for (Contact contact : list) {
            pageData.getList().add(ContactUtils.convertToVO(contact));
        }
        return pageData;

    }

    @Override
    public String addContact(ContactDTO contactDTO) {
        // 校验输入数据正确性
        ContactUtils.validateContact(contactDTO);

        // 创建实体对象，用以保存到数据库
        Contact contact = new Contact();

        // 将输入的字段全部复制到实体对象中
        BeanUtils.copyProperties(contactDTO, contact);

        // 调用DAO方法保存到数据库表
        contactMapper.insert(contact);
        return contact.getContactNumber();      //根据设计方案，添加一个联系人返回的是他的电话号码
    }

    @Override
    public String updateContact(ContactDTO contactDTO) {
        // 校验输入数据正确性
        Token token = TokenContextHolder.getToken();
        ContactUtils.validateContact(contactDTO);
        Assert.notNull(contactDTO.getContactName(), "联系人姓名不能为空");
        Assert.notNull(contactDTO.getContactNumber(), "联系人电话号码不能为空");
        Assert.notNull(contactDTO.getContactProvince(), "联系人省份不能为空");
        Contact contact = contactMapper.selectByPrimaryKey(contactDTO.getId());//利用ID作为筛选条件
        Assert.notNull(contact, "没有找到联系人，姓名为：" + contactDTO.getContactName());//提示没有找到的时候，提示姓名

        BeanUtils.copyProperties(contactDTO, contact);
        //contact.setUpdatedBy(token.getUserCode()); 先把设置更新时间的给注释了，暂时先不加这个了
        contactMapper.updateByPrimaryKey(contact);
        return contact.getContactName(); //原定要返回全部信息，现在先只返回一个name
    }


    @Override
    public void deleteByCodes(List<Integer> ids) {
        Assert.notEmpty(ids, "联系人id列表不能为空");
        contactMapper.deleteByCodes(ids);
    }


    @Override
    public Calculate<ProvinceVO> calculate() {
        Calculate<ProvinceVO> number = new Calculate<>(new ArrayList<>()); //定义一个动态数组，用于存储每个省份的人数
        List<Province> provinceList = contactMapper.calculate();
        for (Province province : provinceList) {
            ProvinceVO provinceVO = new ProvinceVO();
            BeanUtils.copyProperties(province, provinceVO);
            number.getList().add(provinceVO);
        }
        return number;
    }
}
