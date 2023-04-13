package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.StudentsMapper;
import cn.edu.sdu.ise.labs.dto.StudentDTO;
import cn.edu.sdu.ise.labs.model.Students;
import cn.edu.sdu.ise.labs.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public void add(StudentDTO studentDTO) {
        Assert.hasText(studentDTO.getName(), "");
        Students students = new Students();
        BeanUtils.copyProperties(studentDTO, students);
        studentsMapper.insert(students);
        
    }
}
