package cn.edu.sdu.ise.labs.service.vo;

import lombok.Data;


@Data
public class ProvinceVO {
    /**
     * 省份统计计算
     */
    private String province;

    /**
     * 某个省份的联系人数量
     */
    private Integer number;
}
