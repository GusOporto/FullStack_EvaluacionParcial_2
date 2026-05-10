package com.RRHH.RRHH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.model.TipoContrato;
import com.RRHH.RRHH.service.TipoContratoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/tipos-contrato")
public class TipoContratoController {

    @Autowired
    private TipoContratoService tipoContratoService;

    @GetMapping
    public ResponseEntity<List<TipoContrato>> obtenerTiposContrato() {
        return ResponseEntity.ok(tipoContratoService.obtenerTipoContrato());
    }

    @PostMapping
    public ResponseEntity<TipoContrato> guardarTipoContrato(@RequestBody TipoContrato tipoContrato) {
        TipoContrato nuevoTipoContrato = tipoContratoService.guardarTipoContrato(tipoContrato);
        return ResponseEntity.status(201).body(nuevoTipoContrato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContrato> obtenerTipoContratoPorId(@PathVariable Long id) {
        TipoContrato tipoContrato = tipoContratoService.obtenerTipoContratoPorId(id);
        if (tipoContrato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoContrato);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoContrato> actualizarTipoContrato(@PathVariable Long id,@RequestBody TipoContrato tipoContrato) {
        try {
            TipoContrato tipoExistente = tipoContratoService.obtenerTipoContratoPorId(id);
            tipoExistente.setNombre(tipoContrato.getNombre());
            tipoExistente.setDescripcion(tipoContrato.getDescripcion());
            tipoExistente.setModalidad(tipoContrato.getModalidad());
            tipoExistente.setJornada(tipoContrato.getJornada());
            tipoExistente.setFechaCreacion(tipoContrato.getFechaCreacion());

            tipoContratoService.guardarTipoContrato(tipoExistente);
            return ResponseEntity.ok(tipoExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoContrato(@PathVariable Long id) {
        TipoContrato tipoContrato = tipoContratoService.obtenerTipoContratoPorId(id);
        if (tipoContrato == null) {
            return ResponseEntity.notFound().build();
        }
        tipoContratoService.eliminarTipoContrato(id);
        return ResponseEntity.noContent().build();
    }



}
