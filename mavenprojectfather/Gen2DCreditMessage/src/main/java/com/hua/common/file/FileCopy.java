package com.hua.common.file;

import java.io.File;

public abstract class FileCopy {
    //文件拷贝缓冲区大小
    protected  int buffersize = 512*1024;

    protected FileIOHandler fileIOHandler;

    public void setBuffersize(int buffersize) {
        this.buffersize = buffersize;
    }

    public int getBuffersize() {
        return buffersize;
    }

    public FileIOHandler getFileIOHandler() {
        return fileIOHandler;
    }

    public void setFileIOHandler(FileIOHandler fileIOHandler) {
        this.fileIOHandler = fileIOHandler;
    }

    public abstract void transferFile(String des,String src) throws Exception;

    public abstract  void transferFile(File src,File des) throws Exception;

}
