package com.booking.reservation.repository;

import com.booking.reservation.entity.Client;
import com.booking.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {



}
