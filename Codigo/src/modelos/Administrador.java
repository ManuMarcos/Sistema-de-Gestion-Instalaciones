package modelos;

public class Administrador extends Empleado{

	//Attributes
	
	//Methods
	
	public Administrador(String nombre, String direccion,String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		
	}
	
	
	
	
	public void crearTecnico() {};
	public void crearProducto() {};
	public void setCostoHoraTrabajo(Tecnico tecnico, float costoHora) {};
	public void setStockProducto(Producto producto, int cantStock){};
	public void setPrecioProducto(Producto producto, float precio) {};
	public void setCostoViaje(float costo) {};
	
}
