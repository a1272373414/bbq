package com.tango.bbq.service;

import java.util.List;
import java.util.Map;

import com.tango.bbq.entity.Track;

public interface IFirstService {
	
	public Map<String, String> queryTest(String node, String date);
	
	public List<Track> getTrack(String waybillNo);
}
