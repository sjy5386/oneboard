package com.sysbot32.oneboard.users;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    /* 닉네임 */
    private String nickname;

    /* 이름 */
    private String name;

    /* 이메일 */
    private String email;

    /* 생년월일 */
    private LocalDate dateOfBirth;

    /* 전화번호 */
    private String phone;

    /* 홈페이지 */
    private String homepage;

    /* 자기소개 */
    private String selfIntroduction;

    /* 회원 레벨 */
    @Column(nullable = false)
    private Short level = 1;
}
