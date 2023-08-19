package com.diana.insurance.repository;

import com.diana.insurance.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findOwnersByBank_Id(long bankId);
}
