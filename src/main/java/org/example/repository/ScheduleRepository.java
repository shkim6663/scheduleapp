package org.example.repository;

import org.example.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByAuthorOrderByUpdatedAtDesc(String author);
}
