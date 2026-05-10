package com.RRHH.RRHH.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.DTO.AreaDTO;
import com.RRHH.RRHH.model.Area;
import com.RRHH.RRHH.service.AreaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;
    
    @GetMapping
    public ResponseEntity<List<AreaDTO>> todasLasAreas(){
        List<AreaDTO> areas = areaService.obtenerAreas();
        if(areas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(areas,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> buscarPorId(@PathVariable Long id) {
        try{
            AreaDTO area = areaService.buscarPorId(id);
            return new ResponseEntity<>(area, HttpStatus.OK);
        }catch (RuntimeException e){
        return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<AreaDTO> agregarArea(@RequestBody Area area){
        try{
            AreaDTO guardadaDTO = areaService.guardarArea(area);
            return new ResponseEntity<>(guardadaDTO, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AreaDTO> actualizarArea(@PathVariable Long id, @RequestBody Area area){
        try{
            AreaDTO areaActualizadaDTO = areaService.actualizarArea(id, area);
            return new ResponseEntity<>(areaActualizadaDTO, HttpStatus.OK);
        } catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarArea(@PathVariable Long id) {
        String resultado = areaService.eliminar(id);
        if (resultado.contains("exitosamente")){
            return new ResponseEntity<>(resultado,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resultado,HttpStatus.NOT_FOUND);
        }
    }
}
