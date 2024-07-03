package com.sunbeam.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationReqDto;
import com.sunbeam.dto.ReservationResDto;
import com.sunbeam.entity.Guest;
import com.sunbeam.entity.Reservation;
import com.sunbeam.entity.Room;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private GuestDao guestDao;
	
	@Autowired 
	private ModelMapper mapper;





	@Override
	public ReservationResDto roomReservation(ReservationReqDto newReservation) {
		
		Room room = roomDao.findById(newReservation.getRoomId()).orElseThrow(()-> new ResourceNotFoundException("invalid room id"));
		
		Guest guest = guestDao.findByFirstName(newReservation.getGuestName()).orElseThrow(()-> new ResourceNotFoundException("invalid room id"));
		
		room.setAvailability(false);
		
		Reservation res =new Reservation(newReservation.getCheckIn(), newReservation.getCheckOut(),room.getPrice(), room, guest);
		
		Reservation rep=reservationDao.save(res);
		
		
		return mapper.map(rep, ReservationResDto.class);
		
		 
	}





	@Override
	public ApiResponse cancelResesrvation(Long reservationId) {
		if(reservationDao.existsById(reservationId))
		{
			reservationDao.deleteById(reservationId);
			return new ApiResponse("Resesrvation canceled");
		}
	
		return new ApiResponse(" Resesrvation is not canceled");
	}





	@Override
	public List<Room> cheakByDate(LocalDate date) {
		
		List<Room> list =roomDao.findAll();
		
//		 for(Room roomlist  :list) {
//			 while(roomlist.isAvailability()!=true) {
//				 
//			 }
//			
//		 }
		
		return list.stream().filter((e)->e.isAvailability()).collect(Collectors.toList());
		
		
		
	}
	
	
	
	
	
	
	

	
		
		
		

}
