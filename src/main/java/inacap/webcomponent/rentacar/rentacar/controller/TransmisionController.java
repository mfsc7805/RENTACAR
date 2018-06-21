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
import inacap.webcomponent.rentacar.rentacar.model.TransmisionModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @GetMapping()
    public List<TransmisionModel> list() {
        TransmisionModel transmisiones =new TransmisionModel();
        
        return TransmisionModel.listatransmision;
    }
    
    @GetMapping("/{id}")
    public TransmisionModel get(@PathVariable String id) {
        TransmisionModel transmisiones =new TransmisionModel();
        
        
        return transmisiones.buscaTransmision(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> editarTransmision (@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
     TransmisionModel transmisiones =new TransmisionModel();   
        
        return new ResponseEntity<>(transmisiones.editarTransmision(Integer.parseInt(id),transmisionEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<TransmisionModel> agregarTransmision(@RequestBody TransmisionModel nuevaTransmision) {
        TransmisionModel transmisiones =new TransmisionModel();
        
        if (transmisiones.nuevaTransmision(nuevaTransmision)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TransmisionModel> eliminarTransmision(@PathVariable String id) {
        TransmisionModel transmisiones =new TransmisionModel();
        if (transmisiones.eliminarTransmision(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
