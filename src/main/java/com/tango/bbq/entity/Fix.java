package com.tango.bbq.entity;

import java.io.Serializable;

public class Fix implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dbType;
	private String host;
	private Integer port;
	private String dbname;
	private String userName;
	private String password;
	
	private String sourceDbInfo;
	/**
	 * 目的库信息 like：192.168.1.1,3306,dbname,tango,123456
	 */
	private String targetDbInfo;
	
	private String sourceSql;
	private String targetSql;
	
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSourceDbInfo() {
		return sourceDbInfo;
	}
	public void setSourceDbInfo(String sourceDbInfo) {
		this.sourceDbInfo = sourceDbInfo;
	}
	public String getTargetDbInfo() {
		return targetDbInfo;
	}
	public void setTargetDbInfo(String targetDbInfo) {
		this.targetDbInfo = targetDbInfo;
	}
	public String getSourceSql() {
		return sourceSql;
	}
	public void setSourceSql(String sourceSql) {
		this.sourceSql = sourceSql;
	}
	public String getTargetSql() {
		return targetSql;
	}
	public void setTargetSql(String targetSql) {
		this.targetSql = targetSql;
	}


}
