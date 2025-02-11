package com.goneka.repository;

import com.goneka.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SalonRepository extends JpaRepository<Salon, Long> {

    List<Salon> findByOwnerId(Long id);  // Returns a list in case there are multiple salons for an owner

    @Query(
        "SELECT s FROM Salon s WHERE " +
            "LOWER(s.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%'))"
    )
    List<Salon> searchSalons(@Param("keyword") String keyword);
}
