package com.booking.reservation.service;

import com.booking.reservation.entity.Client;
import com.booking.reservation.entity.Room;
import com.booking.reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room newRoom) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setRoomNumber(newRoom.getRoomNumber());
            return roomRepository.save(existingRoom);
        } else {
            System.out.println("Room not found");
            return null;
        }
    }




    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);


    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }


}
