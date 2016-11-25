package com.tango.bbq.util;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
/**
 * csv导出工具类
 * @author Administrator
 *
 */
public class CSVUtils {
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