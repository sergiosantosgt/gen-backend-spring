package com.backend.gen.resources;

import com.backend.gen.domain.Post;
import com.backend.gen.domain.PostCategoria;
import com.backend.gen.dto.PostCategoriaDTO;
import com.backend.gen.dto.PostDTO;
import com.backend.gen.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Post obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getAll() {
        List<Post> list = service.findAll();
//        System.out.println("OBJ POST " + list.toString());
//        List<PostDTO> listDTO = list.stream().map(obj -> new PostDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Post obj) {
        Post objRet = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
