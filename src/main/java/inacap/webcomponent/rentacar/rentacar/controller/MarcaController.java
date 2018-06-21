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
import inacap.webcomponent.rentacar.rentacar.model.MarcaModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @GetMapping()
    public List<MarcaModel> list() {
        MarcaModel marcas =new MarcaModel();
        
        return MarcaModel.listamarca;
    }
    
    @GetMapping("/{id}")
    public MarcaModel get(@PathVariable String id) {
        MarcaModel marcas =new MarcaModel();
        
        
        return marcas.buscaMarca(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> editarMarca (@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
     MarcaModel marcas =new MarcaModel();   
        
        return new ResponseEntity<>(marcas.editarMarca(Integer.parseInt(id),marcaEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<MarcaModel> agregarMarca(@RequestBody MarcaModel nuevaMarca) {
        MarcaModel marcas =new MarcaModel();
        
        if (marcas.nuevaMarca(nuevaMarca)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<MarcaModel> eliminarMarca(@PathVariable String id) {
        MarcaModel marcas =new MarcaModel();
        if (marcas.eliminarMarca(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
