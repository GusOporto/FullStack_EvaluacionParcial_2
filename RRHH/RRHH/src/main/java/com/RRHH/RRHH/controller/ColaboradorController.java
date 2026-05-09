package com.RRHH.RRHH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.DTO.ColaboradorDTO;
import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.service.ColaboradorService;

@RestController
@RequestMapping("api/v1/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listar() {
        List<ColaboradorDTO> colaboradores = colaboradorService.findAll();
        if (colaboradores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> buscarPorId(@PathVariable Long id) {
        try {
            ColaboradorDTO colaborador = colaboradorService.findById(id);
            return new ResponseEntity<>(colaborador, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/run/{run}")
    public ResponseEntity<List<ColaboradorDTO>> buscarPorRun(@PathVariable String run) {
        List<ColaboradorDTO> colaboradores = colaboradorService.findByRun(run);
        if (colaboradores.isEmpty()) {
            return new ResponseEntity<>(colaboradores, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<ColaboradorDTO>> buscarPorSucursal(@PathVariable Long id) {
        List<ColaboradorDTO> colaboradores = colaboradorService.findBySucursales(id);
        if (colaboradores.isEmpty()) {
            return new ResponseEntity<>(colaboradores, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<List<ColaboradorDTO>> buscarPorRegion(@PathVariable Long id) {
        List<ColaboradorDTO> colaboradores = colaboradorService.findByRegion(id);
        if (colaboradores.isEmpty()) {
            return new ResponseEntity<>(colaboradores, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/comuna/{id}")
    public ResponseEntity<List<ColaboradorDTO>> buscarPorComuna(@PathVariable Long id) {
        List<ColaboradorDTO> colaboradores = colaboradorService.findByComuna(id);
        if (colaboradores.isEmpty()) {
            return new ResponseEntity<>(colaboradores, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Colaborador> agregar(@RequestBody Colaborador colab) {
        try {
            Colaborador guardado = colaboradorService.save(colab);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Colaborador> editarColaborador(@PathVariable Long id, @RequestBody Colaborador colab) {
        try {
            Colaborador editado = colaboradorService.save(colab);
            return new ResponseEntity<>(editado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> actualizar(@PathVariable Long id, @RequestBody Colaborador colab) {
        try {
            Colaborador newColab = colaboradorService.updateColaborador(id, colab);
            return new ResponseEntity<>(newColab, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        String resultado = colaboradorService.delete(id);
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
