package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class EduInfSgmt {
    //学历
    private String EduLevel;
    //学位
    private String AcaDegree;
    //信息更新日期
    private String EduInfoUpDate;
}
