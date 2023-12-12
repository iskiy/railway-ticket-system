package com.railway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.grpc.Booking;
//import com.railway.grpc.BookingServiceClient;
//import com.railway.grpc.BookingServiceGrpc;
import com.railway.model.AmountBetweenDTO;
import com.railway.model.PaymentExtendedDTO;
import com.railway.service.PaymentService;
import lombok.RequiredArgsConstructor;
import com.railway.model.PaymentDTO;
import com.railway.model.PaymentEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final ObjectMapper objectMapper;
    private final PaymentService paymentService;

    private final Random random = new Random();

    // private final BookingServiceClient bookingServiceClient;

    @RequestMapping(value = "/payment/status", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByStatus(@RequestBody final String status) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByStatus(status).stream().map(
                                paymentEntity -> new PaymentDTO(
                                        paymentEntity.getPaymentId(),
                                        paymentEntity.getAmount(),
                                        paymentEntity.getPaymentTimestamp(),
                                        paymentEntity.getMethod(),
                                        paymentEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/method", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByMethod(@RequestBody final String method) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByMethod(method).stream().map(
                                paymentEntity -> new PaymentDTO(
                                        paymentEntity.getPaymentId(),
                                        paymentEntity.getAmount(),
                                        paymentEntity.getPaymentTimestamp(),
                                        paymentEntity.getMethod(),
                                        paymentEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/amount", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByAmountIsBetween(@RequestBody final AmountBetweenDTO amount) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByAmountIsBetween(amount.getStartAmount(), amount.getEndAmount())
                                .stream().map(
                                        paymentEntity -> new PaymentDTO(
                                                paymentEntity.getPaymentId(),
                                                paymentEntity.getAmount(),
                                                paymentEntity.getPaymentTimestamp(),
                                                paymentEntity.getMethod(),
                                                paymentEntity.getStatus()
                                        )
                                ).toList()
                )
        );
    }

//     @RequestMapping(value = "/payment/timestamp", method = RequestMethod.GET)
//     public ResponseEntity<String> getPaymentByTimestamp(@RequestBody final Timestamp timestamp) throws JsonProcessingException {
//         return ResponseEntity.ok(
//                 objectMapper.writeValueAsString(
//                         paymentService.findAllByPaymentTimestamp(timestamp)
//                                 .stream().map(
//                                         paymentEntity -> new PaymentDTO(
//                                                 paymentEntity.getPaymentId(),
//                                                 paymentEntity.getAmount(),
//                                                 paymentEntity.getPaymentTimestamp(),
//                                                 paymentEntity.getMethod(),
//                                                 paymentEntity.getStatus()
//                                                 )
//                                 ).toList()
//                 )
//         );
//     }

    @RequestMapping(value = "/payment/all", method = RequestMethod.GET)
    public ResponseEntity<String> getAllPayment()
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllPayments()
                                .stream().map(
                                        paymentEntity -> new PaymentDTO(
                                                paymentEntity.getPaymentId(),
                                                paymentEntity.getAmount(),
                                                paymentEntity.getPaymentTimestamp(),
                                                paymentEntity.getMethod(),
                                                paymentEntity.getStatus()
                                        )
                                ).toList()
                )
        );
    }

//     @RequestMapping(value = "/payment/timestamp_date", method = RequestMethod.GET)
//     public ResponseEntity<String> getPaymentByTimestamp_Date(@RequestBody final int timestamp_date) throws JsonProcessingException {
//         return ResponseEntity.ok(
//                 objectMapper.writeValueAsString(
//                         paymentService.findAllByPaymentTimestamp_Date(timestamp_date)
//                                 .stream().map(
//                                         paymentEntity -> new PaymentDTO(
//                                                 paymentEntity.getPaymentId(),
//                                                 paymentEntity.getAmount(),
//                                                 paymentEntity.getPaymentTimestamp(),
//                                                 paymentEntity.getMethod(),
//                                                 paymentEntity.getStatus()
//                                                 )
//                                 ).toList()
//                 )
//         );
//     }

