package com.railway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
// import com.railway.grpc.TrainServiceClient;
import com.railway.model.BookingDTO;
import com.railway.model.BookingEntity;
import com.railway.model.BookingStatus;
import com.railway.service.BookingService;
import lombok.RequiredArgsConstructor;
import com.railway.utils.ErrorsGenerator;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final ObjectMapper objectMapper;
    private final BookingService bookingService;

    private final ErrorsGenerator errorsGenerator;

    // private final TrainServiceClient trainServiceClient;

//    @RequestMapping(value = "/booking/train/{id}", method = RequestMethod.GET)
//    public ResponseEntity<String> getBookingByTrain(@PathVariable("id") Long trainId) throws JsonProcessingException {
//        return ResponseEntity.ok(
//                objectMapper.writeValueAsString(
//                        bookingService.findAllByTrainId(trainId).stream().map(
//                                bookingEntity -> new BookingDTO(
//                                        bookingEntity.getBookingId(),
//                                        bookingEntity.getUserEmail(),
//                                        bookingEntity.getSeatId(),
//                                        bookingEntity.getCarriageId(),
//                                        bookingEntity.getTrainId(),
//                                        bookingEntity.getBookingDate(),
//                                        bookingEntity.getStatus()
//                                )
//                        ).toList()
//                )
//        );
//    }

