package com.booking.reservation.contollers;

import com.booking.reservation.entity.Reservation;
import com.booking.reservation.entity.Room;
import com.booking.reservation.service.ReservationService;
import com.booking.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationControllers {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }
    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(id,reservation);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
    @GetMapping("/getAllReservation")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/getReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }
    @GetMapping("/reservationByClientName/{name}")
    public List<Reservation> getReservationsByClientName(@PathVariable String name) {
        return reservationService.getReservationsByClientName(name);
    }

}
