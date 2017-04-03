/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cicte.espe.edu.ec.web;

import cicte.espe.edu.ec.modelo.Usuario;
import cicte.espe.edu.ec.servicios.UsuarioServicio;
import ec.edu.espe.sipro.web.utils.BaseBean;
import ec.edu.espe.sipro.web.utils.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.beanutils.BeanUtils;


/**
 *
 * @author esteb
 */
@Named
@ViewScoped
public class UsuariosAdmBean  extends BaseBean implements Serializable 
{
    private static final Logger LOG = Logger.getLogger(UsuariosAdmBean.class.getName());
    private List<Usuario> usuarios;
    private Usuario usuario;
    private Usuario usuarioSelected;
    private UsuarioServicio usuarioServicio=new UsuarioServicio();
    
    @PostConstruct
    public void postConstructor()
    {
        this.usuarios=this.usuarioServicio.ObtenerLista();
    }
    public void agregar()
    {
        super.startAdd();
        this.usuario=new Usuario();
        this.usuarios=this.usuarioServicio.ObtenerLista();
    }
    public void modificar()
    {
        super.setAdd(add); 
        this.usuario=new Usuario();
       try {
            BeanUtils.copyProperties(this.usuario, this.usuarioSelected);
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Error al copiar las propiedades.");
            LOG.log(Level.SEVERE, "Error al copiar propiedades: ", e);
        }
    }
    public void eliminar()
    {
        this.usuarioServicio.Delete(this.usuarioSelected);
        this.usuarios = this.usuarioServicio.ObtenerLista();
    }
    public void guardar()
    {
        if(super.isAdd())
        {
            this.usuarioServicio.Insert(usuario);
            FacesUtil.addMessageInfo("Se ha creado el usuario: "+usuario.getNombre());
        }
        else
        {
            this.usuarioServicio.UpdateNombre(usuario);
            FacesUtil.addMessageInfo("Se ha modificado el usuario: "+usuario.getNombre());
        }
        this.usuarios = this.usuarioServicio.ObtenerLista();
        super.reset();
        this.usuario = null;

    }
    public void cancelar()
    {
        super.reset();
        this.usuario=null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }
   
}
