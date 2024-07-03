package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entity.Guest;

public interface GuestService {

	ApiResponse addNewGuest(Guest guest);
}
