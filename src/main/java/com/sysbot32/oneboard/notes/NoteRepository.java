package com.sysbot32.oneboard.notes;

import com.sysbot32.oneboard.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByFrom(User from);

    List<Note> findAllByTo(User to);

    List<Note> findAllByToAndReadFalse(User to);

    List<Note> findAllByFromAndTo(User from, User to);
}
