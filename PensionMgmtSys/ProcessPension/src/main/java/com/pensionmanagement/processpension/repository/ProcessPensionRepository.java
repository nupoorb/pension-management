package com.pensionmanagement.processpension.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionmanagement.processpension.model.PensionDetail;

@Repository
public interface ProcessPensionRepository extends JpaRepository<PensionDetail,Long> {

}
