package com.example.RedWeb.Repo;


import com.example.RedWeb.Entity.BloodRequestEntity;
import com.example.RedWeb.Entity.DriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveRepository extends JpaRepository<DriveEntity, Long> {
    List<DriveEntity> findByCreatedByEmail(String email);

    @Query("SELECT b FROM BloodRequestEntity b ORDER BY b.createdAt DESC")
    List<BloodRequestEntity> findAllSortedByDateDesc();

}
