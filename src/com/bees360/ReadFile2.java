package com.bees360;

import java.io.File;

public class ReadFile2 {
	public static void main(String[] args) {
		 File path = new File("E:\\test\\tao");
		delAllFile(path);
	}
	public static void delAllFile(File path) {
	    if (!path.exists() || !path.isDirectory()) { //不是目录
	        return ;
	    }
	    String[] tmpList = path.list();
	    if (tmpList != null) {
	        for (String aTempList : tmpList) {
	            File tmpFile = new File(path, aTempList);
	            if (tmpFile.isFile() && tmpFile.getName().endsWith(".txt")) {
	                tmpFile.delete();
	            } else if (tmpFile.isDirectory()) {
	                delAllFile(tmpFile);
	            }
	        }
	    }
	}
}
