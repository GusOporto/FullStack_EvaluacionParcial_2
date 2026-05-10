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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.DTO.EvaluacionesDTO;
import com.RRHH.RRHH.model.Evaluaciones;
import com.RRHH.RRHH.service.EvaluacionesService;

@RestController
@RequestMapping("api/v1/evaluaciones")// http://localhost:8080/api/v1/evaluaciones
public class EvaluacionesController {

    @Autowired//obligatorio para heredar evaluaciones service
    private EvaluacionesService evaluacionesService;

    @GetMapping
    public ResponseEntity<List<EvaluacionesDTO>> listar(){
        List<EvaluacionesDTO> evaluaciones = evaluacionesService.findAll();
        
        if(evaluaciones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Evaluaciones> guardar(@RequestBody Evaluaciones evaluaciones){
        try{
            Evaluaciones evaluacionNueva = evaluacionesService.save(evaluaciones);
            return new ResponseEntity<>(evaluacionNueva, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionesDTO> buscarPorId(@PathVariable Long id){
        try{
            EvaluacionesDTO evaluaciones = evaluacionesService.findById(id);
            return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluaciones> actualizar (@PathVariable Long id, @RequestBody Evaluaciones evaluaciones){
        try{
            Evaluaciones  edicionEvaluaciones = evaluacionesService.updateEvaluaciones(id, evaluaciones);
            return new ResponseEntity<>(edicionEvaluaciones, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        String resultado = evaluacionesService.delete(id);
        if(resultado.contains("Exito")){
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Evaluaciones> editarEvaluaciones(@PathVariable Long id,@RequestBody Evaluaciones evaluaciones){
        try{
            Evaluaciones editado = evaluacionesService.updateEvaluaciones(id, evaluaciones);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
