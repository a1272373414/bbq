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
  public String tables(Model model){
//	  ArrayList<Track> list = new ArrayList<Track>();
//	  Track t = new Track();
//	  t.setId("123");
//	  t.setCreateTime(new Date());
//	  t.setErrorMessage("test");
//	  t.setOpCode("110");
//	  t.setOrgCode("999999");
//	  t.setUploadTime(new Date());
//	  t.setWaybillNo("1234567890");
//	  list.add(t);
//	  
//	  Track t1 = new Track();
//	  t1.setId("456");
//	  t1.setCreateTime(new Date());
//	  t1.setErrorMessage("test");
//	  t1.setOpCode("310");
//	  t1.setOrgCode("888888");
//	  t1.setUploadTime(new Date());
//	  t1.setWaybillNo("1111111111");
//	  list.add(t1);
//	  
	  
	  List<Track> list = firstService.getTrack("");
	  
	  model.addAttribute("list", list);
      return "sbadmin/tables";
  }
  
  @RequestMapping(value ="/search", method = RequestMethod.POST)
  public String search(Track track, Model model){
	  System.out.println("**********D00071082508*************** "+ track.getWaybillNo());
	  List<Track> list = firstService.getTrack(track.getWaybillNo());
	  
	  model.addAttribute("list", list);
      return "sbadmin/tables";
  }
  

  
}
