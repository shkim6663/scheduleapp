package org.example.dto;

import lombok.*;
import org.example.model.Comment;
import org.example.model.Schedule;


import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
public class ScheduleDetailResponseDto extends ScheduleResponseDto {
    private List<CommentResponseDto> comments;

    public ScheduleDetailResponseDto(Schedule schedule, List<Comment> commentList) {
        super(schedule);
        this.comments = commentList.stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}
