package com.hua.ntr.entity.identify.segment;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class IDSgmt {
    //其他标识个数
    private String IDNum;
    //
    private List<IDRec> IDRec;
    //信息更新日期
    private String IDInfoUpdate;


}
