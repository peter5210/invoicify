package com.libertymutual.goforcode.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libertymutual.goforcode.invoicify.models.BillingRecord;

public interface BillingRecordRepo extends JpaRepository<BillingRecord, Long> {

}
