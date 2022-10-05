package com.smartparking.broker.repository;

import com.smartparking.broker.entity.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcParkingRepository implements ParkingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from parkings", Integer.class);
    }

    @Override
    public int save(Parking parking) {
        return jdbcTemplate.update(
                "insert into parkings (longitude, latitude, nbspots) values(?,?,?)",
                parking.getLongitude(), parking.getLatitude(), parking.getNbSpots());
    }

    @Override
    public int update(Parking parking) {
        return jdbcTemplate.update(
                "update parkings set longitude = ?, latitude = ?, spotsavailable = ?, nbspots = ? , where id = ?",
                parking.getLongitude(), parking.getLatitude(), parking.getSpotsavailable(), parking.getNbSpots(), parking.getId());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete parkings where id = ?",
                id);
    }

    @Override
    public List<Parking> findAll() {
        return jdbcTemplate.query(
                "select * from parking",
                (rs, rowNum) ->
                        new Parking(
                                rs.getInt("id"),
                                rs.getInt("longitude"),
                                rs.getInt("latitude"),
                                rs.getInt("spotsavailable"),
                                rs.getInt("nbspots")
                        )
        );
    }

    @Override
    public Optional<Parking> findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from parkings where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Parking(
                                rs.getInt("id"),
                                rs.getInt("longitude"),
                                rs.getInt("latitude"),
                                rs.getInt("spotsavailable"),
                                rs.getInt("nbspots")
                        ))
        );
    }

    @Override
    public int getNbSpotsById(int id) {
        return jdbcTemplate.queryForObject(
                "select nbspots from parkings where id = ?",
                new Object[]{id},
                Integer.class
        );
    }

    @Override
    public int getAvailableSpotsById(int id) {
        return jdbcTemplate.queryForObject(
                "select spotsavailable from parkings where id = ?",
                new Object[]{id},
                Integer.class
        );
    }
}