//    @RequestMapping(value = "/booking/carriage/{id}", method = RequestMethod.GET)
//    public ResponseEntity<String> getBookingByCarriage(@PathVariable("id") Long carriageId) throws JsonProcessingException {
//        return ResponseEntity.ok(
//                objectMapper.writeValueAsString(
//                        bookingService.findAllByCarriageId(carriageId).stream().map(
//                                bookingEntity -> new BookingDTO(
//                                        bookingEntity.getBookingId(),
//                                        bookingEntity.getUserEmail(),
//                                        bookingEntity.getSeatId(),
//                                        bookingEntity.getCarriageId(),
//                                        bookingEntity.getTrainId(),
//                                        bookingEntity.getBookingDate(),
//                                        bookingEntity.getStatus()
//                                )
//                        ).toList()
//                )
//        );
//    }

    @RequestMapping(value = "/booking/seat/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookingBySeat(@PathVariable("id") Long seatId) throws JsonProcessingException {
        BookingEntity bookingEntity = bookingService.findBySeatId(seatId);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new BookingDTO(
                                bookingEntity.getBookingId(),
                                bookingEntity.getUserEmail(),
                                bookingEntity.getSeatId(),
//                                bookingEntity.getCarriageId(),
//                                bookingEntity.getTrainId(),
                                bookingEntity.getPrice(),
                                bookingEntity.getBookingDate(),
                                bookingEntity.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/booking/status", method = RequestMethod.GET)
    public ResponseEntity<String> getBookingByStatus(@RequestBody BookingStatus status)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        bookingService.findAllByStatus(status).stream().map(
                                bookingEntity -> new BookingDTO(
                                        bookingEntity.getBookingId(),
                                        bookingEntity.getUserEmail(),
                                        bookingEntity.getSeatId(),
//                                        bookingEntity.getCarriageId(),
//                                        bookingEntity.getTrainId(),
                                        bookingEntity.getPrice(),
                                        bookingEntity.getBookingDate(),
                                        bookingEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/booking/all", method = RequestMethod.GET)
    public ResponseEntity<String> getAllBookings()
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        bookingService.findAllBooking().stream().map(
                                bookingEntity -> new BookingDTO(
                                        bookingEntity.getBookingId(),
                                        bookingEntity.getUserEmail(),
                                        bookingEntity.getSeatId(),
//                                        bookingEntity.getCarriageId(),
//                                        bookingEntity.getTrainId(),
                                        bookingEntity.getPrice(),
                                        bookingEntity.getBookingDate(),
                                        bookingEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/booking/user_email", method = RequestMethod.GET)
    public ResponseEntity<String> getBookingsByUserEmail(@RequestBody String userEmail)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        bookingService.findAllByUserEmail(userEmail).stream().map(
                                bookingEntity -> new BookingDTO(
                                        bookingEntity.getBookingId(),
                                        bookingEntity.getUserEmail(),
                                        bookingEntity.getSeatId(),
//                                        bookingEntity.getCarriageId(),
//                                        bookingEntity.getTrainId(),
                                        bookingEntity.getPrice(),
                                        bookingEntity.getBookingDate(),
                                        bookingEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/booking/booking_date", method = RequestMethod.GET)
    public ResponseEntity<String> getBookingsByBookingDate(@RequestBody Timestamp timestamp)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        bookingService.findAllByBookingDate(timestamp).stream().map(
                                bookingEntity -> new BookingDTO(
                                        bookingEntity.getBookingId(),
                                        bookingEntity.getUserEmail(),
                                        bookingEntity.getSeatId(),
//                                        bookingEntity.getCarriageId(),
//                                        bookingEntity.getTrainId(),
                                        bookingEntity.getPrice(),
                                        bookingEntity.getBookingDate(),
                                        bookingEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/booking/is_booked/{seatId}", method = RequestMethod.GET)
    public ResponseEntity<String> isBooked(@PathVariable("seatId") Long seatId)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                       bookingService.isBooked(seatId)
                )
        );
    }

    @RequestMapping(value = "/booking/is_booked/", method = RequestMethod.GET)
    public ResponseEntity<String> isBookedBody(@RequestBody Long seatId)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        bookingService.isBooked(seatId)
                )
        );
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ResponseEntity<String> addBooking(@RequestBody final BookingDTO bookingDTO) throws JsonProcessingException {
        BookingEntity bookingEntity = bookingService.createBooking(bookingDTO);
        // trainServiceClient.getBookingInfoAndCheckReservation(bookingEntity.getSeatId());
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new BookingDTO(
                                bookingEntity.getBookingId(),
                                bookingEntity.getUserEmail(),
                                bookingEntity.getSeatId(),
//                                bookingEntity.getCarriageId(),
//                                bookingEntity.getTrainId(),
                                bookingEntity.getPrice(),
                                bookingEntity.getBookingDate(),
                                bookingEntity.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/booking_http", method = RequestMethod.POST)
    public ResponseEntity<String> booking(@RequestBody final BookingDTO bookingDTO) throws JsonProcessingException {
        BookingEntity bookingEntity = bookingService.createBooking(bookingDTO);
        try {
            long seatId = bookingEntity.getSeatId();
            JSONObject json = new JSONObject();
            json.put("seat_id", seatId);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://train_service:8080/check-seat"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());
                boolean isAvailable = jsonResponse.getBoolean("is_available");
                if (!isAvailable) {
                    return ResponseEntity.badRequest().build();
                }
                // System.out.println("Seat Availability: " + isAvailable);
            } else {
                System.err.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new BookingDTO(
                                bookingEntity.getBookingId(),
                                bookingEntity.getUserEmail(),
                                bookingEntity.getSeatId(),
//                                bookingEntity.getCarriageId(),
//                                bookingEntity.getTrainId(),
                                bookingEntity.getPrice(),
                                bookingEntity.getBookingDate(),
                                bookingEntity.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> editBookingIfExist(@PathVariable("id") Long id, @RequestBody final BookingDTO bookingDTO)
            throws JsonProcessingException {
        BookingEntity bookingEntity = bookingService.getBookingById(id);
        if (bookingEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    errorsGenerator.generateErrorByStatus(HttpStatus.NOT_FOUND)
            );
        }

        bookingEntity.setBookingId(bookingDTO.getBookingId());
        bookingEntity.setUserEmail(bookingDTO.getUserEmail());
        bookingEntity.setSeatId(bookingDTO.getSeatId());
//        bookingEntity.setCarriageId(bookingDTO.getCarriageId());
//        bookingEntity.setTrainId(bookingDTO.getTrainId());
        bookingEntity.setPrice(bookingDTO.getPrice());
        bookingEntity.setBookingDate(bookingDTO.getBookingDate());
        bookingEntity.setStatus(bookingDTO.getStatus());

        BookingEntity updatedBooking = bookingService.updateBooking(bookingEntity);

        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new BookingDTO(
                                updatedBooking.getBookingId(),
                                updatedBooking.getUserEmail(),
                                updatedBooking.getSeatId(),
//                                updatedBooking.getCarriageId(),
//                                updatedBooking.getTrainId(),
                                updatedBooking.getPrice(),
                                updatedBooking.getBookingDate(),
                                updatedBooking.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/booking", method = RequestMethod.PUT)
    public ResponseEntity<String> book(@RequestBody final BookingDTO bookingDTO)
            throws JsonProcessingException {
        BookingEntity updatedBooking = bookingService.book(bookingDTO);

        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new BookingDTO(
                                updatedBooking.getBookingId(),
                                updatedBooking.getUserEmail(),
                                updatedBooking.getSeatId(),
//                                updatedBooking.getCarriageId(),
//                                updatedBooking.getTrainId(),
                                updatedBooking.getPrice(),
                                updatedBooking.getBookingDate(),
                                updatedBooking.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTicketById(@PathVariable("id") Long id) {
        BookingEntity bookingEntity = bookingService.getBookingById(id);
        if (bookingEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    errorsGenerator.generateErrorByStatus(HttpStatus.NOT_FOUND)
            );
        } else {
            bookingService.deleteBookingById(id);
            return ResponseEntity.ok(ErrorsGenerator.EMPTY_ERRORS);
        }
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getBookingById(@PathVariable("id") Long id) throws JsonProcessingException {
        BookingEntity bookingEntity = bookingService.getBookingById(id);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new BookingDTO(
                                bookingEntity.getBookingId(),
                                bookingEntity.getUserEmail(),
                                bookingEntity.getSeatId(),
//                                bookingEntity.getCarriageId(),
//                                bookingEntity.getTrainId(),
                                bookingEntity.getPrice(),
                                bookingEntity.getBookingDate(),
                                bookingEntity.getStatus()
                        )
                )
        );
    }
}
