package com.hua.common.security.sm4;

import com.hua.common.file.FileIOHandler;

/**
 *  @author:
 *  @Date: 2019/3/15 13:38
 *  @Description: sm4解密工具类
 */
public class SM4DencryptHandler implements FileIOHandler {
    //sm4算法工具类
    private SM4Tools sm4;

    public SM4DencryptHandler(){
        sm4 = new SM4Tools();
        //非16进制字符串
        sm4.setHexString(false);
    }

    //设置密钥
    public void setKey(String key){
        sm4.setSecretKey(key);
    }

    public void before() {

    }

    public byte[] process(byte[] buffer) throws Exception {
        //ecb模式解密
        byte[] decodedByte = sm4.decryptData_ECB(buffer);
        return decodedByte;
    }

    public void after() {

    }
}
