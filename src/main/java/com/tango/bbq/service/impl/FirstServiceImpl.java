package com.tango.bbq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tango.bbq.entity.Track;
import com.tango.bbq.repository.FistRepository;
import com.tango.bbq.service.IFirstService;

@Service
public class FirstServiceImpl implements IFirstService {
	
	@Autowired
	private FistRepository repository;

	@Override
	public Map<String, String> queryTest(String node, String date){
		
		return repository.queryTest(null, date);
	}

	@Override
	public List<Track> getTrack(String waybillNo) {
		// TODO Auto-generated method stub
		return repository.queryTrack(waybillNo);
	}
	
}
