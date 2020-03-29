package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Local;
import com.nelioalves.cursomc.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/locais")
public class LocalResource {

    @Autowired
    private LocalService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
//        Local local = new Local(1,"São Paulo");
//        Local local2 = new Local(2,"Cruzeiro");
//
//        List<Local> listaLocal = new ArrayList<>();
//        listaLocal.add(local);
//        listaLocal.add(local2);

        Local obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
