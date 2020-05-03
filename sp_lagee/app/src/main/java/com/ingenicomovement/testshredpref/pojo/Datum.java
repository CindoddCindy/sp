
package com.ingenicomovement.testshredpref.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("positionName")
    @Expose
    private Object positionName;
    @SerializedName("warehouseCode")
    @Expose
    private Object warehouseCode;
    @SerializedName("warehouseName")
    @Expose
    private Object warehouseName;
    @SerializedName("project")
    @Expose
    private List<Project> project = new ArrayList<Project>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param positionName
     * @param password
     * @param phone
     * @param project
     * @param id
     * @param fullname
     * @param warehouseName
     * @param email
     * @param warehouseCode
     * @param username
     */
    public Datum(String id, String username, Object password, String fullname, Object email, Object phone, Object positionName, Object warehouseCode, Object warehouseName, List<Project> project) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.positionName = positionName;
        this.warehouseCode = warehouseCode;
        this.warehouseName = warehouseName;
        this.project = project;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getPositionName() {
        return positionName;
    }

    public void setPositionName(Object positionName) {
        this.positionName = positionName;
    }

    public Object getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(Object warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Object getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(Object warehouseName) {
        this.warehouseName = warehouseName;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

}
