package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxapplication.dtos.UserDto;

public interface OlxLoginRepository extends JpaRepository<UserDto, Long> {

}
