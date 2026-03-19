package com.example.recharge.repository;

import com.example.recharge.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {
}
