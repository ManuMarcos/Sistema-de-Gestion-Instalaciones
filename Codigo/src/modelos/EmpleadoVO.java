package modelos;

public class EmpleadoVO {
	
	//Attributes
	private String nombre;
	private int id;
	
	
	//Methods
	public EmpleadoVO(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return this.nombre;
	}
}
