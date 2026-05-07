package com.RRHH.RRHH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.service.ColaboradorService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> listar(){
        List<Colaborador> colaboradores = colaboradorService.findAll();
        if(colaboradores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(colaboradores);
    }

    @PostMapping
    public ResponseEntity<Colaborador> guardar(@RequestBody Colaborador colaborador){
        Colaborador newColaborador = colaboradorService.save(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(newColaborador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscar(@PathVariable Integer id){
        try{
            Colaborador colaborador = colaboradorService.findById(id);
            return ResponseEntity.ok(colaborador);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> actualizar(@PathVariable Integer id, @RequestBody Colaborador colaborador){
        try{
            Colaborador col = colaboradorService.findById(id);
            col.setRun(colaborador.getRun());
            col.setNombres(colaborador.getNombres());
            col.setApellidos(colaborador.getApellidos());
            col.setFechaNacimiento(colaborador.getFechaNacimiento());
            col.setTelefono(colaborador.getTelefono());
            col.setCorreo(colaborador.getCorreo());
            col.setDireccion(colaborador.getDireccion());

            colaboradorService.save(col);
            return ResponseEntity.ok(colaborador);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            colaboradorService.delete(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    

}
