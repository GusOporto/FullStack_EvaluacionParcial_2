package com.RRHH.RRHH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.DTO.TituloDTO;
import com.RRHH.RRHH.model.Titulo;
import com.RRHH.RRHH.service.TituloService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/titulo")// http://localhost:8080/api/v1/titulo
@Slf4j
public class TituloController {

    @Autowired//obligatorio para heredar titulo service
    private TituloService tituloService;

    @GetMapping
    public ResponseEntity<List<TituloDTO>> listar(){
        List<TituloDTO> titulos = tituloService.findAll();
        
        if(titulos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(titulos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Titulo> guardar(@Valid @RequestBody Titulo titulo){
        try{
            Titulo TituloNuevo = tituloService.save(titulo);
            return new ResponseEntity<>(TituloNuevo, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TituloDTO> buscarPorId(@PathVariable Long id){
        try{
            TituloDTO titulo = tituloService.findById(id);
            return new ResponseEntity<>(titulo, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Titulo> actualiazr (@Valid @PathVariable Long id, @RequestBody Titulo titulo){
        try{
            Titulo  edicionTitulo = tituloService.updateTitulo(id, titulo);
            return new ResponseEntity<>(edicionTitulo, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        String resultado = tituloService.delete(id);
        if(resultado.contains("Exito")){
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Titulo> editarEvaluaciones(@Valid @PathVariable Long id,@RequestBody Titulo titulo){
        try{
            Titulo editado = tituloService.updateTitulo(id, titulo);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
