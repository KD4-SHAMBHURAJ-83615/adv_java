package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationReqDto;
import com.sunbeam.dto.ReservationResDto;
import com.sunbeam.entity.Room;

public interface ReservationService {
	
	ReservationResDto roomReservation(ReservationReqDto newReservation);
	ApiResponse cancelResesrvation(Long reservationId);
	List<Room> cheakByDate(LocalDate date);

}
