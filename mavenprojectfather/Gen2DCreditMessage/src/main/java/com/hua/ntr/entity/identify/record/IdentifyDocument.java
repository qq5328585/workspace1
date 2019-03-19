package com.hua.ntr.entity.identify.record;

import com.hua.ntr.entity.identify.record.IdentifyNormalRecord;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD) //属性映射成xml属性
@XmlRootElement(name="Document") //xml根节点
public class IdentifyDocument {
    @XmlElement(name = "InBasInf")
    private IdentifyNormalRecord identifyNormalRecord;

}
