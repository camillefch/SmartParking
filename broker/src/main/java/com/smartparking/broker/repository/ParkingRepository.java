package com.smartparking.broker.repository;

import com.smartparking.broker.entity.Parking;

import java.util.List;
import java.util.Optional;

public interface ParkingRepository {
    int count();

    int save(Parking parking);

    int update(Parking parking);

    int deleteById(int id);

    List<Parking> findAll();

    Optional<Parking> findById(int id);

    int getNbSpotsById(int id);

    int getAvailableSpotsById(int id);


}
