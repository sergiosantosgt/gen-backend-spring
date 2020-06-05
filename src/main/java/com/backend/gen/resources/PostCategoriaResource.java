package com.backend.gen.resources;

import com.backend.gen.domain.Categoria;
import com.backend.gen.domain.PostCategoria;
import com.backend.gen.dto.CategoriaDTO;
import com.backend.gen.dto.PostCategoriaDTO;
import com.backend.gen.services.PostCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts-categorias")
public class PostCategoriaResource {

    @Autowired
    private PostCategoriaService service;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<PostCategoriaDTO>> findAll() {
        List<PostCategoria> list = service.findAll();
        List<PostCategoriaDTO> listDto = list.stream().map(obj -> new PostCategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PostCategoriaDTO objDto) {
        PostCategoria obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
