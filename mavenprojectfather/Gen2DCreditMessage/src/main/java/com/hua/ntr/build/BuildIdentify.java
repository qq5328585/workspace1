package com.hua.ntr.build;

import com.hua.ntr.entity.identify.record.IdentifyDocument;
import com.hua.ntr.entity.identify.record.IdentifyNormalRecord;
import com.hua.ntr.entity.identify.segment.*;

import java.util.ArrayList;
import java.util.List;

public class BuildIdentify {

    public static IdentifyDocument build() {
        IdentifyDocument identifyDocument = new IdentifyDocument();

        IdentifyNormalRecord identifyNormalRecord = new IdentifyNormalRecord();

        BsSgmt bsSgmt = new BsSgmt();
        bsSgmt.setIDType("110");
        bsSgmt.setCimoc("11");
        bsSgmt.setName("张三");
        bsSgmt.setIDType("10");
        bsSgmt.setIDNum("14011444400000000");
        bsSgmt.setInfSurcCode("A1011111111111");
        bsSgmt.setRptDate("2011-01-19");
        bsSgmt.setRptDateCode("10");
        bsSgmt.setCustomerType("11");
        identifyNormalRecord.setBsSgmt(bsSgmt);
        //标识段
        IDSgmt iDSgmt = new IDSgmt();
        iDSgmt.setIDInfoUpdate("2011-01-19");
        iDSgmt.setIDNum("1");
        List<IDRec> list = new ArrayList<IDRec>();
        IDRec idRec = new IDRec();
        idRec.setAlias("李四");
        idRec.setOthIDNum("1111111111");
        idRec.setOthIDType("1");
        list.add(idRec);
        iDSgmt.setIDRec(list);
        identifyNormalRecord.setIDSgmt(iDSgmt);

        //基本概况信息段
        FcsInfSgmt fcsInfSgmt = new FcsInfSgmt();
        fcsInfSgmt.setSex("2");
        fcsInfSgmt.setDOB("1990-11-09");
        fcsInfSgmt.setNation("CHN");
        fcsInfSgmt.setHouseAdd("详细信息地址");
        fcsInfSgmt.setHhDist("075100");
        fcsInfSgmt.setCellPhone("19009999");
        fcsInfSgmt.setEmail("73770@qq.com");
        fcsInfSgmt.setFcsInfoUpDate("2011-01-19");
        identifyNormalRecord.setFcsInfSgmt(fcsInfSgmt);

        //教育信息段
        EduInfSgmt eduInfSgmt = new EduInfSgmt();
        eduInfSgmt.setEduLevel("10");
        eduInfSgmt.setAcaDegree("4");
        eduInfSgmt.setEduInfoUpDate("2011-01-19");
        identifyNormalRecord.setEduInfSgmt(eduInfSgmt);

        //职业信息段
        OctpnInfSgmt octpnInfSgmt = new OctpnInfSgmt();
        octpnInfSgmt.setEmpStatus("11");
        octpnInfSgmt.setCpnName("中证");
        octpnInfSgmt.setCpnType("10");
        octpnInfSgmt.setIndustry("C");
        octpnInfSgmt.setCpnAddr("");
        octpnInfSgmt.setCpnPc("");
        octpnInfSgmt.setCpnDist("");
        octpnInfSgmt.setCpnTEL("");
        octpnInfSgmt.setOccupation("0");
        octpnInfSgmt.setTitle("2");
        octpnInfSgmt.setTechTitle("1");
        octpnInfSgmt.setWorkStartDate("");
        octpnInfSgmt.setOctpnInfoUpDate("2011-09-11");
        identifyNormalRecord.setOctpnInfSgmt(octpnInfSgmt);

        //居住信息段
        RedncInfSgmt redncInfSgmt = new RedncInfSgmt();
        redncInfSgmt.setResiStatus("1");
        redncInfSgmt.setResiAddr("中国");
        redncInfSgmt.setResiPc("10222");
        redncInfSgmt.setResiDist("110102");
        redncInfSgmt.setHomeTel("111");
        redncInfSgmt.setResiInfoUpDate("2011-12-12");
        identifyNormalRecord.setRedncInfSgmt(redncInfSgmt);

        //通讯地址段
        MlgInfSgmt mlgInfSgmt = new MlgInfSgmt();
        mlgInfSgmt.setMailAddr("天津");
        mlgInfSgmt.setMailPc("111");
        mlgInfSgmt.setMailDist("111");
        mlgInfSgmt.setMlgInfoUpDate("2011-09-09");
        identifyNormalRecord.setMlgInfSgmt(mlgInfSgmt);

        //配偶信息段
        SpsInfSgmt spsInfSgmt = new SpsInfSgmt();
        spsInfSgmt.setMariStatu("20");
        spsInfSgmt.setSpoName("王华");
        spsInfSgmt.setSpoIDType("10");
        spsInfSgmt.setSpoIDNum("122");
        spsInfSgmt.setSpoTel("139");
        spsInfSgmt.setSpsCmpyNm("");
        spsInfSgmt.setSpsInfoUpDate("2011-01-09");
        identifyNormalRecord.setSpsInfSgmt(spsInfSgmt);

        //收入信息段
        IncInfSgmt incInfSgmt = new IncInfSgmt();
        incInfSgmt.setAnnlInc("100");
        incInfSgmt.setTaxIncome("1000");
        incInfSgmt.setIncInfoUpDate("2011-09-09");
        identifyNormalRecord.setIncInfSgmt(incInfSgmt);

        identifyDocument.setIdentifyNormalRecord(identifyNormalRecord);

        return  identifyDocument;
    }

}
