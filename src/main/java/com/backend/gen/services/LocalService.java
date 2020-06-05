package com.backend.gen.services;

import com.backend.gen.domain.Local;
import com.backend.gen.repositories.LocalRepository;
import com.backend.gen.services.exceptions.ObjectNotFoundException;
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
