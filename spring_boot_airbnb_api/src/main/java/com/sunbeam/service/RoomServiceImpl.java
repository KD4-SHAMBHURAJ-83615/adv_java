
package com.sunbeam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entity.Room;


@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;
	
	@Override
	public ApiResponse addNewRoom(Room room) {
	
		Room rm=roomDao.save(room);
		if(rm != null) {
			return new ApiResponse("room added succedfully!!!");
		}
		
		
		return new ApiResponse("room not added!!!");
	}

}
