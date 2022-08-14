package com.example.carparkproject.repository;

import com.example.carparkproject.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {
    @Query("SELECT p FROM ParkingLot p WHERE (:parkName is null or p.parkName like %:parkName%)" +
            "AND (:parkPlace is null or p.parkPlace like %:parkPlace%)" +
            "AND (:parkArea is null or p.parkAreaTemp like %:parkArea%)" +
            "AND (:parkPrice is null or p.parkPriceTemp like %:parkPrice%)" +
            "AND (:parkStatus is null or p.parkStatus like %:parkStatus%)")
    Page<ParkingLot> getListParkingLots(@Param("parkName") String parkName,
                                        @Param("parkPlace") String parkPlace,
                                        @Param("parkArea") String parkArea,
                                        @Param("parkPrice") String parkPrice,
                                        @Param("parkStatus") String parkStatus,
                                        Pageable pageable);

    ParkingLot findParkingLotByParkId(Long id);


}
