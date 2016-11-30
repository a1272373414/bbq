package com.tango.bbq;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class TestCSV {

	public static void main(String[] args) {
//		writeCsv();
		readeCsv();
	}
	
	/** 
     * 读取CSV文件 
     */  
     public static void  readeCsv(){ 
         try {      
                
        	 File directory = new File("");//设定为当前文件夹   
//    	     System.out.println(directory.getCanonicalPath());//获取标准的路径   
//    	     System.out.println(directory.getAbsolutePath());//获取绝对路径   
        	 
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据  
             String csvFilePath = "F:/test.csv";  
              CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));    //一般用这编码读就可以了      
                
//            reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
              String wcsvFilePath = "F:/testn.csv";  
              CsvWriter wr =new CsvWriter(wcsvFilePath,',',Charset.forName("SJIS"));  
              while(reader.readRecord()){ //逐行读入除表头的数据      
                  csvList.add(reader.getValues());  
                  wr.writeRecord(reader.getValues());  
              } 
              reader.close();  
              wr.close();  
              
                
                
         }catch(Exception ex){  
             System.out.println(ex);  
         }  
     }  
       
     /** 
      * 写入CSV文件 
      */  
     public static void  writeCsv(){  
         try {  
               
             String csvFilePath = "F:/testn.csv";  
              CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));  
              String[] contents = {"aaaaa","bbbbb","cccccc","ddddddddd"};                      
              wr.writeRecord(contents);  
              wr.close();  
          } catch (IOException e) {  
             e.printStackTrace();  
          }  
     }  

}
