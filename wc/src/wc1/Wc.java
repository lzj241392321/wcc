package wc1;

import java.io.*;
/**
 * ͳ���ı��ļ��������������飬�ַ��� 
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
				 // ����Ƿ����
				 f = new FileInputStream("wc.txt");//�����ļ���·��������
				 wc(f);
				 } else {
					 // �ж���
					 for (int i = 0; i < args.length; i++) {
						 f = new FileInputStream(args[i]); 
						 wc(f);
						 }
					 }
			 } catch (IOException e) {
				 return;
				 }
		 System.out.println(lines + "�� " );
		 System.out.println(words + "������ ");
		 System.out.println(chars + "���ַ�");
		 }
}	   
	