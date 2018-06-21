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
import inacap.webcomponent.rentacar.rentacar.model.TipoVehiculoModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/tipovehiculo")
public class TipoVehiculoController {
    
    @GetMapping()
    public List<TipoVehiculoModel> list() {
        TipoVehiculoModel tipovehiculos =new TipoVehiculoModel();
        
        return TipoVehiculoModel.listatipovehiculo;
    }
    
    @GetMapping("/{id}")
    public TipoVehiculoModel get(@PathVariable String id) {
        TipoVehiculoModel tipovehiculos =new TipoVehiculoModel();
        
        
        return tipovehiculos.buscaTipoVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> editarTipoVehiculo (@PathVariable String id, @RequestBody TipoVehiculoModel tipovehiculoEditar) {
     TipoVehiculoModel tipovehiculos =new TipoVehiculoModel();   
        
        return new ResponseEntity<>(tipovehiculos.editarTipoVehiculo(Integer.parseInt(id),tipovehiculoEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<TipoVehiculoModel> agregarTipoVehiculo(@RequestBody TipoVehiculoModel nuevaTipoVehiculo) {
        TipoVehiculoModel tipovehiculos =new TipoVehiculoModel();
        
        if (tipovehiculos.nuevaTipoVehiculo(nuevaTipoVehiculo)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> eliminarTipoVehiculo(@PathVariable String id) {
        TipoVehiculoModel tipovehiculos =new TipoVehiculoModel();
        if (tipovehiculos.eliminarTipoVehiculo(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
