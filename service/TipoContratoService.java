package com.RRHH.RRHH.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.model.TipoContrato;
import com.RRHH.RRHH.repository.TipoContratoRepository;

@Service
public class TipoContratoService {

    @Autowired
    private TipoContratoRepository tipoContratoRepository;

    public List<TipoContrato> obtenerTipoContrato(){
        return tipoContratoRepository.findAll();
    }

    public TipoContrato guardarTipoContrato(TipoContrato tipoContrato){
        return tipoContratoRepository.save(tipoContrato);
    }

    public TipoContrato obtenerTipoContratoPorId(Long id) {
        return tipoContratoRepository.findById(id).orElse(null);

    }

    public void eliminarTipoContrato(Long id){
        tipoContratoRepository.deleteById(id);
    }

}
