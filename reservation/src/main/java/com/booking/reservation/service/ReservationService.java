package com.booking.reservation.service;

import com.booking.reservation.entity.Client;
import com.booking.reservation.entity.Reservation;
import com.booking.reservation.entity.Room;
import com.booking.reservation.entity.RoomStatus;
import com.booking.reservation.repository.ReservationRepository;
import com.booking.reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    public Reservation createReservation(Reservation reservation) {
        Room room = reservation.getRoom();
        room.setStatus(RoomStatus.BUSY);
        roomRepository.save(room);
        return reservationRepository.save(reservation);   //krijimi i nje rezervimi
    }

    public Reservation updateReservation(Long id, Reservation newReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            Room oldRoom = existingReservation.getRoom();
            Room newRoom = newReservation.getRoom();
            if (!oldRoom.equals(newRoom)) {
                oldRoom.setStatus(RoomStatus.AVAILABLE);
                roomRepository.save(oldRoom);
            }

            // Update status of new room to BUSY
            newRoom.setStatus(RoomStatus.BUSY);
            roomRepository.save(newRoom);
            // Update reservation details
            existingReservation.setClient(newReservation.getClient());
            existingReservation.setRoom(newReservation.getRoom());
            existingReservation.setCheckInDate(newReservation.getCheckInDate());
            existingReservation.setCheckOutDate(newReservation.getCheckOutDate());

            return reservationRepository.save(existingReservation);

        } else {
            System.out.println("Reservation not found");
            return null;
        }

    }

    public void deleteReservation(Long id){
        Reservation reservation=reservationRepository.findById(id).orElse(null);
        if (reservation!=null){
            Room room=reservation.getRoom();
            room.setStatus(RoomStatus.AVAILABLE);
            roomRepository.save(room);
            reservationRepository.deleteById(id);
        }else {
            System.out.println("Reservation not found");
        }
    }
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
    // Method to retrieve reservations by customer name
    public List<Reservation> getReservationsByClientName(String clientName) {
        List<Reservation> allReservations = reservationRepository.findAll();
        return allReservations.stream()
                .filter(reservation -> reservation.getClient().getName().equals(clientName))
                .collect(Collectors.toList());
    }
}
