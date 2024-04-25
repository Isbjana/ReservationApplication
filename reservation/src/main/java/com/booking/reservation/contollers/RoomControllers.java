package com.booking.reservation.contollers;

import com.booking.reservation.entity.Client;
import com.booking.reservation.entity.Room;
import com.booking.reservation.service.ClientService;
import com.booking.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomControllers {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }
    @PutMapping("/update/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room){
        return roomService.updateRoom(id,room);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
    }
    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom() {
        return roomService.getAllRoom();
    }

    @GetMapping("/getRoomById/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

}
