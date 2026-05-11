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

import com.RRHH.RRHH.DTO.CargosDTO;
import com.RRHH.RRHH.model.Cargos;
import com.RRHH.RRHH.service.CargosService;

@RestController
@RequestMapping("api/v1/cargos")// http://localhost:8080/api/v1/cargos
public class CargosController {

    @Autowired//obligatorio para heredar cargos service
    private CargosService cargosService;

    @GetMapping
    public ResponseEntity<List<CargosDTO>> listar(){
        List<CargosDTO> cargos = cargosService.findAll();
        
        if(cargos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Cargos> guardar(@RequestBody Cargos cargos){
        try{
            Cargos cargoNuevo = cargosService.save(cargos);
            return new ResponseEntity<>(cargoNuevo, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargosDTO> buscarPorId(@PathVariable Long id){
        try{
            CargosDTO cargos = cargosService.findById(id);
            return new ResponseEntity<>(cargos, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargos> actualizar (@PathVariable Long id, @RequestBody Cargos cargo){
        try{
            Cargos edicionCargo = cargosService.updateCargos(id, cargo);
            return new ResponseEntity<>(edicionCargo, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        String resultado = cargosService.delete(id);
        if(resultado.contains("Exito")){ //tiene que ser tal cual el delete de service
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cargos> editarCargo(@PathVariable Long id,@RequestBody Cargos cargo){
        try{
            Cargos editado = cargosService.updateCargos(id,cargo);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
