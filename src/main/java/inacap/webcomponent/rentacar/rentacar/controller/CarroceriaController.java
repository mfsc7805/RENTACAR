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
import inacap.webcomponent.rentacar.rentacar.model.CarroceriaModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
    
    @GetMapping()
    public List<CarroceriaModel> list() {
        CarroceriaModel carro =new CarroceriaModel();
        
        return CarroceriaModel.listacarroceria;
    }
    
    @GetMapping("/{id}")
    public CarroceriaModel get(@PathVariable String id) {
        CarroceriaModel carro =new CarroceriaModel();
        
        
        return carro.buscaCarroceria(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> editarCarroceria (@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
     CarroceriaModel carro =new CarroceriaModel();   
        
        return new ResponseEntity<>(carro.editarCarroceria(Integer.parseInt(id),carroceriaEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<CarroceriaModel> agregarCarroceria(@RequestBody CarroceriaModel nuevaCarroceria) {
        CarroceriaModel carro =new CarroceriaModel();
        
        if (carro.nuevaCarroceria(nuevaCarroceria)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CarroceriaModel> eliminarCarroceria(@PathVariable String id) {
        CarroceriaModel carro =new CarroceriaModel();
        if (carro.eliminarCarroceria(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
