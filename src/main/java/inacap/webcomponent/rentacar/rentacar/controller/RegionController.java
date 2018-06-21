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
import inacap.webcomponent.rentacar.rentacar.model.RegionModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
    @GetMapping()
    public List<RegionModel> list() {
        RegionModel regiones =new RegionModel();
        
        return RegionModel.listaregion;
    }
    
    @GetMapping("/{id}")
    public RegionModel get(@PathVariable String id) {
        RegionModel regiones =new RegionModel();
        
        
        return regiones.buscaRegion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> editarRegion (@PathVariable String id, @RequestBody RegionModel regionEditar) {
     RegionModel regiones =new RegionModel();   
        
        return new ResponseEntity<>(regiones.editarRegion(Integer.parseInt(id),regionEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<RegionModel> agregarRegion(@RequestBody RegionModel nuevaRegion) {
        RegionModel regiones =new RegionModel();
        
        if (regiones.nuevaRegion(nuevaRegion)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<RegionModel> eliminarRegion(@PathVariable String id) {
        RegionModel regiones =new RegionModel();
        if (regiones.eliminarRegion(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
