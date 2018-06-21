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
import inacap.webcomponent.rentacar.rentacar.model.TipoPersonaModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    
    @GetMapping()
    public List<TipoPersonaModel> list() {
        TipoPersonaModel tipopersonas =new TipoPersonaModel();
        
        return TipoPersonaModel.listatipopersona;
    }
    
    @GetMapping("/{id}")
    public TipoPersonaModel get(@PathVariable String id) {
        TipoPersonaModel tipopersonas =new TipoPersonaModel();
        
        
        return tipopersonas.buscaTipoPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> editarTipoPersona (@PathVariable String id, @RequestBody TipoPersonaModel tipopersonaEditar) {
     TipoPersonaModel tipopersonas =new TipoPersonaModel();   
        
        return new ResponseEntity<>(tipopersonas.editarTipoPersona(Integer.parseInt(id),tipopersonaEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<TipoPersonaModel> agregarTipoPersona(@RequestBody TipoPersonaModel nuevaTipoPersona) {
        TipoPersonaModel tipopersonas =new TipoPersonaModel();
        
        if (tipopersonas.nuevaTipoPersona(nuevaTipoPersona)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> eliminarTipoPersona(@PathVariable String id) {
        TipoPersonaModel tipopersonas =new TipoPersonaModel();
        if (tipopersonas.eliminarTipoPersona(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
