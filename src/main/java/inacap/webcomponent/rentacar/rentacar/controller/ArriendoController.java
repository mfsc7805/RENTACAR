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
import inacap.webcomponent.rentacar.rentacar.model.ArriendoModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    
    @GetMapping()
    public List<ArriendoModel> list() {
        ArriendoModel arriendos =new ArriendoModel();
        
        return ArriendoModel.listaarriendo;
    }
    
    @GetMapping("/{id}")
    public ArriendoModel get(@PathVariable String id) {
        ArriendoModel arriendos =new ArriendoModel();
        
        
        return arriendos.buscaArriendo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ArriendoModel> editarArriendo (@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
     ArriendoModel arriendos =new ArriendoModel();   
        
        return new ResponseEntity<>(arriendos.editarArriendo(Integer.parseInt(id),arriendoEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ArriendoModel> agregarArriendo(@RequestBody ArriendoModel nuevaArriendo) {
        ArriendoModel arriendos =new ArriendoModel();
        
        if (arriendos.nuevaArriendo(nuevaArriendo)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ArriendoModel> eliminarArriendo(@PathVariable String id) {
        ArriendoModel arriendos =new ArriendoModel();
        if (arriendos.eliminarArriendo(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
