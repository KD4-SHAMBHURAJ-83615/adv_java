package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.entity.Guest;
import com.sunbeam.entity.Room;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationResDto extends BaseDto {
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;

	private Room room;
	
	
	private Guest guest;

}
