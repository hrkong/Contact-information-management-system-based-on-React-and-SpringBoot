package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.List;

@Data
public class Calculate<T> {
    private List<T> list;

    public Calculate(List<T> dtoList) {
        this.setList(dtoList);
    }
}