package com.greenrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenrent.domain.ContactMessage;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long>{

}
