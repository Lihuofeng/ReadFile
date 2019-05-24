package com.bees360;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile4 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String sourcePath = "E:\\\\\\\\test\\\\\\\\test";
		String newPath = "\\\\BEES2-B250-HD3\\allimages_part2\\wei";

		copyDir(sourcePath, newPath);
		}

		public static void copyDir(String sourcePath, String newPath) throws FileNotFoundException, IOException {
			File file = new File(sourcePath);
			long[] projectIds = { 1000894, 1000895};
			if (!(new File(newPath)).exists()) {
				(new File(newPath)).mkdir();
			}
			if(file.isDirectory()) {
				//System.out.println("文件夹");
				String[] filePath = file.list();
				for (int i = 0; i < filePath.length; i++) {
					File readfile = new File(sourcePath + "\\" + filePath[i]);
					File file2=new File(readfile.toString());
					String []filepath2=file2.list();
					for(int k=0;k<filepath2.length;k++) {
						File readfile1=new File(sourcePath+"\\"+filePath[i]+"\\"+filepath2[k]);
						
						if(readfile1.getName().equals("closeup") ||readfile1.getName().equals("hail damage")||readfile1.getName().equals("wind damage")) {
							System.out.println("文件夹名称"+readfile1.getName());
							//					 if(!readfile.isDirectory()) {
							File file3=new File(readfile1.toString());
							String []filepath3=file3.list();
							System.out.println("projectId:"+projectIds[i]);
							for(int j=0;j<filepath3.length;j++) {
								System.out.println("j:"+j);
								
//								copyFile(sourcePath + file.separator + filePath[i]+ file.separator + filepath2[k]+file.separator+filepath3[j], newPath +file.separator+filepath3[j]);
							}
						}
					}

				}

			}
		}

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
		
		
}
