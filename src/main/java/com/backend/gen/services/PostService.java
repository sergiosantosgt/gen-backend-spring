package com.backend.gen.services;

import com.backend.gen.domain.Post;
import com.backend.gen.domain.PostCategoria;
import com.backend.gen.repositories.PostRepository;
import com.backend.gen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post buscar(Integer id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Post.class.getName()));
    }

    public List<Post> findAll() {
        System.out.println("REPOSITORY" + repository.findAllPosts().toString());
        return repository.findAllPosts();
    }

    public Post insert(Post obj) {
        obj.setId(null);
        return repository.save(obj);
    }
}
