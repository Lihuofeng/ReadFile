package com.bees360;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile6 {
	
	 public static void main(String[] args) {
	       //需要查找的文件夹
	       File file = new File(originalPath);
	       try {
	           copyPhoto(file);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	//原始图片文件夹
    static String originalPath = "\\\\BEES2-B250-HD3\\allimages_part2\\wei";
   //复制文件地址
    static String copyPath = "\\\\BEES2-B250-HD3\\allimages_part2\\wei_split";
   //复制图片的方法
   private static void copyPhoto(File file) throws IOException {
       //将路径封装成File数组
       File[] files = file.listFiles();
       int j = 0;
       //遍历这个数组
       for (int i = 0; i<files.length; i++) {
           //判断是否是文件夹
           if (files[i].isDirectory()) {
               //是的话就继续调用这个方法
               copyPhoto(files[i]);  
           } else { //不是的话就匹配是否是图片
               //每100张照片生成一个文件夹
               if(i%50 == 0) {
                   j++;
                   //生成文件夹
                   File file2 = new File(copyPath+"\\"+j);
                   file2.mkdir();
               }  //创建输入文件字节流
                   BufferedInputStream bis = new BufferedInputStream(new FileInputStream(files[i]));
                   byte[] buf = new byte[1024 * 20];
                   int lenght = 0;
                   //创建输出文件字节流包含文件输出位置
                   BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream( 
                           copyPath +"\\"+j+"\\"+ files[i].getName())); 
                   while ((lenght = bis.read(buf)) != -1) {
                       bos.write(buf, 0, lenght);
                       //这一步很重要，没有它图片容易损毁
                       bos.flush();
                       if(i == files.length-1) {
                           bos.close();
                           bis.close();
                           System.out.println("#############复制完成！！！#################");
                           return;
                       }
               }
           }
       }
   }

  
}
