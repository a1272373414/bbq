package com.tango.bbq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
  
  @RequestMapping("/monitor")
  public String home(Model model) {
//	  Map<String, String> map = new HashMap<String, String>();
//	  map.put("testKey", "testValue");
//	  CSVUtils.readeCsv();
//	  model.addAttribute("testkey","testvalue");
//	  model.addAttribute(map);
//	  model.put("testkey","testvalue");
	  model.addAttribute("date","2016/11/10-1,2016/11/10-2,2016/11/10-3,2016/11/10-4,2016/11/10-5,2016/11/10-6,2016/11/10-7");
	  model.addAttribute("data","3000,3600,3204,3640,3690,3900,3100");
      return "monitorChart";
  }
}
