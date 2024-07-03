package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entity.Room;
import com.sunbeam.service.RoomService;


@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	
	@PostMapping
	public ResponseEntity<?> addNewRoom(@RequestBody Room newRoom){
		try {
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addNewRoom(newRoom));
 
			
		} catch (RuntimeException e) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
	}

}
