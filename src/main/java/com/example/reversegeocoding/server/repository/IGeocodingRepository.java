package com.example.reversegeocoding.server.repository;

import com.example.reversegeocoding.server.model.entity.AddressMapperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeocodingRepository extends JpaRepository<AddressMapperEntity, Long> {
}
