package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Instalacion {

	//Attributes
	private static int generador = 1000;
	private int id;
	private Estado estado;
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private ArrayList<Producto> elementos;
	private Tecnico tecnico;
	private Cliente cliente;
	private Factura factura;
	private Calendar tiempoTrabajado;
	private boolean necesitaSeguro;
	private boolean necesitaSoportePared;
	private boolean almuerzo;
	private float costoDeViaje;
	
	
	//Methods
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Calendar getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}


	public Calendar getHoraFinalizacion() {
		return horaFinalizacion;
	}


	public void setHoraFinalizacion(Calendar horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}


	public ArrayList<Producto> getElementos() {
		return elementos;
	}


	public void agregarElementos(Producto producto) {
		this.elementos.add(producto);
	}


	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	public Calendar getTiempoTrabajado() {
		return tiempoTrabajado;
	}


	public void setTiempoTrabajado(Calendar tiempoTrabajado) {
		this.tiempoTrabajado = tiempoTrabajado;
	}


	public boolean isNecesitaSeguro() {
		return necesitaSeguro;
	}


	public void setNecesitaSeguro(boolean necesitaSeguro) {
		this.necesitaSeguro = necesitaSeguro;
	}


	public boolean isNecesitaSoportePared() {
		return necesitaSoportePared;
	}


	public void setNecesitaSoportePared(boolean necesitaSoportePared) {
		this.necesitaSoportePared = necesitaSoportePared;
	}


	public boolean isAlmuerzo() {
		return almuerzo;
	}


	public void setAlmuerzo(boolean almuerzo) {
		this.almuerzo = almuerzo;
	}


	public float getCostoDeViaje() {
		return costoDeViaje;
	}


	public void setCostoDeViaje(float costoDeViaje) {
		this.costoDeViaje = costoDeViaje;
	}
	
	//Constructor
	public Instalacion(Cliente cliente, Tecnico tecnico, boolean necesitaSoportePared, boolean necesitaSeguro) {
		//Acá tiene que haber dos validaciones: disponibilidad de técnico y existencia de cliente.
		this.setCliente(cliente);
		this.setTecnico(tecnico);
		this.setEstado(Estado.PROGRAMADA);
		this.setNecesitaSeguro(necesitaSeguro);
		this.setNecesitaSoportePared(necesitaSoportePared);
	}

	//Tiene que existir un constructor que no contemple si el usuario necesita soporte o seguro para que esto lo pueda definir a posteriori el tecnico
	public Instalacion(Cliente cliente, Tecnico tecnico) {
		//Acá tiene que haber dos validaciones: disponibilidad de técnico y existencia de cliente.
		this.setCliente(cliente);
		this.setTecnico(tecnico);
		this.setEstado(Estado.PROGRAMADA);
	}


	
}