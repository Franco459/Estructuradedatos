package TP4;

public class UsuarioDeServicio implements Comparable {
    String nombre;
    String apellido;
    String usuario;
    String clave;
    String correo;
    String tipo_de_cuenta;

    public UsuarioDeServicio(String nombre, String apellido, String usuario, String clave, String correo,
            String tipo_de_cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
        this.tipo_de_cuenta = tipo_de_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTipo_de_cuenta() {
        return tipo_de_cuenta;
    }

    public void setTipo_de_cuenta(String tipo_de_cuenta) {
        this.tipo_de_cuenta = tipo_de_cuenta;
    }

    
    @Override
    public String toString() {
        return "[Nombre=" + nombre + ", Apellido=" + apellido + ", Usuario=" + usuario + ", Clave="
                + clave + ", Correo=" + correo + ", Tipo de cuenta=" + tipo_de_cuenta + "]\n";
    }
    
    @Override
    public int compareTo(Object obj) {
        UsuarioDeServicio user = (UsuarioDeServicio) obj;
        return (this.getNombre() + this.getApellido()).compareTo(user.getNombre()+ user.getApellido());
    }
}
