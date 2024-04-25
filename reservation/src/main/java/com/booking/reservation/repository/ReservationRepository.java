package com.booking.reservation.repository;

import com.booking.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation,Long> {

    List<Reservation> findByClientName(String clientName);


}
