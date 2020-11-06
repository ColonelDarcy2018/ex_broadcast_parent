package com.itexcelsior.broadcast.common.core.util;

import java.io.File;

/**
 * @author zxw </br>
 * @create 2020/8/31/11:19 </br>
 * @description: 文件控制工具类 </br>
 */
public class FileUtil {

    /**
     * 重命名文件，保留文件后缀
     * @param file
     * @param newName
     * @return
     */
    public static File rename(File file,String newName){
        if (file.exists()){
            String oldName=file.getName();
            System.out.println(oldName);
            String[] olds=oldName.split("\\.");
            for (int i = 0; i < olds.length; i++) {
                System.out.println(olds[i]);
            }
            String suffix=olds.length>0?"."+olds[olds.length-1]:"";

            if (!oldName.equals(newName)){
                String path=file.getParent();
                File newFile=new File(path+"/"+newName+suffix);
                if (newFile.exists()){
                    System.out.println(newName+"already exits！！");
                }else {
                    if (file.renameTo(newFile))return newFile;
                }
            }
        }else {
            System.out.println("File does not exits!!!");
        }

        return file;
    }


    public static void main(String[] args) {
        File file=new File("D:/room.1598338801993.mp4");
        File newFile=rename(file,"新名字");

        System.out.println("这是旧文件的名称："+file.getName());
        System.out.println("这是新文件的名称："+newFile.getName());
    }


}
