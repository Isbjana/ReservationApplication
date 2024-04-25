package com.booking.reservation.repository;

import com.booking.reservation.entity.Reservation;
import com.booking.reservation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
