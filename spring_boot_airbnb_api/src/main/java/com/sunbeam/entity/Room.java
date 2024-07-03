package com.sunbeam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rooms")
@NoArgsConstructor

@Setter
@Getter
@ToString(callSuper = true)
public class Room extends BaseEntity {
	@Column(name = "room_no")
	private int roomNo;
	@Enumerated(EnumType.STRING)
	@Column(name = "room_type")
	private Type roomType;
	private double price;
	private boolean availability;
	
}
