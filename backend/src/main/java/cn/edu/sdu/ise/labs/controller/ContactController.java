package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.ContactDTO;
import cn.edu.sdu.ise.labs.dto.query.ContactQueryDTO;
import cn.edu.sdu.ise.labs.model.Calculate;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.service.ContactService;
import cn.edu.sdu.ise.labs.service.vo.ContactVO;
import cn.edu.sdu.ise.labs.service.vo.ProvinceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("add")
    public String add(@RequestBody ContactDTO contactDTO) {
        return contactService.addContact(contactDTO);
    }

    @PostMapping("update")
    public String update(@RequestBody ContactDTO contactDTO) {
        return contactService.updateContact(contactDTO);
    }

    @PostMapping("delete")
    public Boolean delete(@RequestBody List<Integer> ids) {
        contactService.deleteByCodes(ids);
        return true;
    }

    @PostMapping("list")
    public Page<ContactVO> list(@RequestBody ContactQueryDTO queryDTO) {
        return contactService.listByPage(queryDTO);
    }

    @PostMapping("calculate")
    public Calculate<ProvinceVO> calculate() {
        return contactService.calculate();
    }


}