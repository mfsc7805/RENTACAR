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
import inacap.webcomponent.rentacar.rentacar.model.PersonaModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @GetMapping()
    public List<PersonaModel> list() {
        PersonaModel personas =new PersonaModel();
        
        return PersonaModel.listapersona;
    }
    
    @GetMapping("/{id}")
    public PersonaModel get(@PathVariable String id) {
        PersonaModel personas =new PersonaModel();
        
        
        return personas.buscaPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> editarPersona (@PathVariable String id, @RequestBody PersonaModel personaEditar) {
     PersonaModel personas =new PersonaModel();   
        
        return new ResponseEntity<>(personas.editarPersona(Integer.parseInt(id),personaEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<PersonaModel> agregarPersona(@RequestBody PersonaModel nuevaPersona) {
        PersonaModel personas =new PersonaModel();
        
        if (personas.nuevaPersona(nuevaPersona)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaModel> eliminarPersona(@PathVariable String id) {
        PersonaModel personas =new PersonaModel();
        if (personas.eliminarPersona(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
