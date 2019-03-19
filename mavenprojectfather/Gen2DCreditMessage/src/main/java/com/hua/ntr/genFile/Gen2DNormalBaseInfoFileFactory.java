package com.hua.ntr.genFile;

import com.hua.ntr.entity.identify.record.IdentifyDocument;
import com.hua.ntr.entity.system.FileInfo;

public class Gen2DNormalBaseInfoFileFactory implements IGenFile<IdentifyDocument>{
    @Override
    public IBuildFileInfo genFile(FileInfo fileInfo,IdentifyDocument identifyDocument) {
        return new Build2DNormalBaseInfoFileInfo(fileInfo,identifyDocument);
    }

    @Override
    public String getFileType() {
        return "110";
    }
}
