package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.query.ContactQueryDTO;
import cn.edu.sdu.ise.labs.model.Contact;
import cn.edu.sdu.ise.labs.model.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

    Integer count(ContactQueryDTO queryDTO);

    /**
     * 根据查询条件获取部门列表
     *
     * @param queryDTO 查询条件
     * @param offset   开始位置
     * @param limit    记录数量
     * @return 部门列表
     */
    List<Contact> list(@Param("queryDTO") ContactQueryDTO queryDTO, @Param("offset") Integer offset, @Param("limit") Integer limit
    );

    void deleteByCodes(@Param("codeList") List<Integer> codeList);

    List<Province> calculate();
}