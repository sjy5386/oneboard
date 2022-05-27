package com.sysbot32.oneboard.boards;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* 이름 */
    @Column(nullable = false, unique = true)
    private String name;

    /* 제목 */
    @Column(nullable = false)
    private String title;

    /* 설명 */
    private String description;

    /* 목록 보기 권한 */
    @Column(nullable = false)
    private Short listPermission = 0;

    /* 글 읽기 권한 */
    @Column(nullable = false)
    private Short readPermission = 0;

    /* 글 쓰기 권한 */
    @Column(nullable = false)
    private Short writePermission = 0;

    /* 댓글 쓰기 권한 */
    @Column(nullable = false)
    private Short commentPermission = 0;

    /* 파일 업로드 권한 */
    @Column(nullable = false)
    private Short uploadPermission = 1;

    /* 파일 다운로드 권한 */
    @Column(nullable = false)
    private Short downloadPermission = 1;

    /* 글 읽기 포인트 */
    @Column(nullable = false)
    private Integer readPoint = 0;

    /* 글 쓰기 포인트 */
    @Column(nullable = false)
    private Integer writePoint = 10;

    /* 댓글 쓰기 포인트 */
    @Column(nullable = false)
    private Integer commentPoint = 1;

    /* 파일 다운로드 포인트 */
    @Column(nullable = false)
    private Integer downloadPoint = -1;

    /* 글 쓰기 기본 내용 */
    private String defaultContent;

    @OneToMany
    private List<Post> posts;
}
