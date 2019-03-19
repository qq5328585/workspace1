package com.hua.ntr.genFile;

import com.hua.common.FileEncAndDecUtil;
import com.hua.common.FileUtil;
import com.hua.common.document.JaxbUtil;
import com.hua.ntr.build.BuildIdentify;
import com.hua.ntr.entity.identify.record.IdentifyDocument;
import com.hua.ntr.entity.system.FileInfo;
import com.hua.ntr.entity.system.FileName;
import org.joda.time.DateTime;

import java.io.File;
import java.util.Date;

public class Gen2DFile {

    public static void gen2DNormalBaseinfoFile(){
        IGenFile genFileFactory = GenFileFactory.getInstance("110");
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFinanCode(FileName.数据提供机构区段码.getValue());
        fileInfo.setDate(new Date());
        fileInfo.setInfoType(FileName.个人基本信息记录.getValue());
        fileInfo.setFlowNum("1");
        fileInfo.setRecNum("1000");
        IdentifyDocument buildIdentify = BuildIdentify.build();
        IBuildFileInfo iBuildFileInfo = genFileFactory.genFile(fileInfo,buildIdentify);
        String fileName = iBuildFileInfo.buildFileName();
        String fileHead = iBuildFileInfo.buildFileHead();
        String fileBody = iBuildFileInfo.buildFileBody();

        //加密加压文件保存路径
        String zipFilePath = FileName.enc文件保存路径.getValue();
        //txt文件保存路径
        String txtFilePath = FileName.txt文件保存路径.getValue()+fileName;

        File f = new File(txtFilePath);

        if(f.exists()){
            f.delete();
        }

        f = FileUtil.create(txtFilePath);
        FileUtil.writeFileAppend(f,fileHead+"\r\n");

        for(int i=0;i< 1000;i++){
            FileUtil.writeFileAppend(f,fileBody+"\r\n");
        }

        FileEncAndDecUtil.encFile(f,zipFilePath);
    }

}
