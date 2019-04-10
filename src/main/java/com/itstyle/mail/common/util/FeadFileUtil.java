package com.itstyle.mail.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FeadFileUtil {

	public static List readFile(String path) {
		List result = new ArrayList<>();
        try{
        	//构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s = null;
            //使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
            	if(s.contains("tb_"))
            		result.add(s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 文件内容替换
	 * @param filePath
	 * @param oldstr
	 * @param newStr
	 * @throws IOException 
	 */
	private static void autoReplace(String filePath, List list, String newStr) throws IOException {
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				if (list.contains(lineTxt))
					System.out.println(lineTxt);
			}
		}
	}
	
	public static void main(String[] args) {
		// C:\Users\zhangshaolong\Desktop\字典.sql
		// C:\Users\zhangshaolong\Desktop\菜单.sql
		List readFile1 = readFile("C:\\Users\\zhangshaolong\\Desktop\\清库sql\\全部.txt");
		List readFile2 = readFile("C:\\Users\\zhangshaolong\\Desktop\\清库sql\\机构.txt");
		readFile1.removeAll(readFile2);
		for (Object object : readFile1) {
			System.out.println(object);
		}
		
		
	}

}
