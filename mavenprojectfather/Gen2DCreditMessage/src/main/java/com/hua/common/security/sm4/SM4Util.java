package com.hua.common.security.sm4;

import com.hua.common.ArrayUtil;
import com.hua.common.security.Base64Util;
import com.hua.common.file.FileCopy;
import com.hua.common.file.StreamFileCopyWithBuffer;

import java.io.*;
import java.util.Arrays;

public class SM4Util {

    private static final  int DEFAULT_BUFFER_SIZE = 512 * 1024;

    public static void encryptFile(File src, File des, String key, int blockSize) throws Exception {
        FileCopy fileCopy = new StreamFileCopyWithBuffer();
        fileCopy.setBuffersize(blockSize);
        SM4EncryptHandler handler = new SM4EncryptHandler();
        handler.setKey(key);
        fileCopy.setFileIOHandler(handler);
        fileCopy.transferFile(src,des);
    }

    public static void encryptFile(File src,File dec,String key) throws Exception {
        SM4Util.encryptFile(src,dec,key,DEFAULT_BUFFER_SIZE);
    }
    /*
     *功能描述 解密文件
     * @author 风清扬
     * @date 2019/3/15
     * @param [src, des, key, blockSize]
     * @return void
     */
    public static void decryptFile(File src ,File des,String key,int blockSize) throws Exception {
        FileCopy fileCopy = new StreamFileCopyWithBuffer();
        //sm4加密后增加16字节
        fileCopy.setBuffersize(blockSize+16);
        SM4DencryptHandler sm4DencryptHandler = new SM4DencryptHandler();
        sm4DencryptHandler.setKey(key);
        fileCopy.setFileIOHandler(sm4DencryptHandler);
        fileCopy.transferFile(src,des);
    }

    public static void decryptFile(File src,File des,String key) throws Exception {
        SM4Util.decryptFile(src,des,key,DEFAULT_BUFFER_SIZE);
    }
    /*
     *功能描述 加密字符串
     * @author 风清扬
     * @date 2019/3/15
     * @param [src utf-8, key]
     * @return java.lang.String Base64编码
     */
    public static  String encryptString(String strSrc,String key) throws Exception {
        SM4EncryptHandler sm4EncryptHandler = new SM4EncryptHandler();
        byte[] bSrc = strSrc.getBytes("UTF-8");
        sm4EncryptHandler.setKey(key);
        byte[] buff = new byte[DEFAULT_BUFFER_SIZE];
        int size = 0;
        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            in = new ByteArrayInputStream(bSrc);
            out = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
            while ((size=in.read(buff))!=-1){
                out.write(sm4EncryptHandler.process(ArrayUtil.copyOfRange(buff,0,size)));
            }
            byte[] bDest = out.toByteArray();
            return Base64Util.encode(bDest);
        }finally {
            in.close();
            out.close();
        }
    }

    public static  String decryptString(String src,String key) throws Exception {
        SM4DencryptHandler sm4DencryptHandler = new SM4DencryptHandler();
        byte[] bSrc = Base64Util.decode(src);
        sm4DencryptHandler.setKey(key);
        byte[] buff = new byte[DEFAULT_BUFFER_SIZE+16];
        int size = 0;
        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            in = new ByteArrayInputStream(bSrc);
            out = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE+16);
            while ((size=in.read(buff))!=-1){
                out.write(sm4DencryptHandler.process(ArrayUtil.copyOfRange(buff,0,size)));
            }
            byte[] bDest = out.toByteArray();
            return new String(bDest,"UTF-8");
        }finally {
            in.close();
            out.close();
        }
    }

}
