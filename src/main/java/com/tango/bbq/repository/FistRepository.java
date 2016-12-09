package com.tango.bbq.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FistRepository {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, String> queryTest(String node, String date){
		Map<String, String> resultMap = new HashMap<String, String>();
		String sql = "select avg(0h) as 0h, avg(1h) as 1h, avg(2h) as 2h, avg(3h) as 3h, avg(4h) as 4h, avg(5h) as 5h, avg(6h) as 6h, avg(7h) as 7h, avg(8h) as 8h, avg(9h) as 9h, avg(10h) as 10h, avg(11h) as 11h, avg(12h) as 12h, avg(13h) as 13h, avg(14h) as 14h, avg(15h) as 15h, avg(16h) as 16h, avg(17h) as 17h, avg(18h) as 18h, avg(19h) as 19h, avg(20h) as 20h, avg(21h) as 21h, avg(22h) as 22h, avg(23h) as 23h "
				+ "from t_monitor_taking where record_time = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{date});
		
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
