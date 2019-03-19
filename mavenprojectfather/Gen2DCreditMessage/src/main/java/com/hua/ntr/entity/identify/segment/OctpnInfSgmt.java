package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class OctpnInfSgmt {
    //就业状况
    private String EmpStatus;
    //单位名称
    private String CpnName;
    //单位性质
    private String CpnType;
    //单位所属行业
    private String Industry;
    //单位详细地址
    private String CpnAddr;
    //单位所在地邮编
    private String CpnPc;
    //单位所在地行政区划
    private String CpnDist;
    //单位电话
    private String CpnTEL;
    //职业分类
    private String Occupation;
    //职务
    private String Title;
    //职称
    private String TechTitle;
    //本单位工作起始年份
    private String WorkStartDate;
    //信息更新日期
    private String OctpnInfoUpDate;

}
