package edu.soa.monitorserver.client.model;

/**
 * Created by ignacio on 18/08/14.
 */
public class JsonBoolean {

    private String status;
    private String errorDetail;

    public JsonBoolean(){
    }

    public JsonBoolean(String status, String errorDetail) {
        this.status = status;
        this.errorDetail = errorDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
