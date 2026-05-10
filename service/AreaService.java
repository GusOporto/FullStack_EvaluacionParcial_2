package com.RRHH.RRHH.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.model.Area;
import com.RRHH.RRHH.repository.AreaRepository;



@Service
public class AreaService {
    
    @Autowired
    private AreaRepository areaRepository;

    public List<Area> obtenerAreas(){
        return areaRepository.findAll();
    }

    public Area guardarArea(Area area){
        return areaRepository.save(area);
    }

    public Area obtenerAreaPorId(Long id){
        return areaRepository.findById(id).orElse(null);    
    }

    public void eliminarArea(Long id) {
        areaRepository.deleteById(id);
    }


}
