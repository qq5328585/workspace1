package com.hua.common;

import com.hua.common.compress.GZipUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum  FileProcComponent {
    COMPRESS("compress","加压"),
    DECOMPRESS("decompress","解压"),
    ENCRYPT("encrypt","加密"),
    DECRYPT("decrypt","解密");

    private String name;
    private String message;
    private static String sm4Key = "0123456789abcdef";

    private FileProcComponent(String name,String message){
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
    /*
     *功能描述
     * @author 风清扬
     * @date 2019/3/15
     * @param [src, component, saveDir]
     * @return com.hua.common.ProcResult
     */
    public static ProcResult gzip(File src, FileProcComponent component, String saveDir){
        ProcResult procResult = new ProcResult();
        if(src == null || !src.exists()){
            procResult.setStatus("0");
            procResult.setErrorMsg("1");
        }

        File dstDir = new File(saveDir);
        if(!dstDir.exists() || !dstDir.isDirectory()){
            Date  date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String date2String = simpleDateFormat.format(date);
            String dstDirString = src.getParent()+"/"+date2String;
            dstDir = new File(dstDirString);
            if(!dstDir.exists()){
                dstDir.mkdirs();
            }
        }
        switch (component){
            case COMPRESS:
                procResult = gzipZip(src.getAbsolutePath(),dstDir.getAbsolutePath());
                break;
            case DECOMPRESS:
                procResult = gzipUnZip(src.getAbsolutePath(),dstDir.getAbsolutePath());
                break;
                default:
                    procResult.setFileName(src.getName());
                    procResult.setStatus("1");
                    procResult.setErrorMsg("1");
        }
        return procResult;
    }

    public static ProcResult sm4(File src, FileProcComponent component, String saveDir){
        ProcResult procResult = new ProcResult();
        if(src == null || !src.exists()){
            procResult.setStatus("0");
            procResult.setErrorMsg("1");
        }

        File dstDir = new File(saveDir);
        if(!dstDir.exists() || !dstDir.isDirectory()){
            Date  date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String date2String = simpleDateFormat.format(date);
            String dstDirString = src.getParent()+"/"+date2String;
            dstDir = new File(dstDirString);
            if(!dstDir.exists()){
                dstDir.mkdirs();
            }
        }
        switch (component){
            case ENCRYPT:
                procResult = sm4Encry(src.getAbsolutePath(),dstDir.getAbsolutePath());
                break;
            case DECRYPT:
                procResult = sm4Decrypt(src.getAbsolutePath(),dstDir.getAbsolutePath());
                break;
            default:
                procResult.setFileName(src.getName());
                procResult.setStatus("1");
                procResult.setErrorMsg("1");
        }
        return procResult;
    }

    private static ProcResult gzipZip(String src,String saveDir)  {
        ProcResult procResult = new ProcResult();
        File srcFile = new File(src);
        String srcFileName = srcFile.getName();
        File destFile = new File(saveDir+"/"+srcFileName+".zip");
        try{
            GZipUtil.compressFile(srcFile,destFile);
        }catch (Exception e){
            procResult.setFileName(srcFileName);
            procResult.setStatus("1");
            procResult.setErrorMsg("1");
            return  procResult;
        }
        procResult.setFileName(srcFileName);
        procResult.setStatus("0");
        procResult.setFilePath(destFile.getAbsolutePath());
        return  procResult;
    }

    private static ProcResult gzipUnZip(String src,String saveDir)  {
        ProcResult procResult = new ProcResult();
        File srcFile = new File(src);
        String srcFileName = srcFile.getName();
        String srcFileMainName = FileUtil.getFileMainName(srcFileName);
        File destFile = new File(saveDir+"/"+srcFileMainName);
        try{
            GZipUtil.decompressFile(srcFile,destFile);
        }catch (Exception e){
            procResult.setFileName(srcFileName);
            procResult.setStatus("1");
            procResult.setErrorMsg("1");
            return  procResult;
        }
        procResult.setFileName(srcFileName);
        procResult.setStatus("0");
        procResult.setFilePath(destFile.getAbsolutePath());
        return  procResult;
    }

    private static ProcResult sm4Encry(String src,String saveDir){
        ProcResult procResult = new ProcResult();
        File srcFile = new File(src);
        String srcFileName = srcFile.getName();
        String srcFileMainName = FileUtil.getFileMainName(FileUtil.getFileMainName(srcFileName));
        File destFile = new File(saveDir+"/"+srcFileMainName+".enc");
        SimpleSecurityProcess simpleSecurityProcess = new SimpleSecurityProcess();
        simpleSecurityProcess.setEncryptKey(sm4Key);
        try {
            simpleSecurityProcess.encryptFile(srcFile,destFile);
        }catch (Exception e){
            e.printStackTrace();
            procResult.setFileName(srcFileName);
            procResult.setStatus("1");
            procResult.setErrorMsg("1");
            return  procResult;
        }

        procResult.setFileName(srcFileName);
        procResult.setStatus("0");
        procResult.setFilePath(destFile.getAbsolutePath());
        return  procResult;
    }

    private static ProcResult sm4Decrypt(String src,String saveDir){
        ProcResult procResult = new ProcResult();
        File srcFile = new File(src);
        SimpleSecurityProcess simpleSecurityProcess = new SimpleSecurityProcess();
        simpleSecurityProcess.setDecryptKey(sm4Key);
        File destFile = null;
        try {
            destFile= simpleSecurityProcess.decryptFile(srcFile,saveDir);
        }catch (Exception e){
            procResult.setFileName(srcFile.getName());
            procResult.setStatus("1");
            procResult.setErrorMsg("1");
            return  procResult;
        }

        procResult.setFileName(srcFile.getName());
        procResult.setStatus("0");
        procResult.setFilePath(destFile.getAbsolutePath());
        return  procResult;
    }


}
