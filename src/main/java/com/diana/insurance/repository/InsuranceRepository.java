package com.diana.insurance.repository;

import com.diana.insurance.entity.Insurance;
import com.diana.insurance.enums.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    boolean existsByInsuranceTypeAndBankAccountId(InsuranceType insuranceType, long bankAccountId);

    List<Insurance> findAllByBankAccount_Id(long bankId);

}
