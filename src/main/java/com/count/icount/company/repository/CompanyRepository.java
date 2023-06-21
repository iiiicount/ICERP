package com.count.icount.company.repository;

import com.count.icount.company.Model.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
