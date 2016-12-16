package com.tango.bbq.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FistRepository {
	
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate jdbcTemplate2;
    
    @Autowired
    @Qualifier("thirdJdbcTemplate")
    JdbcTemplate jdbcTemplate3;
    
    @Autowired
    @Qualifier("otherJdbcTemplate")
    JdbcTemplate jdbcTemplate4;
	
	public Map<String, String> queryTest(String node, String date){
		Map<String, String> resultMap = new HashMap<String, String>();
		String sql = "select avg(0h) as 0h, avg(1h) as 1h, avg(2h) as 2h, avg(3h) as 3h, avg(4h) as 4h, avg(5h) as 5h, avg(6h) as 6h, avg(7h) as 7h, avg(8h) as 8h, avg(9h) as 9h, avg(10h) as 10h, avg(11h) as 11h, avg(12h) as 12h, avg(13h) as 13h, avg(14h) as 14h, avg(15h) as 15h, avg(16h) as 16h, avg(17h) as 17h, avg(18h) as 18h, avg(19h) as 19h, avg(20h) as 20h, avg(21h) as 21h, avg(22h) as 22h, avg(23h) as 23h "
				+ "from t_monitor_taking where record_time = ?";
		List<Map<String, Object>> list = jdbcTemplate1.queryForList(sql, new Object[]{date});
		
		String sql2 = "select waybill_no from t_exp_op_record_taking_371041 where waybill_no = ?";
		List<Map<String, Object>> list2 = jdbcTemplate2.queryForList(sql2, new Object[]{new String("200421618544")});
		if(list2 != null && list2.size() > 0){
			Map<String, Object> avgMap = list2.get(0);
			for(Entry<String, Object> entry: avgMap.entrySet()){
				System.out.println((jdbcTemplate2+"*****************/"+entry.getValue().toString()));
			}
		}
		
		String sql3 = "select waybill_no from t_exp_op_record_container_unsuccess where waybill_no = ?";
		List<Map<String, Object>> list3 = jdbcTemplate3.queryForList(sql3, new Object[]{new String("ZB18603117")});
		if(list3 != null && list3.size() > 0){
			Map<String, Object> avgMap = list3.get(0);
			for(Entry<String, Object> entry: avgMap.entrySet()){
				System.out.println((jdbcTemplate3+"*****************/"+entry.getValue().toString()));
			}
		}
		
		String sql4 = "select waybill_no from t_exp_op_record_container_unsuccess where waybill_no = ?";
		List<Map<String, Object>> list4 = jdbcTemplate4.queryForList(sql4, new Object[]{new String("000000140048")});
		if(list4 != null && list4.size() > 0){
			Map<String, Object> avgMap = list4.get(0);
			for(Entry<String, Object> entry: avgMap.entrySet()){
				System.out.println((jdbcTemplate4+"*****************/"+entry.getValue().toString()));
			}
		}
		
		
		StringBuffer sbdata = new StringBuffer();
		StringBuffer sbdate = new StringBuffer();
		
		if(list != null && list.size() > 0){
			Map<String, Object> avgMap = list.get(0);
			for(Entry<String, Object> entry: avgMap.entrySet()){
				sbdate.append(date+"/"+entry.getKey().toString()+",");
				sbdata.append(Double.valueOf((entry.getValue().toString())).intValue() +",");
			}
		}
			
		
		if(sbdata.length() != 0 && sbdate.length() != 0 ){
			resultMap.put("date", sbdate.toString().substring(0, sbdate.toString().length()-1));
			resultMap.put("data", sbdata.toString().substring(0, sbdata.toString().length()-1));
			System.out.println("date:"+sbdate.toString().substring(0, sbdate.toString().length()-1));
			System.out.println("data:"+sbdata.toString().substring(0, sbdata.toString().length()-1));
		}
		
		return resultMap;
	}
	
    
    
}
