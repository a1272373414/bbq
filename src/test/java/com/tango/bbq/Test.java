package com.tango.bbq;

public class Test {

	public static void main(String[] args) {
		String sql = "select coulmon1,column2 from t_exp_op_record_taking where waybill_no =?";
		String target = sql.substring(sql.indexOf("select")+6, sql.indexOf("from"));
		System.out.println(target);

	}

}
