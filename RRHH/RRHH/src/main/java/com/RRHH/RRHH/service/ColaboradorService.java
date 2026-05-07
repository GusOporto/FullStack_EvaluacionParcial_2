package com.RRHH.RRHH.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.repository.ColaboradorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }

    public Colaborador findById(long id){
        return colaboradorRepository.findById(id).get();
    }

    public Colaborador save(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

    public void delete(Long id){
        colaboradorRepository.deleteById(id);
    }

}
