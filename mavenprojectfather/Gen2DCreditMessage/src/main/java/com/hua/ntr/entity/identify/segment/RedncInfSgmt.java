package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class RedncInfSgmt {
    //居住状况
    private String ResiStatus;
    //居住地详细地址
    private String ResiAddr;
    //居住地邮编
    private String ResiPc;
    //居住地行政区划
    private String ResiDist;
    //住宅电话
    private String HomeTel;
    //信息更新日期
    private String ResiInfoUpDate;
}
