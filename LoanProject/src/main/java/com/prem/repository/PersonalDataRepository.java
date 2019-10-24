package com.prem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prem.model.PersonalTable;

@Repository
public interface PersonalDataRepository extends CrudRepository<PersonalTable, Integer>{

}
