package com.tango.bbq.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tango.bbq.util.CSVUtils;

@Controller
public class FirstController {
  
  @RequestMapping("/monitor")
  public String home(Model model) {
	  Map<String, String> map = new HashMap<String, String>();
//	  map.put("testKey", "testValue");
//	  CSVUtils.readeCsv();
//	  model.addAttribute("testkey","testvalue");
//	  model.addAttribute(map);
//	  model.put("testkey","testvalue");
      return "area-simple";
  }
}
