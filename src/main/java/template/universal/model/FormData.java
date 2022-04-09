package template.universal.model;

import java.util.Date;

public class FormData {
    private String submitId;
    private String submitIpAddress;
    private Date submitTime;
    private String submitContent;


    public FormData() {
    }

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

    public String getSubmitIpAddress() {
        return submitIpAddress;
    }

    public void setSubmitIpAddress(String submitIpAddress) {
        this.submitIpAddress = submitIpAddress;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitContent() {
        return submitContent;
    }

    public void setSubmitContent(String submitContent) {
        this.submitContent = submitContent;
    }
}
