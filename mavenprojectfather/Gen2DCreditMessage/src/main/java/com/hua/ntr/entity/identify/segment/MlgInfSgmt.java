package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class MlgInfSgmt {
    //通讯地址
    private String MailAddr;
    //通讯地址邮编
    private  String MailPc;
    //通讯地址行政区划
    private String MailDist;
    //信息更新日期
    private String MlgInfoUpDate;
}
