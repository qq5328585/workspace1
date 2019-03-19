package com.hua.common.file;

import java.io.IOException;

public interface FileIOHandler {

    public  void before();

    public byte[] process(byte[] buffer) throws Exception;

    public void after();



}
