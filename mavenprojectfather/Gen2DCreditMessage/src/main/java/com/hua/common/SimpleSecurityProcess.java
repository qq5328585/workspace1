package com.hua.common;

import java.io.File;
import java.io.IOException;

public class SimpleSecurityProcess implements ISecurityProcess {
    private String encryptKey = null;
    private String decryptKey = null;
    @Override
    public void encryptFile(File src, File deFile) throws Exception {
        if(encryptKey == null){
            throw  new  RuntimeException("null");
        }
        FileUtil.encryptFile(src,deFile,encryptKey);
    }

    @Override
    public File decryptFile(File src, String destDirPath) throws Exception {
        if(decryptKey == null){
            throw  new  RuntimeException("null");
        }
       return FileUtil.decryptFile(src,destDirPath,decryptKey);
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public void setDecryptKey(String decryptKey) {
        this.decryptKey = decryptKey;
    }

    public boolean isEncryptKeyNUll(){
        if(encryptKey == null){
            return true;
        }else{
            return false;
        }
    }

    public boolean isDecryptKeyNUll(){
        if(decryptKey == null){
            return true;
        }else{
            return false;
        }
    }
}
