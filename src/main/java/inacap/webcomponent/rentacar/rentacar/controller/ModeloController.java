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
import inacap.webcomponent.rentacar.rentacar.model.ModeloModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
    @GetMapping()
    public List<ModeloModel> list() {
        ModeloModel modelos =new ModeloModel();
        
        return ModeloModel.listamodelo;
    }
    
    @GetMapping("/{id}")
    public ModeloModel get(@PathVariable String id) {
        ModeloModel modelos =new ModeloModel();
        
        
        return modelos.buscaModelo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> editarModelo (@PathVariable String id, @RequestBody ModeloModel modeloEditar) {
     ModeloModel modelos =new ModeloModel();   
        
        return new ResponseEntity<>(modelos.editarModelo(Integer.parseInt(id),modeloEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ModeloModel> agregarModelo(@RequestBody ModeloModel nuevaModelo) {
        ModeloModel modelos =new ModeloModel();
        
        if (modelos.nuevaModelo(nuevaModelo)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ModeloModel> eliminarModelo(@PathVariable String id) {
        ModeloModel modelos =new ModeloModel();
        if (modelos.eliminarModelo(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
