package com.diana.insurance.repository;

import com.diana.insurance.entity.Insurance;
import com.diana.insurance.enums.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    boolean existsByInsuranceTypeAndBankId(InsuranceType insuranceType, long bankId);

    List<Insurance> findAllByBank_Id(long bankId);

}
