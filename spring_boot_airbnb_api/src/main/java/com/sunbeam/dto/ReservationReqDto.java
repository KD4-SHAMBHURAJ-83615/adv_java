package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationReqDto extends BaseDto {
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;

	private Long roomId;
	
	
	private String guestName;

}
