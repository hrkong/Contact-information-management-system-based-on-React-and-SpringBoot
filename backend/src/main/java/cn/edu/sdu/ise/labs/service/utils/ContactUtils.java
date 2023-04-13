package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dto.ContactDTO;
import cn.edu.sdu.ise.labs.model.Contact;
import cn.edu.sdu.ise.labs.service.vo.ContactVO;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

public class ContactUtils {
    /**
     * 规范并校验contactDTO
     *
     * @param contactDTO
     */
    public static void validateContact(ContactDTO contactDTO) {         //用于检验输入数据的正确性，设计的时候要求姓名、省份、电话号不能为空
        FormatUtils.trimFieldToNull(contactDTO);
        Assert.notNull(contactDTO, "联系人输入数据不能为空");
        Assert.hasText(contactDTO.getContactName(), "联系人姓名不能为空");
        Assert.hasText(contactDTO.getContactNumber(), "联系人电话号码不能为空");
        Assert.hasText(contactDTO.getContactProvince(), "联系人省份不能为空");
    }

    /**
     * 将实体对象转换为VO对象
     *
     * @param contact 实体对象
     * @return VO对象
     */

    public static ContactVO convertToVO(Contact contact) {
        ContactVO contactVO = new ContactVO();
        BeanUtils.copyProperties(contact, contactVO);
     /*
     contactVO.setCreatedAt(FormatUtils.formatFullDate(contact..getCreatedAt()));   这里是时间转换，我没有使用这个
     contactVO.setUpdatedAt(FormatUtils.formatFullDate(department.getUpdatedAt()));
     */
        return contactVO;
    }


}
