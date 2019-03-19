package com.hua.ntr.entity.system;

public enum FileName {
    预留位("0"),
    反馈标识("0"),
    文件生成日期格式("yyyyMMdd"),
    文件生成时间格式("yyyyMMddHHmmss"),
    个人基本信息记录("110"),
    文件头起始标识("A050"),
    文件记录版本号("2.0.0"),
    信息记录模板类型("10"),
    数据提供机构区段码("12222222221111"),
    文件头预留位("0"),
    txt文件保存路径("D://upload//"),
    enc文件保存路径("D://upload//"),
    文件名流水号位数("3"),
    信息记录数("7"),
    txt文件后缀(".txt");


    private String value;

    FileName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
