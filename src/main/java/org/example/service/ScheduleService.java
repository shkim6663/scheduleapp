package org.example.service;

import org.example.dto.*;
import org.example.model.Schedule;
import org.example.model.Comment;
import org.example.repository.ScheduleRepository;
import org.example.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, CommentRepository commentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.commentRepository = commentRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto request) {
        if(request.getTitle() == null || request.getTitle().isEmpty() || request.getTitle().length() > 30)
            throw new IllegalArgumentException("제목 필수, 30자 이내");
        if(request.getDescription() == null || request.getDescription().isEmpty() || request.getDescription().length() > 200)
            throw new IllegalArgumentException("내용 필수, 200자 이내");
        if(request.getAuthor() == null || request.getAuthor().isEmpty())
            throw new IllegalArgumentException("작성자 필수");
        if(request.getPassword() == null || request.getPassword().isEmpty())
            throw new IllegalArgumentException("비밀번호 필수");

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getDescription(),
                request.getAuthor(),
                request.getPassword()
        );
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));
        return new ScheduleResponseDto(schedule);
    }

    public void updateSchedule(Long id, ScheduleRequestDto request, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));
        if(!schedule.getPassword().equals(password))
            throw new IllegalArgumentException("비밀번호 틀림");

        if(request.getTitle() != null && request.getTitle().length() <= 30)
            schedule.setTitle(request.getTitle());
        if(request.getAuthor() != null)
            schedule.setAuthor(request.getAuthor());

        schedule.setUpdatedAt(LocalDateTime.now());
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));
        if(!schedule.getPassword().equals(password))
            throw new IllegalArgumentException("비밀번호 틀림");
        scheduleRepository.delete(schedule);
    }

    // 댓글 생성
    public void createComment(Long scheduleId, CommentRequestDto request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));
        List<Comment> comments = commentRepository.findByScheduleId(scheduleId);
        if(comments.size() >= 10)
            throw new IllegalArgumentException("댓글 10개 초과");

        if(request.getContent() == null || request.getContent().isEmpty() || request.getContent().length() > 100)
            throw new IllegalArgumentException("댓글 내용 필수, 100자 이내");
        if(request.getAuthor() == null || request.getAuthor().isEmpty())
            throw new IllegalArgumentException("작성자 필수");
        if(request.getPassword() == null || request.getPassword().isEmpty())
            throw new IllegalArgumentException("비밀번호 필수");

        Comment comment = new Comment(request.getContent(), request.getAuthor(), request.getPassword(), schedule);
        commentRepository.save(comment);
    }
}
