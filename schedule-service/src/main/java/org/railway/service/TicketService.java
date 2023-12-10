package org.railway.service;

import lombok.RequiredArgsConstructor;
import org.railway.model.TicketDTO;
import org.railway.model.TicketEntity;
import org.railway.repository.TicketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    @Transactional
    public TicketEntity createTicket(TicketDTO ticket) {
        TicketEntity newTicket = TicketEntity.builder()
                .trainId(ticket.getTrainId())
                .journeyDate(ticket.getJourneyDate())
                .arrivalStation(ticket.getArrivalStation())
                .departureStation(ticket.getDepartureStation())
                .carriageId(ticket.getCarriageId())
                .price(ticket.getPrice())
                .seatId(ticket.getSeatId())
                .paymentId(ticket.getPaymentId())
                .build();

        return ticketRepository.saveAndFlush(newTicket);
    }

    @Transactional
    public TicketEntity updateTicket(TicketEntity ticket) {
        return ticketRepository.saveAndFlush(ticket);
    }

    @Transactional
    public List<TicketEntity> findAllTicket() {
        return ticketRepository.findAll();
    }

    @Transactional
    public List<TicketEntity> findAllByArrivalStation(String arrivalStation) {
        return ticketRepository.findAllByArrivalStation(arrivalStation);
    }

    @Transactional
    public TicketEntity getTicketById(Long id) {
        Optional<TicketEntity> optionalTicket = ticketRepository.findById(id);

        return optionalTicket
                .orElse(null);
    }

    @Transactional
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Transactional
    public List<TicketEntity> findAllByCarriageId(Long carriageId) {
        return ticketRepository.findAllByCarriageId(carriageId);
    }

    @Transactional
    public List<TicketEntity> findAllByTrainId(Long trainId) {
        return ticketRepository.findAllByCarriageId(trainId);
    }

    @Transactional
    public List<TicketEntity> findAllByArrivalStationAndDepartureStation(String arrivalStation, String departureStation) {
        return ticketRepository.findAllByArrivalStationAndDepartureStation(arrivalStation, departureStation);
    }

    @Transactional
    public List<TicketEntity> findAllByDepartureStation(String departureStation) {
        return ticketRepository.findAllByDepartureStation(departureStation);
    }

    @Transactional
    public TicketEntity findBySeatId(Long seatId) {
        return ticketRepository.findBySeatId(seatId)
                .orElse(null);
    }

    @Transactional
    public List<TicketEntity> findAllByArrivalStationAndDepartureStationAndJourneyDate(String arrivalStation,
                                                                                       String departureStation,
                                                                                       Timestamp journeyDate) {
        return ticketRepository.findAllByArrivalStationAndDepartureStationAndJourneyDate(arrivalStation,
                departureStation, journeyDate);
    }

}
