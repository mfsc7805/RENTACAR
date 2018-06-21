/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.rentacar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.rentacar.rentacar.model.TraccionModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
    
    @GetMapping()
    public List<TraccionModel> list() {
        TraccionModel tracciones =new TraccionModel();
        
        return TraccionModel.listatraccion;
    }
    
    @GetMapping("/{id}")
    public TraccionModel get(@PathVariable String id) {
        TraccionModel tracciones =new TraccionModel();
        
        
        return tracciones.buscaTraccion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> editarTraccion (@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
     TraccionModel tracciones =new TraccionModel();   
        
        return new ResponseEntity<>(tracciones.editarTraccion(Integer.parseInt(id),traccionEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<TraccionModel> agregarTraccion(@RequestBody TraccionModel nuevaTraccion) {
        TraccionModel tracciones =new TraccionModel();
        
        if (tracciones.nuevaTraccion(nuevaTraccion)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TraccionModel> eliminarTraccion(@PathVariable String id) {
        TraccionModel tracciones =new TraccionModel();
        if (tracciones.eliminarTraccion(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
