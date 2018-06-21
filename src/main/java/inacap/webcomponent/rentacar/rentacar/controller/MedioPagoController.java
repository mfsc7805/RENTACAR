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
import inacap.webcomponent.rentacar.rentacar.model.MedioPagoModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/mediopago")
public class MedioPagoController {
    
    @GetMapping()
    public List<MedioPagoModel> list() {
        MedioPagoModel mediopagos =new MedioPagoModel();
        
        return MedioPagoModel.listamediopago;
    }
    
    @GetMapping("/{id}")
    public MedioPagoModel get(@PathVariable String id) {
        MedioPagoModel mediopagos =new MedioPagoModel();
        
        
        return mediopagos.buscaMedioPago(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> editarMedioPago (@PathVariable String id, @RequestBody MedioPagoModel mediopagoEditar) {
     MedioPagoModel mediopagos =new MedioPagoModel();   
        
        return new ResponseEntity<>(mediopagos.editarMedioPago(Integer.parseInt(id),mediopagoEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<MedioPagoModel> agregarMedioPago(@RequestBody MedioPagoModel nuevaMedioPago) {
        MedioPagoModel mediopagos =new MedioPagoModel();
        
        if (mediopagos.nuevaMedioPago(nuevaMedioPago)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<MedioPagoModel> eliminarMedioPago(@PathVariable String id) {
        MedioPagoModel mediopagos =new MedioPagoModel();
        if (mediopagos.eliminarMedioPago(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
