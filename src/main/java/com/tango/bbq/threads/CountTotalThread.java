package com.tango.bbq.threads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class CountTotalThread extends Thread {
	
	private String url;
	private String user;
	private String pswd;
	private Integer count;
	private boolean endFlag = false;
	private String threadId;
	private Date uploadTime;

	@Override
	public void run() {
		
		ResultSet rs = null;
		Statement stmt = null;
		Result result = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pswd);
			String querySuccess = "SELECT count(1) AS  COUNT from T_EXP_OP_RECORD_CONTAINER_TRANSPKG_FAIL";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(querySuccess);
			result = ResultSupport.toResult(rs);	
			if(result != null && result.getRows().length != 0){
				count = Integer.valueOf(result.getRows()[0].get("count").toString());
				
			}
			endFlag = true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex){
			ex.printStackTrace();
		}finally{
			try {
				stmt.close();
				stmt = null;
				rs.close();
				rs = null;
				result = null;
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public boolean isEndFlag() {
		return endFlag;
	}
	public void setEndFlag(boolean endFlag) {
		this.endFlag = endFlag;
	}


	public String getThreadId() {
		return threadId;
	}


	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}


	public Date getUploadTime() {
		return uploadTime;
	}


	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}


}
