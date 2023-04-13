package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.StudentDTO;
import cn.edu.sdu.ise.labs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 孔浩然
 * @description
 * @date 2022/04/19 20：45
 */

@RestController
@RequestMapping("students")
public class StudentController {       //public class的类名必须和我们的文件名一致

    @Autowired
    private StudentService studentService;  //private类型的数据成员只能在定义的时候修改，其余任何地方都不可以，该类的对象也不可以

    @PostMapping("add")
    public boolean add(@RequestBody StudentDTO studentDTO) {
        studentService.add(studentDTO);
        return true;
    }
}
