/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equiscero;

/**
 *
 * @author Jorge Hernandez
 */
public class UsuarioManager {
    private Usuario usuarios[] = new Usuario[1];
    private int usuariosActivos = 0;
    Usuario loggedUser;

    public UsuarioManager() {
    }

    public int getUsuariosActivos() {
        return usuariosActivos;
    }
    
    
    public Usuario buscarUsuario(String username) {
        for(Usuario user:usuarios) {
            if (user == null) continue;
            if (user.getUsername().equals(username)) return user;
        }
        
        return null;
    }
    
    public boolean registrar(String username, String password) {
        // Verificar que el usuario no exista
        
        if (buscarUsuario(username) != null) {
            return false;
        }
        
        Usuario user = new Usuario(username, password);
        
        // Es el primer usuario en registrar
        if (usuariosActivos == 0) {
            usuarios[0] = user;
            usuariosActivos++;
            return true;
        }
        
        // Actualizar el array
        int newSize = usuarios.length + 1;
        Usuario nuevosUsuarios[] = new Usuario[newSize];
        
        // Llenar antigui array con nuevos usuario
        for (int i =0; i<usuarios.length;i++) {
            nuevosUsuarios[i] = usuarios[i];
        }
        
        // Agregar el usuario recien creado
        nuevosUsuarios[newSize - 1] = user;
        usuarios = nuevosUsuarios;
        usuariosActivos++;
        return true;
    }
    
    public Usuario login(String username, String password) {
        for(Usuario user:usuarios) {
            if (user == null) continue;
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedUser = user;
                return user;
            }
        }
        
        return null;
    }
    
    public String[] getAllUsernames() {
        String usernames[] = new String[usuarios.length];
        
        for(int i =0;i<usuarios.length;i++){
            usernames[i] = usuarios[i].getUsername();
        }
        
        return usernames;
    }
    
    public void logout() {
        loggedUser = null;
    }
}
