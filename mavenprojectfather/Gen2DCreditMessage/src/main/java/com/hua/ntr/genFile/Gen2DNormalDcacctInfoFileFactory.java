package com.hua.ntr.genFile;

import com.hua.ntr.entity.dcacct.record.DcacctDocument;
import com.hua.ntr.entity.system.FileInfo;

public class Gen2DNormalDcacctInfoFileFactory implements IGenFile<DcacctDocument> {
    @Override
    public IBuildFileInfo genFile(FileInfo fileInfo,DcacctDocument dcacctDocument) {
        return new Build2DNormalDcacctInfoFileInfo(fileInfo);
    }

    @Override
    public String getFileType() {
        return null;
    }
}
