package com.hua.common;

import com.hua.common.compress.GZipUtil;
import com.hua.common.security.sm4.SM4Util;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileUtil {
    private  static  final  Object obj = new Object();
    public static File create(String filePath){
        File f = new File(filePath);
        if(!f.exists()){
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return  f;
    }

    public static void writeFileAppend(File file,String data){
        synchronized (obj){
            if(!file.exists()){
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                try{
                    file.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(!file.exists()  || !file.canWrite()){
                throw  new RuntimeException("文件有误");
            }

            BufferedWriter bufferedWriter = null;

            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
                bufferedWriter.write(data);

                bufferedWriter.flush();
            }catch (IOException e){

            }finally {
                IOUtils.closeQuietly(bufferedWriter);
            }
        }
    }
    //拷贝文件缓存大小
    private static  final  int BUFFER_SIZE = 524288;
    //填充位数的标记字符
    private static  final String BLANK_TAG = "#";
    //对称加密算法密钥长度
    private static  final  int SM4_KEY_LEN = 16;
    //加密文件后，放到文件末尾的加密前文件扩展名信息长度
    private static  final  int SERCET_CONTENT_LEN =10;

    public static void deleteFile(File file){
        if(file.exists()){
            file.delete();
        }
    }

    /*
     *功能描述 加压文件
     * @author 风清扬
     * @date 2019/3/15
     * @param [source, des]
     * @return void
     */
    public static void compressFile(File source,File des) throws IOException {
        GZipUtil.compressFile(source,des);
    }

    public static  void decompressFile(File source,File des) throws IOException {
        GZipUtil.decompressFile(source,des);
    }

    public static void encryptFile(File sourceFile,File destFile,String sm4PrivateKey) throws Exception {
        //sm4对称密钥
        String sm4key = sm4PrivateKey;
        SM4Util.encryptFile(sourceFile,destFile,sm4key);
        //组装文件信息和加密后的密钥信息
        String sourceName = sourceFile.getName();
        String fileExt = BLANK_TAG+sourceName.substring(sourceName.indexOf("."),sourceName.length());
        while (fileExt.length() < (SERCET_CONTENT_LEN)){
            fileExt += BLANK_TAG;
        }
        StringBuffer content = new StringBuffer();
        content.append(fileExt);
        //enc末尾文件必须是固定长度
        writeFileAppend(destFile,content.toString());

    }
    /*
     *功能描述 解密文件
     * @author 风清扬
     * @date 2019/3/15
     * @param [sourceFile, destDirPath, sm4PrivateKey]
     * @return java.io.File
     */
    public static File decryptFile(File sourceFile,String destDirPath,String sm4PrivateKey) throws Exception {
        if(sourceFile == null){
            throw  new IOException("Dest dir path is null");
        }
        File destDir = new File(destDirPath);
        if(!destDir.exists()){
            throw  new IOException("Dest dir not exist");
        }
        if(!destDir.isDirectory()){
            throw  new IOException("Dest is not a Directory");
        }
        String secret_content = getContentFormFile(sourceFile,SERCET_CONTENT_LEN);
        String sm4 = sm4PrivateKey;
        //得到加密前文件的扩展名
        String ext = secret_content.replace(BLANK_TAG,"");
        //构建临时文件，仅包含加密后文件的内容
        String sourceFileName = sourceFile.getName();
        String tempFilePath = destDir.getAbsolutePath()+"/"+sourceFileName+".temp";
        File tempFile = new File(tempFilePath);
        if(!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdirs();
        }

        //得到加密后文件文件内容，并组成一个新文件
        deleteEncInfoFormFileAsNew(sourceFile,tempFile);
        File destFile;

        try{
            //构建解密后文件
            String destFilePath = destDir.getAbsolutePath()+"/"+sourceFileName.substring(0,sourceFileName.indexOf("."))+ext;
            destFile = new File(destFilePath);
            if(!destFile.exists()){
                destFile.getParentFile().mkdirs();
            }
            SM4Util.decryptFile(tempFile,destFile,sm4);
        }finally {
            //无论解密成功与否，都要删除临时文件
            FileUtil.deleteFile(tempFile);
        }
        return destFile;
    }
    /*
     *功能描述 以流的形式添加内容到文件末尾，固定长度
     * @author 风清扬
     * @date 2019/3/15
     * @param [src, content]
     * @return void
     */
    private  static  void appendContent2File(File src,String content) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try{
            //打开一个随机访问文件流
            randomAccessFile = new RandomAccessFile(src,"rw");
            //文件长度，字节数
            long fileLength = randomAccessFile.length();
            //将文件指针移动到文件尾
            randomAccessFile.seek(fileLength);
            String conStr = new String(content.getBytes("utf-8"),"ISO8859-1");
            randomAccessFile.writeBytes(conStr);
        }finally {
            if(randomAccessFile != null){
                randomAccessFile.close();
            }

        }
    }
    /*
     *功能描述 从文件尾读取内容，固定长度
     * @author 风清扬
     * @date 2019/3/15
     * @param [src, length]
     * @return java.lang.String
     */
    public static String getContentFormFile(File sourceFile,int length){
        String content = null;
        try{
            //打开一个随机文件流，按读的方式
            RandomAccessFile randomAccessFile = new RandomAccessFile(sourceFile,"r");
            //文件长度
            long fileLength = randomAccessFile.length();
            //将文件指针移动到末尾
            randomAccessFile.seek(fileLength-length);
            byte[] bufferArr = new byte[length];
            randomAccessFile.read(bufferArr);
            content = new String(bufferArr,"UTF-8");
            randomAccessFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  content;
    }
    /*
     *功能描述  从文件删除附加信息，构建临时文件
     * @author 风清扬
     * @date 2019/3/15
     * @param [src, des]
     * @return void
     */
    private static void deleteEncInfoFormFileAsNew(File sourceFile,File destFile) throws IOException {
        RandomAccessFile randomAccessFile =null,fileCopy = null;
        Long startPos = 0L;
        Long endPos = 0L;
        try{
            //按读方式打开源文件流
            randomAccessFile = new RandomAccessFile(sourceFile,"r");
            //文件长度，字节数
            long fileLength = randomAccessFile.length();
            endPos = fileLength-SERCET_CONTENT_LEN;
            if(endPos <=0){
                throw new IOException("无法读取文件");
            }

            //安读写方式打开目标文件夹
            fileCopy = new RandomAccessFile(destFile,"rw");
            //分配缓存
            Long buffer_size = endPos < BUFFER_SIZE?endPos:BUFFER_SIZE;
            byte[] bufferArr = new byte[buffer_size.intValue()];
            //copy file
            while (startPos < endPos){
                if(endPos-startPos < buffer_size){
                    bufferArr = new byte[Long.valueOf(endPos-startPos).intValue()];
                }
                randomAccessFile.read(bufferArr);
                fileCopy.write(bufferArr);
                startPos = startPos + BUFFER_SIZE;
            }
        }finally {
            if(randomAccessFile != null){
                randomAccessFile.close();
            }
            if(null != fileCopy){
                fileCopy.close();
            }
        }
    }
    //获取不包含路径和后后缀的文件名
    public static final String getFileMainName(String fileName){
        int slashLastIndex = fileName.lastIndexOf("/");
        int dotLastIndex = fileName.lastIndexOf(".");
        if(slashLastIndex < 0){
            if(dotLastIndex < 0){
                return  fileName;
            }else{
                return  fileName.substring(0,dotLastIndex);
            }
        }else {
            if(dotLastIndex < 0){
                return  fileName.substring(slashLastIndex+1);
            }else{
                if(slashLastIndex >=dotLastIndex){
                    return  "";
                }
                return fileName.substring(slashLastIndex+1,dotLastIndex);
            }
        }
    }




}
