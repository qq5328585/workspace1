package com.hua.common.compress;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 *  @author:
 *  @Date: 2019/3/15 11:13
 *  @Description: Gzip加解压
 */
public class GZipUtil {
    //文件加压缓冲区大小
    private static int bufferSize = 512*1024;

    public static void compressFile(String sourcePath,String destPath) throws IOException {
        GZIPOutputStream out = null;
        BufferedInputStream bis = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(destPath));
            //压缩输出流
            out = new GZIPOutputStream(fileOutputStream);
            bis = new BufferedInputStream(new FileInputStream(new File(sourcePath)));
            int count = 0;
            byte[] data = new byte[bufferSize];
            while((count=bis.read(data,0,bufferSize))!=-1){
                out.write(data,0,count);
            }
        }finally {
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(out);
        }
    }

    public static void decompressFile(String sourcePath,String destPath) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try{
            //解压输出流
            input = new GZIPInputStream(new FileInputStream(new File(sourcePath)));
            output = new FileOutputStream(new File(destPath));

            int count =0;
            byte data[] = new byte[bufferSize];
            while ((count=input.read(data,0,count))!=-1){
                output.write(data,0,count);
            }
        }finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
    }

    public static void compressFile(File sourcePath,File destPath) throws IOException {
        GZIPOutputStream out = null;
        BufferedInputStream bis = null;
        try {
            //加压输出流
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            out = new GZIPOutputStream(fileOutputStream);
            bis = new BufferedInputStream(new FileInputStream(sourcePath));
            int count = 0;
            byte[] data = new byte[bufferSize];
            while((count=bis.read(data,0,bufferSize))!=-1){
                out.write(data,0,count);
            }
        }finally {
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(out);
        }
    }

    public static void decompressFile(File sourcePath,File destPath) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try{
            //解压输入流
            input = new GZIPInputStream(new FileInputStream(sourcePath));
            output = new FileOutputStream(destPath);
            int count = 0;
            byte data[] = new byte[bufferSize];
            System.out.println("开始");
            while ((count = input.read(data,0,bufferSize))!= -1){

                System.out.println("写入"+count);
                output.write(data,0,count);
            }
            System.out.println("结束");
        }finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
    }

    public static void main(String[] args) throws IOException {
        File p = new File("D:\\upload\\112345678911112019037411000030.txt.zip");
        File t = new File("D:\\upload\\112345678911112019037411000030.txt");
        //GZipUtil.compressFile(t,p);
        GZipUtil.decompressFile(p,t);
    }
}
