package cn.edu.sdu.ise.labs.dto.query;

import lombok.Data;

@Data

public class ContactQueryDTO extends PageQueryDTO {
    /**
     * 通过姓名、单位、电话号码、模糊匹配
     */
    private String contactName;

    private String contactUnit;

    private String contactNumber;

    private String contactProvince;

    private String contactEmail;

    private String contactLocation;
    
}
