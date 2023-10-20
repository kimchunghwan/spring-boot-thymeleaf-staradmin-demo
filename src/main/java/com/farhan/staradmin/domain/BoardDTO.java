package com.farhan.staradmin.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Integer id;
    private String title;
    private String content;
    private String name;
    private LocalDateTime create_at;
    private int read;
    private Long memberId;


}
