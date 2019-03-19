package com.hua.ntr.genFile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GenFileFactory {

    private static Map<String,IGenFile> genFileFactory = new ConcurrentHashMap<String, IGenFile>(100);

    private static void addGenFileFactory(IGenFile iGenFile){
        genFileFactory.put(iGenFile.getFileType(),iGenFile);
    }

    static {
        addGenFileFactory(new Gen2DNormalBaseInfoFileFactory());
    }

    public static  IGenFile getInstance(String fileType){
        return genFileFactory.get(fileType);
    }

}
