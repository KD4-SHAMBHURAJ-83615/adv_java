package com.sunbeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entity.Guest;


@Service
@Transactional
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private GuestDao guestDao;

	@Override
	public ApiResponse addNewGuest(Guest guest) {
		
		Guest gusets =guestDao.save(guest);
		if(gusets != null) {
			
			return new ApiResponse("Guest added succesfully!!!");
		}
		
		return new ApiResponse("Guest added succesfully!!!");
	}

}
