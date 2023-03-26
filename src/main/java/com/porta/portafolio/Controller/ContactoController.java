
package com.porta.portafolio.Controller;

import com.porta.portafolio.Entity.Contacto;
import com.porta.portafolio.Interface.IContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contactos")
@CrossOrigin(origins="https://portafolio-c03a3.web.app")
public class ContactoController {
    @Autowired
    IContactoService icontactoService;
    
    @GetMapping("/traer")
    public List<Contacto>getContacto(){
     return icontactoService.getContacto();   
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public void createContacto(@RequestBody Contacto contacto){
        icontactoService.saveContacto(contacto);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void deleteContacto (@PathVariable Integer id){
        icontactoService.deleteContacto(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Contacto editContacto(@PathVariable ("id") Integer id,
                              @RequestBody Contacto contacto)
    {
        
        contacto.setId(id);
    
    icontactoService.saveContacto(contacto);
    return contacto;
    }
    
    @GetMapping(path = {"/{id}"})
    public Contacto findContacto(@PathVariable ("id") int id){
        return icontactoService.findContacto(id);
    }
    
}
