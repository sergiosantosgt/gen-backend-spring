package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Local;
import com.nelioalves.cursomc.domain.Post;
import com.nelioalves.cursomc.repositories.PostRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
