package com.backend.gen.services;

import com.backend.gen.domain.Categoria;
import com.backend.gen.domain.PostCategoria;
import com.backend.gen.dto.CategoriaDTO;
import com.backend.gen.dto.PostCategoriaDTO;
import com.backend.gen.repositories.PostCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCategoriaService {

    @Autowired
    private PostCategoriaRepository repository;

    public List<PostCategoria> findAll() {
        return repository.findAll();
    }

    public PostCategoria fromDTO(PostCategoriaDTO objDto) {
        return new PostCategoria(objDto.getId(), objDto.getNome());
    }

    public PostCategoria insert(PostCategoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }
}
