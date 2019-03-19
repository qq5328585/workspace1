package com.hua.ntr.entity.system;

import org.joda.time.DateTime;

import java.util.Date;

public class FileInfo {

    private String finanCode;

    private String infoType;

    private String fileType;

    private String txtFileDir;

    private String encFileDir;

    private Date date;

    private String flowNum;

    private String recNum;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTxtFileDir() {
        return txtFileDir;
    }

    public void setTxtFileDir(String txtFileDir) {
        this.txtFileDir = txtFileDir;
    }

    public String getEncFileDir() {
        return encFileDir;
    }

    public void setEncFileDir(String encFileDir) {
        this.encFileDir = encFileDir;
    }

    public String getFinanCode() {
        return finanCode;
    }

    public void setFinanCode(String finanCode) {
        this.finanCode = finanCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public String getRecNum() {
        return recNum;
    }

    public void setRecNum(String recNum) {
        this.recNum = recNum;
    }
}
