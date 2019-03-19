package com.hua.ntr.build;

import com.hua.ntr.entity.system.FileInfo;
import com.hua.ntr.entity.system.FileName;
import com.hua.utils.DateUtil;
import com.hua.utils.StringUtils;
import org.joda.time.DateTime;

public class BuildFileInfo {
    /*
     *功能描述 文件名数据提供区段码 1-14 征信中心提供
     *  文件生成日期 15-22 YYYYMMDD
     *  所含记录类型 23-25
     *  预留位26 统一填0
     *  流水号27-29
     *  反馈标识，对于数据报送文件统一填0
     * @author 风清扬
     * @date 2019/3/18
     * @param [finanCode, dateTime, infoType]
     * @return java.lang.String
     */
    public static String getFileName(FileInfo f){
        StringBuffer sb = new StringBuffer();
        //数据提供区段码 1-14 征信中心提供
        sb.append(f.getFinanCode());
        //文件生成日期 15-22 YYYYMMDD
        String fileCreateDate =DateUtil.date2String(FileName.文件生成日期格式.getValue(),f.getDate());
        sb.append(fileCreateDate);
        //所含记录类型 23-25
        sb.append(f.getInfoType());
        //预留位26 统一填0
        sb.append(FileName.预留位.getValue());
        //流水号27-29,此处需考虑如何实现
        sb.append(StringUtils.autoGenCode(f.getFlowNum(),Integer.valueOf(FileName.文件名流水号位数.getValue())));
        //反馈标识，对于数据报送文件统一填0
        sb.append(FileName.反馈标识.getValue());
        sb.append(FileName.txt文件后缀.getValue());
        return  sb.toString();
    }
    /*
     *功能描述 文件头文件起始标识用
     *  1-1A标识，
     *  2-4文件头长度，
     *  5-7所含记录类型，
     *  8-12信息记录版本号，
        13-14信息记录模板类型
        15-28数据提供机构区段码，
        29-42文件生成时间YYYYMMDDHHMMSS,
        43-43预留位填0
        信息记录数 44-50不足7位的左侧用0补齐
     * @author 风清扬
     * @date 2019/3/18
     * @param []
     * @return java.lang.String
     */
    public static String getFileHead(FileInfo f){

        StringBuffer sb = new StringBuffer();
        sb.append(FileName.文件头起始标识.getValue());
        sb.append(f.getInfoType());
        sb.append(FileName.文件记录版本号.getValue());
        sb.append("  ");
        sb.append(FileName.信息记录模板类型.getValue());
        sb.append(f.getFinanCode());
        String fileCreateDate =DateUtil.date2String(FileName.文件生成时间格式.getValue(),f.getDate());
        sb.append(fileCreateDate);
        sb.append(FileName.文件头预留位.getValue());
        sb.append(StringUtils.autoGenCode(f.getRecNum(),Integer.valueOf(FileName.信息记录数.getValue())));
        return  sb.toString();
    }

}
