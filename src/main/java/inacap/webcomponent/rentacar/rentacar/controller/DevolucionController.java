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
import inacap.webcomponent.rentacar.rentacar.model.DevolucionModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @GetMapping()
    public List<DevolucionModel> list() {
        DevolucionModel devolver =new DevolucionModel();
        
        return DevolucionModel.listadevolucion;
    }
    
    @GetMapping("/{id}")
    public DevolucionModel get(@PathVariable String id) {
        DevolucionModel devolver =new DevolucionModel();
        
        
        return devolver.buscaDevolucion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> editarDevolucion (@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
     DevolucionModel devolver =new DevolucionModel();   
        
        return new ResponseEntity<>(devolver.editarDevolucion(Integer.parseInt(id),devolucionEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<DevolucionModel> agregarDevolucion(@RequestBody DevolucionModel nuevaDevolucion) {
        DevolucionModel devolver =new DevolucionModel();
        
        if (devolver.nuevaDevolucion(nuevaDevolucion)){
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<DevolucionModel> eliminarDevolucion(@PathVariable String id) {
        DevolucionModel devolver =new DevolucionModel();
        if (devolver.eliminarDevolucion(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       
    
}
    }
}
