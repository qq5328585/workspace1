package com.hua.ntr.genFile;

import com.hua.ntr.entity.system.FileInfo;

public interface IGenFile<T> {

    IBuildFileInfo genFile(FileInfo fileInfo,T o);

    String getFileType();


}
