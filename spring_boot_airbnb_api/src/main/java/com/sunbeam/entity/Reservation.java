package com.sunbeam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "reservation")
public class Reservation extends BaseEntity {
	
	@Column(name = "check_in")
	private LocalDate checkIn;
	
	@Column(name = "check_out")
	private LocalDate checkOut;
	
	private double price;
	
	
	@OneToOne
	@JoinColumn(name = "room_id",nullable = false)
	private Room selectedRoom;
	
	@ManyToOne
	@JoinColumn(name = "guest_id",nullable = false)
	private Guest guest;

	public Reservation(LocalDate checkIn, LocalDate checkOut, double price, Room selectedRoom, Guest guest) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
		this.selectedRoom = selectedRoom;
		this.guest = guest;
	}


	
	
	
	
	

}
