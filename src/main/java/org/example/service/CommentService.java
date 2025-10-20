package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CommentRequestDto;
import org.example.dto.CommentResponseDto;
import org.example.model.Comment;
import org.example.model.Schedule;
import org.example.repository.CommentRepository;
import org.example.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto createComment(Long scheduleId, CommentRequestDto request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "일정을 찾을 수 없습니다."));
        if(commentRepository.countByScheduleId(scheduleId) >= 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "댓글은 최대 10개까지만 작성 가능합니다.");
        }
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setAuthor(request.getAuthor());
        comment.setPassword(request.getPassword());
        comment.setSchedule(schedule);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }
}
