package com.tango.bbq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tango.bbq.entity.Track;
import com.tango.bbq.service.IFirstService;

@Controller
public class FirstController {

  @Autowired
  private IFirstService firstService;
  
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
	  Map<String, String> map = firstService.queryTest(null, "2016-11-19");
	  model.addAttribute("date",map.get("date"));
	  model.addAttribute("data",map.get("data"));
      return "sbadmin/takingsp";
  }
  
  @RequestMapping("/chartFlot")
  public String chartFlot(Model model){
//	  Map<String, String> map = repository.queryTest(null, "2016-11-19");
//	  model.addAttribute("date",map.get("date"));
//	  model.addAttribute("data",map.get("data"));
      return "sbadmin/flot";
  }
  
  @RequestMapping("/chartMorris")
  public String chartMorris(Model model){
//	  Map<String, String> map = repository.queryTest(null, "2016-11-19");
//	  model.addAttribute("date",map.get("date"));
//	  model.addAttribute("data",map.get("data"));
      return "sbadmin/morris";
  }
  
  @RequestMapping("/tables")
  public String tables(@ModelAttribute("track")Track track,Model model){
	  
	  List<Track> list = firstService.getTrack("");
	  
	  model.addAttribute("list", list);
      return "sbadmin/tables";
  }
  
  @RequestMapping(value ="/search", method = RequestMethod.POST)
  public String search(@ModelAttribute("track")Track track, Model model){
	  List<Track> list = firstService.getTrack(track.getWaybillNo());
	  
	  model.addAttribute("list", list);
      return "sbadmin/tables";
  }
  

  
}
