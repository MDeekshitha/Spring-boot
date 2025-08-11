package com.example.room_service.controller;

import java.util.List;

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

import com.example.room_service.model.Room;
import com.example.room_service.service.RoomService;


@RestController
@RequestMapping("/api/hotels")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@GetMapping("{hotelId}/rooms")
	public List<Room> getRooms(@PathVariable Long hotelId){
		return roomService.getAllRoomsInHotel(hotelId);
	}
	@GetMapping
	public List<Room> getAllRooms(){
		return roomService.getAllRooms();
	}

	@PostMapping
	public Room createRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable Long id){
		Room room = roomService.getRoomById(id);
		return  new ResponseEntity<Room>(room,HttpStatus.OK) ;
	}
	
	@PutMapping("/{id}")
	public Room updateHotel(@RequestBody Room hotel, @PathVariable Long id) {
		Room existingRoom = roomService.getRoomById(id);
    	existingRoom.setPrice(hotel.getPrice());
    	existingRoom.setRoomNumber(hotel.getRoomNumber());
    	existingRoom.setType(hotel.getType());
    	
    	Room result = roomService.saveRoom(existingRoom);
    	
    	return result;
    	
	}
	@DeleteMapping("/{id}")
	public String deleteRoom(@PathVariable Long id) {
		roomService.deleteRoom(id);
		return "Customer deleted with this "+id;
	}
}
