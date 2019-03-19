package com.hua.ntr.entity.identify.record;

import com.hua.ntr.entity.identify.segment.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentifyNormalRecord {
    //
    @XmlTransient //不需要被映射成xml节点的
    private String xxx;
    //基础段
    @XmlElement(name = "BsSgmt") //如果需要的xml节点和定义的变量不一致
    private BsSgmt BsSgmt;
    //标识段
    private IDSgmt IDSgmt;
    //基本概况信息段
    private FcsInfSgmt FcsInfSgmt;
    //教育信息段
    private EduInfSgmt EduInfSgmt;
    //职业信息段
    private OctpnInfSgmt OctpnInfSgmt;
    //居住信息段
    private RedncInfSgmt RedncInfSgmt;
    //通讯地址段
    private MlgInfSgmt MlgInfSgmt;
    //配偶信息段
    private SpsInfSgmt SpsInfSgmt;
    //收入信息段
    private  IncInfSgmt IncInfSgmt;



}
