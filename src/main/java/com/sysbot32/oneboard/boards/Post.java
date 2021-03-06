package com.sysbot32.oneboard.boards;

import com.sysbot32.oneboard.users.User;
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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    private PostCategory category;

    /* 제목 */
    @Column(nullable = false)
    private String title;

    /* 공지글 */
    @Column(nullable = false)
    private Boolean isNotice = false;

    /* 비밀글 */
    @Column(nullable = false)
    private Boolean isPrivate = false;

    /* 내용 */
    @Column(nullable = false)
    private String content;

    /* 조회수 */
    @Column(nullable = false)
    private Long viewCount = 0L;

    @OneToMany
    private List<Comment> comments;
}
