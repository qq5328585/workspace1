package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class FcsInfSgmt {
    //性别
    private String Sex;
    //出生日期
    private String DOB;
    //国籍
    private String Nation;
    //户籍地址
    private String HouseAdd;
    //户籍所在行政区划
    private String HhDist;
    //手机号码
    private String CellPhone;
    //电子邮箱
    private String Email;
    //信息更新日期
    private String FcsInfoUpDate;

}
