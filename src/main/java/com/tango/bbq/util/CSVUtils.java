package com.tango.bbq.util;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvReader;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
/**
 * csv导出工具类
 * @author Administrator
 *
 */
public class CSVUtils {
	
	/** 
     * 读取CSV文件 
     */  
     public static void readeCsv(){ 
         try {      
                
        	 File directory = new File("");//设定为当前文件夹   
//    	     System.out.println(directory.getCanonicalPath());//获取标准的路径   
//    	     System.out.println(directory.getAbsolutePath());//获取绝对路径   
        	 
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据  
             String csvFilePath = "F:/test.csv";  
             CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));  
              
                
//              reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
                
              while(reader.readRecord()){ //逐行读入除表头的数据      
                  csvList.add(reader.getValues());  
              }              
              reader.close();  
                
              for(int row=0;row<csvList.size();row++){  
                    
                  String  cell = csvList.get(row)[0]; //取得第row行第0列的数据  
                  String  cell1 = csvList.get(row)[1]; //取得第row行第1列的数据
                  System.out.println(cell+" "+cell1);  
                    
              }  
                
                
         }catch(Exception ex){  
             System.out.println(ex);  
         }  
     }  
     
	/**
	 * 
	 * @param resp
	 * @param heads
	 * @param rows
	 * @param 文件名
	 */
	public static void exportCSVFile(HttpServletResponse resp, String[] heads, List<Object[]> rows, String fileName){ 
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/csv;charset=UTF-8");
			resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);

			CsvWriterSettings settings = new CsvWriterSettings();
			settings.setHeaders(heads);
			settings.selectFields(heads);
			//csv以gb2312编码，excel打开csv文件默认是以ascii打开
			CsvWriter writer = new CsvWriter(resp.getOutputStream(), "gb2312", settings);
			// 为上面的配置写入指定的标题
			writer.writeHeaders();
			for (Object[] objects : rows) {
				writer.writeRow(objects);
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
	
	
	
}