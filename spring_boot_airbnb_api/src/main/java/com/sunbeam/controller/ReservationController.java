package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationReqDto;
import com.sunbeam.service.ReservationService;

import lombok.Getter;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping
	public ResponseEntity<?> reservationRoom(@RequestBody ReservationReqDto newReservation){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.roomReservation(newReservation));

			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	
	}
	
	
	@DeleteMapping("/{reservationId}")
	public ResponseEntity<?> reservationCancelation(@PathVariable Long reservationId){
		try {
			return ResponseEntity.ok((reservationService.cancelResesrvation(reservationId)));

			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	
	}
	

	
	
}
