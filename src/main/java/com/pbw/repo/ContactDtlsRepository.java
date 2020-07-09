package com.pbw.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbw.entity.ContactEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactEntity, Serializable>{

}
