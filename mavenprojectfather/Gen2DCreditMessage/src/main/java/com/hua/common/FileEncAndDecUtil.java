package com.hua.common;

import java.io.File;

public class FileEncAndDecUtil {

    public static  void encFile(File txtFile, String encFileSaveDir){
        File zipFile = null;
        try{
            ProcResult zip = FileProcComponent.gzip(txtFile,FileProcComponent.COMPRESS,encFileSaveDir);
            zipFile = new File(zip.getFilePath());
            FileProcComponent.sm4(zipFile,FileProcComponent.ENCRYPT,encFileSaveDir);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(zipFile.exists()){
                zipFile.delete();
            }
        }

    }

    public static  void decFile(File encFile, String decFileSaveDir){
        File zipFile = null;
        try{
            ProcResult sm4 = FileProcComponent.sm4(encFile,FileProcComponent.DECRYPT,decFileSaveDir);

            zipFile = new File(sm4.getFilePath());

            ProcResult zip = FileProcComponent.gzip(zipFile,FileProcComponent.DECOMPRESS,decFileSaveDir);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(zipFile.exists()){
                zipFile.delete();
            }
            if(encFile.exists()){
                encFile.delete();
            }
        }

    }
}
