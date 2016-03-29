package wc1;

import java.io.*;
/**
 * 统计文本文件的行数，单词书，字符数 
 */ 
public class Wc {
	public static int words = 1;
	public static int lines = 1;     
	public static int chars = 0;  
	public static void wc(InputStream f) throws IOException {
		int c = 0;          
		boolean lastNotWhite = false;         
		String whiteSpace = "";         
		while ((c = f.read()) != -1) {             
			chars++;              
			if (c == '\n') {
				lines++;
				}              
			if (whiteSpace.indexOf(c) != -1) {
				if (lastNotWhite) {
					words++;
					}
				lastNotWhite = false;
				} else {
					lastNotWhite = true;
					}         
			}     
		}       
	


	public static void main(String args[]) { 
		 FileInputStream f;
		 try {
			 if (args.length == 0) {
				 // 检查是否读入
				 f = new FileInputStream("wc.txt");//输入文件的路径。。。
				 wc(f);
				 } else {
					 // 判断行
					 for (int i = 0; i < args.length; i++) {
						 f = new FileInputStream(args[i]); 
						 wc(f);
						 }
					 }
			 } catch (IOException e) {
				 return;
				 }
		 System.out.println(lines + "行 " );
		 System.out.println(words + "个单词 ");
		 System.out.println(chars + "个字符");
		 }
}	   
	