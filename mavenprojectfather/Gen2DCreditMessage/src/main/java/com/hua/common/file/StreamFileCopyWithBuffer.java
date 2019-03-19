package com.hua.common.file;

import com.hua.common.file.FileCopy;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;

/**
 *  @author:
 *  @Date: 2019/3/15 15:07
 *  @Description: 文件拷贝
 */
public class StreamFileCopyWithBuffer extends FileCopy {
    public void transferFile(String des, String src) throws Exception {
        BufferedInputStream in = null;
        FileOutputStream out = null;
        try {
            if (fileIOHandler != null) {
                fileIOHandler.before();
            }

            File filein = new File(src);
            File fileOut = new File(des);

            FileInputStream fin = new FileInputStream(filein);
            in = new BufferedInputStream(fin);
            out = new FileOutputStream(fileOut);
            byte[] buffer = new byte[buffersize];
            int size = 0;
            while ((size = in.read(buffer)) != -1) {
                //如果需要对byte[]处理将数组拷贝一份
                if (fileIOHandler != null) {
                    out.write(fileIOHandler.process(Arrays.copyOfRange(buffer, 0, size)));
                } else {
                    out.write(buffer);
                }
            }
        }finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            if(fileIOHandler != null){
                fileIOHandler.after();
            }
        }
    }

    public void transferFile(File srcFile, File destFile) throws Exception {
        BufferedInputStream in = null;
        FileOutputStream out = null;
        try {
            if (fileIOHandler != null) {
                fileIOHandler.before();
            }

            FileInputStream fin = new FileInputStream(srcFile);
            in = new BufferedInputStream(fin);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[buffersize];
            int size = 0;
            while ((size = in.read(buffer)) != -1) {
                //如果需要对byte[]处理将数组拷贝一份
                if (fileIOHandler != null) {
                    out.write(fileIOHandler.process(Arrays.copyOfRange(buffer, 0, size)));
                } else {
                    out.write(buffer);
                }
            }
        }finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            if(fileIOHandler != null){
                fileIOHandler.after();
            }
        }
    }
}
