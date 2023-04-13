package cn.edu.sdu.ise.labs.model;

public class Contact {
    private Integer id;

    private String contactName;

    private String contactUnit;

    private String contactNumber;

    private String contactProvince;

    private String contactEmail;

    private String contactLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactUnit() {
        return contactUnit;
    }

    public void setContactUnit(String contactUnit) {
        this.contactUnit = contactUnit == null ? null : contactUnit.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getContactProvince() {
        return contactProvince;
    }

    public void setContactProvince(String contactProvince) {
        this.contactProvince = contactProvince == null ? null : contactProvince.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContactLocation() {
        return contactLocation;
    }

    public void setContactLocation(String contactLocation) {
        this.contactLocation = contactLocation == null ? null : contactLocation.trim();
    }
}