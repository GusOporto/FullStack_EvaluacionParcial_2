package com.RRHH.RRHH.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.model.Area;
import com.RRHH.RRHH.service.AreaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;
    
    @GetMapping
    public ResponseEntity<List<Area>> obtenerAreas() {
        return ResponseEntity.ok(areaService.obtenerAreas());
    }
    
    @PostMapping
    public ResponseEntity<Area> guardarArea(@RequestBody Area area) {
        Area nuevaArea = areaService.guardarArea(area);
        return ResponseEntity.status(201).body(nuevaArea);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> obtenerAreaPorId(@PathVariable Long id) {
        Area area = areaService.obtenerAreaPorId(id);
        if (area == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(area);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> actualizarArea(@PathVariable Long id, @RequestBody Area area){
        try{
            Area areaExistente = areaService.obtenerAreaPorId(id);
            areaExistente.setNombre(area.getNombre());
            areaExistente.setDescripcion(area.getDescripcion());
            
            areaService.guardarArea(areaExistente);
            return ResponseEntity.ok(areaExistente);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarArea(@PathVariable Long id) {
    try {
        Area area = areaService.obtenerAreaPorId(id);
        if(area == null){
            return ResponseEntity.notFound().build();
        }
        areaService.eliminarArea(id);
        return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}

}
