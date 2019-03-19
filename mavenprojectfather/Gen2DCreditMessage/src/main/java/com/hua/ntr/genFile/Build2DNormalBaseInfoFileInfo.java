package com.hua.ntr.genFile;

import com.hua.common.document.JaxbUtil;
import com.hua.ntr.build.BuildFileInfo;
import com.hua.ntr.entity.identify.record.IdentifyDocument;
import com.hua.ntr.entity.system.FileInfo;

public class Build2DNormalBaseInfoFileInfo implements IBuildFileInfo {
    private FileInfo fileInfo;

    private IdentifyDocument identifyDocument;

    public Build2DNormalBaseInfoFileInfo(FileInfo fileInfo,IdentifyDocument identifyDocument){
        this.fileInfo = fileInfo;
        this.identifyDocument = identifyDocument;
    }

    @Override
    public String buildFileName() {
        String fileName = BuildFileInfo.getFileName(fileInfo);
        return fileName;
    }

    @Override
    public String buildFileHead() {
        String fileHead = BuildFileInfo.getFileHead(fileInfo);
        return fileHead;
    }

    @Override
    public String buildFileBody() {
        String s = JaxbUtil.convertToXml(identifyDocument);
        return s;
    }
}