//     @RequestMapping(value = "/payment/timestamp_year", method = RequestMethod.GET)
//     public ResponseEntity<String> getPaymentByTimestamp_Year(@RequestBody final int timestamp_year) throws JsonProcessingException {
//         return ResponseEntity.ok(
//                 objectMapper.writeValueAsString(
//                         paymentService.findAllByPaymentTimestamp_Year(timestamp_year)
//                                 .stream().map(
//                                         paymentEntity -> new PaymentDTO(
//                                                 paymentEntity.getPaymentId(),
//                                                 paymentEntity.getAmount(),
//                                                 paymentEntity.getPaymentTimestamp(),
//                                                 paymentEntity.getMethod(),
//                                                 paymentEntity.getStatus()
//                                                 )
//                                 ).toList()
//                 )
//         );
//     }

//     @RequestMapping(value = "/payment/timestamp_month", method = RequestMethod.GET)
//     public ResponseEntity<String> getPaymentByTimestamp_Month(@RequestBody final int timestamp_month) throws JsonProcessingException {
//         return ResponseEntity.ok(
//                 objectMapper.writeValueAsString(
//                         paymentService.findAllByPaymentTimestamp_Month(timestamp_month)
//                                 .stream().map(
//                                         paymentEntity -> new PaymentDTO(
//                                                 paymentEntity.getPaymentId(),
//                                                 paymentEntity.getAmount(),
//                                                 paymentEntity.getPaymentTimestamp(),
//                                                 paymentEntity.getMethod(),
//                                                 paymentEntity.getStatus()
//                                                 )
//                                 ).toList()
//                 )
//         );
//     }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<String> addPayment(@RequestBody final PaymentDTO paymentDTO) throws JsonProcessingException {
        PaymentEntity paymentEntity = paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new PaymentDTO(
                                paymentEntity.getPaymentId(),
                                paymentEntity.getAmount(),
                                paymentEntity.getPaymentTimestamp(),
                                paymentEntity.getMethod(),
                                paymentEntity.getStatus()
                        )
                )
        );
    }

