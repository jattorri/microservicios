package com.microservicios.commons.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.microservicios.commons.services.CommonService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;


public class CommonController<E, S extends CommonService<E>> {
	
    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<E> o = service.findById(id);
        if(o.isPresent()){   return ResponseEntity.ok(o.get());}
        else {
           return ResponseEntity.notFound().build(); 
        }
     
    }
    
    @PostMapping
    public ResponseEntity<?> crear (@Valid @RequestBody E entity, BindingResult result){
    	if(result.hasErrors()) {
    		return this.validar(result);
    	}
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    protected ResponseEntity<?> validar(BindingResult result){
    	Map<String, Object> errores = new HashMap<>();
    	result.getFieldErrors().forEach(err -> {
    		errores.put(err.getField(), "El campo" + err.getDefaultMessage() + " " + err.getDefaultMessage());
    	});
    	return ResponseEntity.badRequest().body(errores);
    	
    }
}
