package com.avdev.utchipster.repository;

import com.avdev.utchipster.domain.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MyData entity.
 */
@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
