package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class SpsInfSgmt {
    //婚姻状况
    private String MariStatu;
    //配偶姓名
    private String SpoName;
    //配偶证件类型
    private String SpoIDType;
    //配偶证件号码
    private String SpoIDNum;
    //配偶联系电话
    private String SpoTel;
    //配偶工作单位
    private String SpsCmpyNm;
    //信息更新日期
    private String SpsInfoUpDate;


}
