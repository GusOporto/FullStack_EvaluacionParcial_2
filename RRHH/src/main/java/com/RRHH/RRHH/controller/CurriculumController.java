package com.RRHH.RRHH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.DTO.CurriculumDTO;
import com.RRHH.RRHH.model.Curriculum;
import com.RRHH.RRHH.service.CurriculumService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/curriculum")// http://localhost:8080/api/v1/curriculum
public class CurriculumController {

    @Autowired//obligatorio para heredar curriculum service
    private CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<CurriculumDTO>> listar(){
        List<CurriculumDTO> curriculums = curriculumService.findAll();
        
        if(curriculums.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(curriculums, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Curriculum> guardar(@Valid @RequestBody Curriculum curriculum){
        try{
            Curriculum curriculumNuevo = curriculumService.save(curriculum);
            return new ResponseEntity<>(curriculumNuevo, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumDTO> buscarPorId(@PathVariable Long id){
        try{
            CurriculumDTO curriculum = curriculumService.findById(id);
            return new ResponseEntity<>(curriculum, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> actualizar (@Valid @PathVariable Long id, @RequestBody Curriculum curriculum){
        try{
            Curriculum  edicionCurriculum = curriculumService.updateCurriculum(id, curriculum);
            return new ResponseEntity<>(edicionCurriculum, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        String resultado = curriculumService.delete(id);
        if(resultado.contains("Exito")){
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Curriculum> editarCurriculum(@Valid @PathVariable Long id,@RequestBody Curriculum curriculum){
        try{
            Curriculum editado = curriculumService.updateCurriculum(id, curriculum);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
