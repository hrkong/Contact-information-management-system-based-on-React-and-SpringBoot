package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.TestMapper;
import cn.edu.sdu.ise.labs.dto.query.DepartmentQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Test;
import cn.edu.sdu.ise.labs.service.TestService;
import cn.edu.sdu.ise.labs.service.vo.DepartmentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @author 李洪文
 * @date 2021-03-13
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public Page<DepartmentVO> listByPage(DepartmentQueryDTO queryDTO) {
        return null;
    }

    @Override
    public String add(String name, String persId) {
        Test test = new Test();
        test.setName(name);
        test.setPersId(persId);
        testMapper.insert(test);
        return name;
    }
}