//    @RequestMapping(value = "/payment/pay", method = RequestMethod.POST)
//    public ResponseEntity<String> pay(@RequestBody final PaymentExtendedDTO paymentDTO) throws JsonProcessingException, InterruptedException {
//        Booking.GetBookingInfoAndCheckReservationResponse response =
//                bookingServiceClient.getBookingInfoAndCheckReservation(paymentDTO.getBookingId());
//        if (response.getStatus() == Booking.BookingStatus.Booked) {
//            int pause = random.nextInt(30);
//            TimeUnit.SECONDS.sleep(pause);
//            boolean isSuccess = random.nextBoolean();
//            if (isSuccess) {
//                PaymentDTO dto = new PaymentDTO(paymentDTO.getPaymentId(),
//                        paymentDTO.getAmount(),
//                        paymentDTO.getPaymentTimestamp(),
//                        paymentDTO.getMethod(),
//                        paymentDTO.getStatus());
//                try {
//                    bookingServiceClient.removeBooking(paymentDTO.getPaymentId());
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                return addPayment(dto);
//            }
//            else {
//                if (random.nextBoolean()) {
//                    pause = random.nextInt(60);
//                    TimeUnit.SECONDS.sleep(pause);
//                    if (random.nextBoolean()) {
//                        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
//                                .body(HttpStatus.BAD_GATEWAY.getReasonPhrase());
//                    }
//                    return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
//                            .body(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase());
//                }
//                if (random.nextBoolean()) {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                            .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
//                }
//                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
//                        .body(HttpStatus.EXPECTATION_FAILED.getReasonPhrase());
//            }
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
//    }

    @RequestMapping(value = "/payment/payhttp", method = RequestMethod.POST)
    public ResponseEntity<String> payHttp(@RequestBody final PaymentExtendedDTO paymentDTO) throws JsonProcessingException, InterruptedException {
        Booking.GetBookingInfoAndCheckReservationResponse responseObj = null;
        try {
            long bookingId = paymentDTO.getBookingId();
            JSONObject json = new JSONObject();
            json.put("booking_id", bookingId);
//
//            HttpClient client = HttpClient.newHttpClient();
//            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
//                    .uri(URI.create("http://booking_service:8080/booking/book_create_http"))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://train_service:8080/booking/http/"+bookingId);
            httpGet.setHeader("Content-type", "application/json");

            HttpResponse response = httpClient.execute(httpGet);
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(responseString);

            if (response.getStatusLine().getStatusCode()  == 200) {
                JSONObject jsonResponse = new JSONObject(responseString);
                int bookingId_ = jsonResponse.getInt("bookingId_");
                String userEmail_ = jsonResponse.getString("userEmail_");
                int seatId_ = jsonResponse.getInt("seat_id");
                Booking.BookingStatus status_ = Booking.BookingStatus.valueOf(jsonResponse.getInt("status_"));
                responseObj = Booking.GetBookingInfoAndCheckReservationResponse.newBuilder()
                        .setBookingId(bookingId_).setUserEmail(userEmail_).setSeatId(seatId_).setStatus(status_).build();
            } else {
                System.err.println("Error: " + response.getStatusLine().getStatusCode());
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (responseObj != null && responseObj.getUserEmail().equals(paymentDTO.getUserEmail()) &&
                responseObj.getStatus() == Booking.BookingStatus.Booked) {
            int pause = random.nextInt(30);
            TimeUnit.SECONDS.sleep(pause);
            boolean isSuccess = random.nextBoolean();
            if (isSuccess) {
                PaymentDTO dto = new PaymentDTO(paymentDTO.getPaymentId(),
                        paymentDTO.getAmount(),
                        paymentDTO.getPaymentTimestamp(),
                        paymentDTO.getMethod(),
                        paymentDTO.getStatus());
                try {
                    long paymentId = paymentDTO.getPaymentId();

                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpDelete httpDelete = new HttpDelete("http://bookingservice:8080/booking/http/"+paymentId);
                    httpDelete.setHeader("Content-type", "application/json");
//                    HttpClient client = HttpClient.newHttpClient();
//                    java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
//                            .uri(URI.create("http://booking_service:8080/booking/http/" + paymentId))
//                            .header("Content-Type", "application/json")
//                            .DELETE()
//                            .build();
//
//                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    HttpResponse response = httpClient.execute(httpDelete);
                    String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println(responseString);
                    if (response.getStatusLine().getStatusCode() != 200) {
                        ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return addPayment(dto);
            } else {
                if (random.nextBoolean()) {
                    pause = random.nextInt(60);
                    TimeUnit.SECONDS.sleep(pause);
                    if (random.nextBoolean()) {
                        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                .body(HttpStatus.BAD_GATEWAY.getReasonPhrase());
                    }
                    return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                            .body(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase());
                }
                if (random.nextBoolean()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
                }
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                        .body(HttpStatus.EXPECTATION_FAILED.getReasonPhrase());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentById(@PathVariable("id") Long id) throws JsonProcessingException {
        PaymentEntity paymentEntity = paymentService.getPaymentById(id);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new PaymentDTO(
                                paymentEntity.getPaymentId(),
                                paymentEntity.getAmount(),
                                paymentEntity.getPaymentTimestamp(),
                                paymentEntity.getMethod(),
                                paymentEntity.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/payment/simulate", method = RequestMethod.POST)
    public ResponseEntity<String> simulatePayment(@RequestBody final PaymentDTO paymentDTO)
            throws JsonProcessingException, InterruptedException {
        int pause = random.nextInt(30);
        TimeUnit.SECONDS.sleep(pause);
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            return addPayment(paymentDTO);
        } else {
            if (random.nextBoolean()) {
                pause = random.nextInt(60);
                TimeUnit.SECONDS.sleep(pause);
                if (random.nextBoolean()) {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(HttpStatus.BAD_GATEWAY.getReasonPhrase());
                }
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                        .body(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase());
            }
            if (random.nextBoolean()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
            }
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(HttpStatus.EXPECTATION_FAILED.getReasonPhrase());
        }
    }
}
