package com.hua.common;

import java.io.File;
import java.io.IOException;

public interface ISecurityProcess {
    public void encryptFile(File src,File deFile) throws Exception;

    public File decryptFile(File src,String destDirPath) throws Exception;

}
