package com.railway.repository;

import com.railway.model.BookingEntity;
import com.railway.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    List<BookingEntity> findAllByStatus(BookingStatus status);

    List<BookingEntity> findAllByUserEmail(String email);

    Optional<BookingEntity> findBySeatId(Long seatId);

//    List<BookingEntity> findAllByCarriageId(Long carriageId);
//
//    List<BookingEntity> findAllByTrainId(Long trainId);

    List<BookingEntity> findAllByBookingDate(Timestamp timestamp);

    List<BookingEntity> findAllByBookingDateIsBefore(Timestamp timestamp);

    boolean existsBySeatId(Long seaId);
}
