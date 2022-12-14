package com.example.regisbackendseguridad.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.regisbackendseguridad.Models.PermisosRol;
import com.example.regisbackendseguridad.Models.Permiso;
import com.example.regisbackendseguridad.Models.Rol;
import com.example.regisbackendseguridad.Repositories.RepositoryPermisosRol;
import com.example.regisbackendseguridad.Repositories.RepositoryPermiso;
import com.example.regisbackendseguridad.Repositories.RepositoryRol;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-roles")
public class ControllerPermisosRol {
    @Autowired
    private RepositoryPermisosRol miRepositorioPermisoRoles;

    @Autowired
    private RepositoryPermiso miRepositorioPermiso;

    @Autowired
    private RepositoryRol miRepositorioRol;


    @GetMapping("")
    public List<PermisosRol> index(){
        return this.miRepositorioPermisoRoles.findAll();
    }

    /**
     * Asignación rol y permiso
     * @param id_rol
     * @param id_permiso
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")
    public PermisosRol create(@PathVariable String id_rol,@PathVariable String id_permiso){
        PermisosRol nuevo=new PermisosRol();
        Rol elRol=this.miRepositorioRol.findById(id_rol).get();
        Permiso elPermiso=this.miRepositorioPermiso.findById(id_permiso).get();
        if (elRol!=null && elPermiso!=null){
            nuevo.setPermiso(elPermiso);
            nuevo.setRol(elRol);
            return this.miRepositorioPermisoRoles.save(nuevo);
        }else{
            return null;
        }
    }
    @GetMapping("{id}")
    public PermisosRol show(@PathVariable String id){
        PermisosRol permisosRolesActual=this.miRepositorioPermisoRoles
                .findById(id)
                .orElse(null);
        return permisosRolesActual;
    }

    /**
     * Modificación Rol y Permiso
     * @param id
     * @param id_rol
     * @param id_permiso
     * @return
     */
    @PutMapping("{id}/rol/{id_rol}/permiso/{id_permiso}")
    public PermisosRol update(@PathVariable String id,@PathVariable String id_rol,@PathVariable String id_permiso){
        PermisosRol permisosRolesActual=this.miRepositorioPermisoRoles
                .findById(id)
                .orElse(null);
        Rol elRol=this.miRepositorioRol.findById(id_rol).get();
        Permiso elPermiso=this.miRepositorioPermiso.findById(id_permiso).get();
        if(permisosRolesActual!=null && elPermiso!=null && elRol!=null){
            permisosRolesActual.setPermiso(elPermiso);
            permisosRolesActual.setRol(elRol);
            return this.miRepositorioPermisoRoles.save(permisosRolesActual);
        }else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        PermisosRol permisosRolesActual=this.miRepositorioPermisoRoles
                .findById(id)
                .orElse(null);
        if (permisosRolesActual!=null){
            this.miRepositorioPermisoRoles.delete(permisosRolesActual);
        }
    }

    @GetMapping("validar-permiso/rol/{id_rol}")
    public PermisosRol getPermiso(@PathVariable String id_rol,
                                    @RequestBody Permiso infoPermiso){
        Permiso elPermiso=this.miRepositorioPermiso
                .getPermiso(infoPermiso.getUrl(),
                        infoPermiso.getMetodo());
        Rol elRol=this.miRepositorioRol.findById(id_rol).get();
        if (elPermiso!=null && elRol!=null){
            return this.miRepositorioPermisoRoles.getPermisoRol(elRol.get_Id(),
                                                                elPermiso.get_Id());
        }else{
            return null;
        }
    }
}





