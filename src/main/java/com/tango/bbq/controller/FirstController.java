package com.tango.bbq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tango.bbq.repository.FistRepository;

@Controller
public class FirstController {

  @Autowired
  private FistRepository repository;
  
  @RequestMapping("/")
  public String home(Model model) {
	  
//	  Map<String, String> map = repository.queryTest(null, "2016-11-19");
//	  model.addAttribute("date",map.get("date"));
//	  model.addAttribute("data",map.get("data"));
//      return "monitorChart";
      return "sbadmin/index";
  }
  
  @RequestMapping("/monitor")
  public String monitor(Model model){
	  Map<String, String> map = repository.queryTest(null, "2016-11-19");
	  model.addAttribute("date",map.get("date"));
	  model.addAttribute("data",map.get("data"));
      return "sbadmin/takingsp";
  }
  

  
}
