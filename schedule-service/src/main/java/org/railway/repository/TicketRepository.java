package org.railway.repository;

import org.railway.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    Optional<TicketEntity> findBySeatId(Long seatId);

    List<TicketEntity> findAllByCarriageId(Long carriageId);

    List<TicketEntity> findAllByTrainId(Long trainId);

    List<TicketEntity> findAllByArrivalStationAndDepartureStation(String arrivalStation, String departureStation);

    List<TicketEntity> findAllByArrivalStation(String arrivalStation);

    List<TicketEntity> findAllByDepartureStation(String departureStation);

    List<TicketEntity> findAllByJourneyDate(Timestamp journeyDate);

    List<TicketEntity> findAllByArrivalStationAndDepartureStationAndJourneyDate(String arrivalStation,
                                                                                String departureStation,
                                                                                Timestamp journeyDate);
}
