package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Local;
import com.nelioalves.cursomc.repositories.LocalRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository repo;

    public Local buscar(Integer id) {

        Optional<Local> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Local.class.getName()));
    }
}
