package com.jbj.springdemo.entity;

public class ReturnCorpVO {

    private String corpInfo;
    private String accountInfo;
    private String projectName;
    private String status;

    public ReturnCorpVO(){}

    public ReturnCorpVO(String c, String a, String p,String s){
        this.corpInfo=c;
        this.accountInfo=a;
        this.projectName=p;
        this.status=s;
    }


    public String getCorpInfo() {
        return corpInfo;
    }

    public void setCorpInfo(String corpInfo) {
        this.corpInfo = corpInfo;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
