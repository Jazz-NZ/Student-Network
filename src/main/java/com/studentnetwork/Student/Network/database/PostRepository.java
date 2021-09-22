package com.studentnetwork.Student.Network.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {

    Optional<Post> findByIdPost(int idPost);
}
