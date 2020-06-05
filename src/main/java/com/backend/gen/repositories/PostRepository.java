package com.backend.gen.repositories;

import com.backend.gen.domain.Cidade;
import com.backend.gen.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Transactional(readOnly=true)
    @Query(
            "SELECT obj FROM Post obj " +
            "INNER JOIN FETCH obj.postCategorias "
    )
    public List<Post> findAllPosts();
}
