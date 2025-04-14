package com.zephyr.api.repositories;

import com.zephyr.api.domain.cupom.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CuponRepository extends JpaRepository<Cupon, UUID> {
}
