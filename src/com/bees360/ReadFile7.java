package com.bees360;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile7 {
	 public void ReadFile() {
     }
     /**
      * 读取某个文件夹下的所有文件
      */
     public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
             try {

                     File file = new File(filepath);
                     if (!file.isDirectory()) {
                             System.out.println("文件");
                             System.out.println("path=" + file.getPath());
                             System.out.println("absolutepath=" + file.getAbsolutePath());
                             System.out.println("name=" + file.getName());

                     } else if (file.isDirectory()) {
                             System.out.println("文件夹");
                             String[] filelist = file.list();
                             for (int i = 0; i < filelist.length; i++) {
                                     File readfile = new File(filepath + "\\" + filelist[i]);
                                     if (!readfile.isDirectory()) {
//                                             System.out.println("path=" + readfile.getPath());
                                             System.out.println("absolutepath="
                                                             + readfile.getAbsolutePath());
                                             System.out.println("name=" + readfile.getName());

                                     } else if (readfile.isDirectory()) {
                                             readfile(filepath + "\\" + filelist[i]);
                                     }
                             }

                     }

             } catch (FileNotFoundException e) {
                     System.out.println("readfile()   Exception:" + e.getMessage());
             }
             return true;
     }

     /**
      * 删除某个文件夹下的所有文件夹和文件
      */
     
     
     /*public static boolean deletefile(String delpath)
                     throws FileNotFoundException, IOException {
             try {

                     File file = new File(delpath);
                     if (!file.isDirectory()) {
                             System.out.println("1");
                             file.delete();
                     } else if (file.isDirectory()) {
                             System.out.println("2");
                             String[] filelist = file.list();
                             for (int i = 0; i < filelist.length; i++) {
                                     File delfile = new File(delpath + "\\" + filelist[i]);
                                     if (!delfile.isDirectory()) {
                                             System.out.println("path=" + delfile.getPath());
                                             System.out.println("absolutepath="
                                                             + delfile.getAbsolutePath());
                                             System.out.println("name=" + delfile.getName());
                                             delfile.delete();
                                             System.out.println("删除文件成功");
                                     } else if (delfile.isDirectory()) {
                                             deletefile(delpath + "\\" + filelist[i]);
                                     }
                             }
                             file.delete();

                     }

             } catch (FileNotFoundException e) {
                     System.out.println("deletefile()   Exception:" + e.getMessage());
             }
             return true;
     }*/
     
     public static void copyFile(String oldPath, String newPath) throws IOException {
 		File oldFile = new File(oldPath);
 		File file = new File(newPath);
 		FileInputStream in = new FileInputStream(oldFile);
 		FileOutputStream out = new FileOutputStream(file);;

 		byte[] buffer=new byte[2097152];
 		int readByte = 0;
 		while((readByte = in.read(buffer)) != -1){
 		out.write(buffer, 0, readByte);
 		}

 		in.close();
 		out.close();
 		}
     
     public static void main(String[] args) {
             try {
                     readfile("E:\\test\\test");
                     // deletefile("D:/file");
             } catch (FileNotFoundException ex) {
             } catch (IOException ex) {
             }
             System.out.println("ok");
     }
}
