package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class IDRec {
    //姓名
    private String Alias;
    //证件类型
    private String OthIDType;
    //证件号码
    private String OthIDNum;
}
