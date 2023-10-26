package com.farhan.staradmin.model;

import java.util.Date;

import lombok.ToString;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserSample {
    private Long id;
    private String familyName;
    private String firstName;
    private String familyKanaName;
    private String firstKanaName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String gender;
    private String office;
    private String tel;
    private String mail;
    private Boolean isQuit;
    private Date createdAt;
    private Date updatedAt;
}
