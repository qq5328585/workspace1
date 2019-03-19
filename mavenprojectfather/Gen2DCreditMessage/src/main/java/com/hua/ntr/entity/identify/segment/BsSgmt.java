package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class BsSgmt {
    //信息记录类型
    private String InfRecType;
    //信息来源编码
    private String InfSurcCode;
    //信息报告日期
    private String RptDate;
    //报告时点说明代码
    private String RptDateCode;
    //姓名
    private String Name;
    //证件类型
    private String IDType;
    //证件号码
    private String IDNum;
    //客户资料维护机构代码
    private String Cimoc;
    //客户资料类型
    private String CustomerType;

}
