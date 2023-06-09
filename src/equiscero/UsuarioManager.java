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
    Usuario usuarios[] = new Usuario[1];

    public UsuarioManager() {
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
        
        // Actualizar el array
        int newSize = usuarios.length + 1;
        Usuario nuevosUsuarios[] = new Usuario[newSize];
        
        // Llenar antigui array con nuevos usuario
        for (int i =0; i<usuarios.length;i++) {
            nuevosUsuarios[i] = usuarios[i];
        }
        
        // Agregar el usuario recien creado
        nuevosUsuarios[newSize - 1] = user;
        return true;
    }
}
