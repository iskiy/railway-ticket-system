package com.railway.service;

import com.railway.model.BookingDTO;
import com.railway.model.BookingEntity;
import com.railway.model.BookingStatus;
import com.railway.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    @Transactional
    public BookingEntity book(BookingDTO bookingDTO) {
        BookingEntity bookingBySeat = findBySeatId(bookingDTO.getSeatId());
        if (bookingBySeat == null) {
            return createBooking(bookingDTO);
        }
        if (bookingBySeat.getStatus() == BookingStatus.NotBooked) {
            bookingBySeat.setStatus(bookingDTO.getStatus());
            bookingBySeat.setUserEmail(bookingDTO.getUserEmail());
            bookingBySeat.setBookingDate(bookingDTO.getBookingDate());
            return bookingRepository.saveAndFlush(bookingBySeat);
        }
        return bookingBySeat;
    }

    @Transactional
    public BookingEntity createBooking(BookingDTO bookingDTO) {
        BookingEntity newBooking = BookingEntity.builder()
                .userEmail(bookingDTO.getUserEmail())
                .seatId(bookingDTO.getSeatId())
                .price(bookingDTO.getPrice())
//                .carriageId(bookingDTO.getCarriageId())
//                .trainId(bookingDTO.getTrainId())
                .bookingDate(bookingDTO.getBookingDate())
                .status(bookingDTO.getStatus())
                .build();

        return bookingRepository.saveAndFlush(newBooking);
    }

    @Transactional
    public List<BookingEntity> findAllBooking() {
        return bookingRepository.findAll();
    }

    @Transactional
    public List<BookingEntity> findAllByStatus(BookingStatus status) {
        return bookingRepository.findAllByStatus(status);
    }

    @Transactional
    public BookingEntity getBookingById(Long id) {
        Optional<BookingEntity> optionalTicket = bookingRepository.findById(id);

        return optionalTicket
                .orElse(null);
    }

    @Transactional
    public List<BookingEntity> findAllByUserEmail(String email) {
        return bookingRepository.findAllByUserEmail(email);
    }

    @Transactional
    public BookingEntity findBySeatId(Long seatId) {
        return bookingRepository.findBySeatId(seatId).orElse(null);
    }

//    @Transactional
//    public List<BookingEntity> findAllByCarriageId(Long carriageId) {
//        return bookingRepository.findAllByCarriageId(carriageId);
//    }
//
//    @Transactional
//    public List<BookingEntity> findAllByTrainId(Long trainId) {
//        return bookingRepository.findAllByTrainId(trainId);
//    }

    @Transactional
    public void expireBooking(long minutesToExpire, long minutesToDelete) {
        Instant instantNow = Instant.now();
        Instant instantMinus15Minutes = instantNow.minusSeconds(minutesToExpire * 60);
        System.out.println("Instant 15 minutes ago: " + instantMinus15Minutes);

        Timestamp timestampFromInstant = Timestamp.from(instantMinus15Minutes);
        System.out.println("Timestamp from Instant 15 minutes ago: " + timestampFromInstant);

        List<BookingEntity> bookingEntities = bookingRepository.findAllByBookingDateIsBefore(timestampFromInstant);
        for (BookingEntity bookingEntity : bookingEntities) {
            bookingEntity.setStatus(BookingStatus.YetBooked);
            bookingRepository.saveAndFlush(bookingEntity);
        }

        Instant instantMinus20Minutes = instantNow.minusSeconds(minutesToDelete * 60);
        Timestamp timestampFromInstant20 = Timestamp.from(instantMinus20Minutes);
        List<BookingEntity> bookingEntities20 = bookingRepository.findAllByBookingDateIsBefore(timestampFromInstant20);
        bookingRepository.deleteAll(bookingEntities20);
    }

    @Transactional
    public List<BookingEntity> findAllByBookingDate(Timestamp timestamp) {
        return bookingRepository.findAllByBookingDate(timestamp);
    }

    @Transactional
    public boolean isBooked(Long seatId) {
        boolean isExists = bookingRepository.existsBySeatId(seatId);
        if (!isExists) {
            return true;
        }
        BookingEntity bookingEntity = findBySeatId(seatId);
        return bookingEntity.getStatus() == BookingStatus.Booked;
    }

    @Transactional
    public BookingEntity updateBooking(BookingEntity booking) {
        return bookingRepository.saveAndFlush(booking);
    }

    @Transactional
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Transactional
    public void deleteBooking(BookingEntity bookingEntity) {
        bookingRepository.delete(bookingEntity);
    }
}
