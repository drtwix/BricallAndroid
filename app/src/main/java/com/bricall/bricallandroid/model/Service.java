package com.bricall.bricallandroid.model;

public class Service {

    private String service_id;



    private String  slug ;
    private String  service_name ;
    private String  service_job ;
    private String  service_img_url ;
    private boolean service_status ;

    public Service(String service_id, String slug, String service_name, String service_job, String service_img_url, boolean service_status) {
        this.service_id = service_id;
        this.slug = slug;
        this.service_name = service_name;
        this.service_job = service_job;
        this.service_img_url = service_img_url;
        this.service_status = service_status;
    }

    public Service() {

    }

    public String getService_id() {
        return this.service_id;

    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_job() {
        return service_job;
    }

    public void setService_job(String service_job) {
        this.service_job = service_job;
    }

    public String getService_img_url() {
        return service_img_url;
    }

    public void setService_img_url(String service_img_url) {
        this.service_img_url = service_img_url;
    }

    public boolean isService_status() {
        return service_status;
    }

    public void setService_status(boolean service_status) {
        this.service_status = service_status;
    }
}




