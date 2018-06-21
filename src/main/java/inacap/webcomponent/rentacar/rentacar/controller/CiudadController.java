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
import inacap.webcomponent.rentacar.rentacar.model.CiudadModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
    @GetMapping()
    public List<CiudadModel> list() {
        CiudadModel city =new CiudadModel();
        
        return CiudadModel.listaciudad;
    }
    
    @GetMapping("/{id}")
    public CiudadModel get(@PathVariable String id) {
        CiudadModel city =new CiudadModel();
        
        
        return city.buscaCiudad(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> editarCiudad (@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {
     CiudadModel city =new CiudadModel();   
        
        return new ResponseEntity<>(city.editarCiudad(Integer.parseInt(id),ciudadEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<CiudadModel> agregarCiudad(@RequestBody CiudadModel nuevaCiudad) {
        CiudadModel city =new CiudadModel();
        
        if (city.nuevaCiudad(nuevaCiudad)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CiudadModel> eliminarCiudad(@PathVariable String id) {
        CiudadModel city =new CiudadModel();
        if (city.eliminarCiudad(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
