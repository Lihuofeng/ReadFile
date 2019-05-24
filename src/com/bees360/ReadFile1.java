package com.bees360;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile1 {
	public static void main(String[] args) throws Exception {
		String path="\\\\BEES2-B250-HD3\\allimages_part1\\韦慧玲-checked";//源路径
		String des ="E:\\test\\wei";
		String loggersFilesName="birdview";
		copy(path, des, loggersFilesName);
		
	}
	public static void copy(String src, String des, String loggersFilesName) throws Exception {
		//初始化文件复制
		File file1=new File(src);
		//文件判断 有不管 没有创建
		if(!file1.exists()){
			file1.mkdirs();
		}
		//把文件里面内容放进数组
		File[] fs=file1.listFiles();
		//初始化文件粘贴
		File file2=new File(des);

		//文件判断 有不管 没有创建

		if(!file2.exists()){
			file2.mkdirs();
		}

		for (File f : fs) {
			if(f.isFile()) {
				fileCopy(f.getPath(),des+"\\"+f.getName());
			}else if(f.isDirectory()){
				if(!loggersFilesName.equals(f.getName())){
					copy(f.getPath(),des+"\\"+f.getName(),loggersFilesName);
				}
			}
		}
	}

	public static void fileCopy(String src, String des) throws Exception {
		//io流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
		int i = -1;//获取长度
		byte[] bt = new byte[2014];//缓冲区
		while ((i = bis.read(bt))!=-1) {
			bos.write(bt, 0, i);
		}
		bis.close();
		bos.close();
	}


}

