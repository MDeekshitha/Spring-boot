package com.example.room_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.room_service.dto.HotelDTO;
import com.example.room_service.feign.HotelClient;
import com.example.room_service.model.Room;
import com.example.room_service.repository.RoomRepository;

@Service

public class RoomService {
	
	private static final String HOTEl_SERVICE_URL = "http://localhost:2001/api/hotels";
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelClient hotelClient;

	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		Room r = roomRepository.save(room);
		return r;
	}

	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	public Room getRoomById(Long id) {
		// TODO Auto-generated method stub
		return roomRepository.findById(id).get();
	}

	public void deleteRoom(Long id) {
		// TODO Auto-generated method stub
		roomRepository.deleteById(id);
	}

	public List<Room> getAllRoomsInHotel(Long hotelId) {
		// TODO Auto-generated method stub
		return roomRepository.findByHotelId(hotelId);
	}
	public HotelDTO getHotelDetails(Long hotelId) {

		// http://localhost:2222/api/customers/1
		return restTemplate.getForObject(HOTEl_SERVICE_URL + "/" + hotelId, HotelDTO.class);
	}
	public Room createRoom(Long hotelId) {

		Room room = new Room();
		room.setHotelId(hotelId);

		return roomRepository.save(room);
	}

	public String placeRoom(Long hotelId) {

		HotelDTO hotel = getHotelDetails(hotelId);
		if (hotel != null) {
			Room room = new Room();
			room.setHotelId(hotel.getId());

			roomRepository.save(room);

		}
		return "Room placed for Hotel: " + hotel.getName();
	}
//	public Room getAllRoomsById(Long hotelId) {
//		// TODO Auto-generated method stub
//		HotelDTO hotel = hotelClient.getAllRoomsById(hotelId);
//		Room room = new Room();
//		room.setHotelId(hotel.getId());
//
//		roomRepository.save(room);
//		
//		return room;
//	}
}
