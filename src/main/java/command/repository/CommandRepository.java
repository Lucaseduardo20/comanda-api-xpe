package com.lucas.command.repository;

import com.lucas.command.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
}