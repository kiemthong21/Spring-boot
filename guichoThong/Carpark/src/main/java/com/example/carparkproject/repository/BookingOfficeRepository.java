package com.example.carparkproject.repository;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.entity.BookingOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice,Long> {


    @Query("SELECT new com.example.carparkproject.dto.BookingOfficeDTO(b.officeId,b.endContractDeadline,b.officeName," +
            "b.officePhone,b.officePlace,b.officePrice,b.startContractDeadline,t.destination) " +
            "FROM BookingOffice b LEFT JOIN Trip t ON b.tripId = t.tripId " +
            "WHERE (:officeName is null or b.officeName like %:officeName%) " +
            "AND (t.destination is null or t.destination like %:tripName% )")
    Page<BookingOfficeDTO> getListBookingOffice(@Param("officeName")String officeName,
                                                @Param("tripName")String tripName,
                                                Pageable pageable);


    BookingOffice findBookingOfficeByOfficeId(Long officeId);

    @Query("SELECT new com.example.carparkproject.dto.BookingOfficeDTO(b.officeId,b.endContractDeadline,b.officeName," +
            "b.officePhone,b.officePlace,b.officePrice,b.startContractDeadline,t.destination) " +
            "FROM BookingOffice b LEFT JOIN Trip t ON b.tripId = t.tripId " +
            "WHERE b.officeId = :id")
    BookingOfficeDTO getDetailBookingOfficeWithDestination(@Param("id") Long id);

    List<BookingOffice> findAllByTripId(Long tripId);

}
