package org.example.repository;

import org.example.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 일정(scheduleId)에 속한 댓글 조회
    List<Comment> findByScheduleId(Long scheduleId);

    // 특정 일정(scheduleId)에 속한 댓글 수 조회
    long countByScheduleId(Long scheduleId);
}

