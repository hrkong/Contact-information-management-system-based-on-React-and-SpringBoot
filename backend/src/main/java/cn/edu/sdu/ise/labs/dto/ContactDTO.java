package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data

public class ContactDTO {
    private Integer id;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人工作单位
     */
    private String contactUnit;

    /**
     * 联系人电话号码
     */
    private String contactNumber;

    /**
     * 联系人省份
     */
    private String contactProvince;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 联系人地址
     */
    private String contactLocation;
}
