package com.RRHH.RRHH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RRHH.RRHH.DTO.TipoContratoDTO;
import com.RRHH.RRHH.model.TipoContrato;
import com.RRHH.RRHH.service.TipoContratoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/tipos-contrato")
public class TipoContratoController {

    @Autowired
    private TipoContratoService tipoContratoService;

    @GetMapping
    public ResponseEntity<List<TipoContratoDTO>> obtenerTipoContrato() {
        List<TipoContratoDTO> tipos = tipoContratoService.obtenerTipoContrato();
        if(tipos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContratoDTO> buscarPorId(@PathVariable Long id) {
        try{
            TipoContratoDTO tipo = tipoContratoService.bucarPorId(id);
            return new ResponseEntity<>(tipo,HttpStatus.OK);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoContratoDTO> agregarTipoContrato(@RequestBody TipoContrato tipoContrato) {
        try {
            TipoContratoDTO guardado = tipoContratoService.guardarTipoContrato(tipoContrato);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoContratoDTO> actualizarTipoContrato(@PathVariable Long id,@RequestBody TipoContrato tipoContrato) {
        try {
            TipoContratoDTO actualizado = tipoContratoService.actualizarTipoContrato(id, tipoContrato);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoContrato(@PathVariable Long id) {
        String resultado = tipoContratoService.eliminar(id);
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
        
    
  