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

import jakarta.validation.Valid;

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
    public ResponseEntity<ColaboradorDTO> agregar(@Valid @RequestBody Colaborador colab) {
        try {
            ColaboradorDTO guardadoDTO = colaboradorService.save(colab);
            return new ResponseEntity<>(guardadoDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> editarColaborador(@Valid @PathVariable Long id,
            @RequestBody Colaborador colab) {
        try {
            colab.setId(id);
            ColaboradorDTO editadoDTO = colaboradorService.save(colab);
            return new ResponseEntity<>(editadoDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> actualizar(@Valid @PathVariable Long id, @RequestBody Colaborador colab) {
        try {
            ColaboradorDTO actualizadoDTO = colaboradorService.updateColaborador(id, colab);
            return new ResponseEntity<>(actualizadoDTO, HttpStatus.OK);
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
