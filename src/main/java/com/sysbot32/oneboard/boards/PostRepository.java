package com.sysbot32.oneboard.boards;

import com.sysbot32.oneboard.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByBoard(Board board);

    List<Post> findAllByUser(User user);

    List<Post> findAllByIsNotice(Boolean isNotice);
}
