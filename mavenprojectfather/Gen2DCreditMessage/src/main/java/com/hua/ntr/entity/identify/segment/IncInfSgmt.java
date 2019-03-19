package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class IncInfSgmt {
    //自报年收入
    private String AnnlInc;
    //纳税年收入
    private String TaxIncome;
    //信息更新日期
    private String IncInfoUpDate;
}
