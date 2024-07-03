package com.sunbeam.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entity.Room;



public interface RoomDao extends JpaRepository<Room, Long> {
	
	

}
