package com.railway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.model.TicketRouteDTO;
import com.railway.model.TicketScheduleDTO;
import com.railway.service.TicketService;
import lombok.RequiredArgsConstructor;
import com.railway.model.TicketDTO;
import com.railway.model.TicketEntity;
import com.railway.utils.ErrorsGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final ObjectMapper objectMapper;
    private final TicketService ticketService;

    private final ErrorsGenerator errorsGenerator;

    @RequestMapping(value = "/ticket/train/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketByTrain(@PathVariable("id") Long trainId) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllByTrainId(trainId).stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket/all", method = RequestMethod.GET)
    public ResponseEntity<String> getAllTickets() throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllTicket().stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket/arrival_station", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketsByArrivalStation(@RequestBody final String arrivalStation)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllByArrivalStation(arrivalStation).stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket/departure_station", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketsByDepartureStation(@RequestBody final String departureStation)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllByDepartureStation(departureStation).stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket/arrival_departure_stations", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketsByArrivalStationAndDepartureStation(@RequestBody final TicketRouteDTO routeDTO)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllByArrivalStationAndDepartureStation(
                                routeDTO.getArrivalStation(),
                                routeDTO.getDepartureStation()).stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket/arrival_departure_stations", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketsByArrivalStationAndDepartureStationAndJourneyDate(
            @RequestBody final TicketScheduleDTO scheduleDTO)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllByArrivalStationAndDepartureStationAndJourneyDate(
                                scheduleDTO.getArrivalStation(),
                                scheduleDTO.getDepartureStation(),
                                scheduleDTO.getJourneyDate()).stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public ResponseEntity<String> addTicket(@RequestBody final TicketDTO ticketDTO) throws JsonProcessingException {
        TicketEntity ticketEntity = ticketService.createTicket(ticketDTO);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new TicketDTO(
                                ticketEntity.getTicketId(),
                                ticketEntity.getTrainId(),
                                ticketEntity.getJourneyDate(),
                                ticketEntity.getArrivalStation(),
                                ticketEntity.getDepartureStation(),
                                ticketEntity.getCarriageId(),
                                ticketEntity.getPrice(),
                                ticketEntity.getSeatId(),
                                ticketEntity.getPaymentId()
                        )
                )
        );
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> editTicket(@PathVariable("id") Long id, @RequestBody final TicketDTO ticketDTO)
            throws JsonProcessingException {
        TicketEntity ticketEntity = ticketService.getTicketById(id);
        if (ticketEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    errorsGenerator.generateErrorByStatus(HttpStatus.NOT_FOUND)
            );
        }

        ticketEntity.setTicketId(ticketDTO.getTicketId());
        ticketEntity.setArrivalStation(ticketDTO.getArrivalStation());
        ticketEntity.setCarriageId(ticketDTO.getCarriageId());
        ticketEntity.setDepartureStation(ticketDTO.getDepartureStation());
        ticketEntity.setTrainId(ticketDTO.getTrainId());
        ticketEntity.setSeatId(ticketDTO.getSeatId());
        ticketEntity.setPaymentId(ticketDTO.getPaymentId());
        ticketEntity.setPrice(ticketDTO.getPrice());
        ticketEntity.setJourneyDate(ticketDTO.getJourneyDate());

        TicketEntity updatedTicket = ticketService.updateTicket(ticketEntity);

        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new TicketDTO(
                                updatedTicket.getTicketId(),
                                updatedTicket.getTrainId(),
                                updatedTicket.getJourneyDate(),
                                updatedTicket.getArrivalStation(),
                                updatedTicket.getDepartureStation(),
                                updatedTicket.getCarriageId(),
                                updatedTicket.getPrice(),
                                updatedTicket.getSeatId(),
                                updatedTicket.getPaymentId()
                        )
                )
        );
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTicket(@PathVariable("id") Long id) {
        TicketEntity ticketEntity = ticketService.getTicketById(id);
        if (ticketEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    errorsGenerator.generateErrorByStatus(HttpStatus.NOT_FOUND)
            );
        } else {
            ticketService.deleteTicketById(id);
            return ResponseEntity.ok(ErrorsGenerator.EMPTY_ERRORS);
        }
    }

    @RequestMapping(value = "/ticket/seat/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketBySeat(@PathVariable("id") Long seatId)
            throws JsonProcessingException {
        TicketEntity ticketEntity = ticketService.findBySeatId(seatId);
        if (ticketEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    errorsGenerator.generateErrorByStatus(HttpStatus.NOT_FOUND)
            );
        } else {
            return ResponseEntity.ok(
                    objectMapper.writeValueAsString(
                            new TicketDTO(
                                    ticketEntity.getTicketId(),
                                    ticketEntity.getTrainId(),
                                    ticketEntity.getJourneyDate(),
                                    ticketEntity.getArrivalStation(),
                                    ticketEntity.getDepartureStation(),
                                    ticketEntity.getCarriageId(),
                                    ticketEntity.getPrice(),
                                    ticketEntity.getSeatId(),
                                    ticketEntity.getPaymentId()
                            )
                    )
            );
        }
    }

    @RequestMapping(value = "/ticket/carriage/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketByCarriage(@PathVariable("id") Long carriageId)
            throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        ticketService.findAllByCarriageId(carriageId).stream().map(
                                ticketEntity -> new TicketDTO(
                                        ticketEntity.getTicketId(),
                                        ticketEntity.getTrainId(),
                                        ticketEntity.getJourneyDate(),
                                        ticketEntity.getArrivalStation(),
                                        ticketEntity.getDepartureStation(),
                                        ticketEntity.getCarriageId(),
                                        ticketEntity.getPrice(),
                                        ticketEntity.getSeatId(),
                                        ticketEntity.getPaymentId()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTicketById(@PathVariable("id") Long id) throws JsonProcessingException {
        TicketEntity ticketEntity = ticketService.getTicketById(id);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new TicketDTO(
                                ticketEntity.getTicketId(),
                                ticketEntity.getTrainId(),
                                ticketEntity.getJourneyDate(),
                                ticketEntity.getArrivalStation(),
                                ticketEntity.getDepartureStation(),
                                ticketEntity.getCarriageId(),
                                ticketEntity.getPrice(),
                                ticketEntity.getSeatId(),
                                ticketEntity.getPaymentId()
                        )
                )
        );
    }
}
