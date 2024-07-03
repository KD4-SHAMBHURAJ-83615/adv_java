package com.sunbeam.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "guest")
public class Guest extends BaseEntity {
	
	@Column(name = "first_name" ,length = 20)
	private String firstName;
	@Column(name = "last_name" ,length = 20)
	private String LastName;
	private LocalDate dob;

}
