package com.capgemini.HMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.HMS.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberMemberId(Long memberId);
}