package org.example.controller;

import org.example.dto.*;
import org.example.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 생성
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto request) {
        return scheduleService.createSchedule(request);
    }

    // 전체 일정 조회
    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    // 단일 일정 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto request,
                               @RequestParam String password) {
        scheduleService.updateSchedule(id, request, password);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestBody DeleteRequestDto request) {
        scheduleService.deleteSchedule(id, request.getPassword());
    }

    // 댓글 생성
    @PostMapping("/{id}/comments")
    public void createComment(@PathVariable Long id, @RequestBody CommentRequestDto request) {
        scheduleService.createComment(id, request);
    }
}



