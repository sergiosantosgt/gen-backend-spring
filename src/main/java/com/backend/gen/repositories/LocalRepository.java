package com.backend.gen.repositories;

import com.backend.gen.domain.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {

}
