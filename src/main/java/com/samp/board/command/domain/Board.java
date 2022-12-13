package com.samp.board.command.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "게시판Command 엔티티")
@ToString
@Table("board")
public class Board {
    @Id
    @Schema(description = "게시물 번호", nullable = false, example = "1")
    private int num;
    @Schema(description = "게시물 제목", nullable = false, example = "제목")
    private String title;
    @Schema(description = "게시물 내용")
    private String contents;
    @Schema(description = "게시물 작성자ID", nullable = false, example = "ID")
    private String writeId;
    @Schema(description = "게시물 작성자명", nullable = false, example = "게시물 작성자")
    private String writeName;
    @Schema(description = "게시물 작성일시", nullable = false, example = "YYYYMMDDHHMISS")
    private LocalDateTime writeDate;
    @Schema(description = "게시물 수정자ID", example = "ID")
    private String modifyId;
    @Schema(description = "게시물 수정자명", example = "게시물 수정자")
    private String modifyName;
    @Schema(description = "게시물 수정일시", example = "YYYYMMDDHHMISS")
    private LocalDateTime  modifyDate;
}
