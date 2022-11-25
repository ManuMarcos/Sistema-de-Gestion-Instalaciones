package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import modelos.Empleado;
import modelos.Empresa;
import modelos.Junior;
import modelos.SemiSenior;
import modelos.Senior;
import modelos.TecnicoView;
import modelos.TurnoCompleto;
import modelos.TurnoManana;
import modelos.TurnoTarde;
import vistas.PanelAbmTecnicos;

public class ControladorAbmTecnicos implements MouseListener, ActionListener{

	//Attributes
	private PanelAbmTecnicos vista;
	private Empresa modelo;
	
	//Methods
	public ControladorAbmTecnicos() {
		this.vista = new PanelAbmTecnicos();
		this.modelo = Empresa.getInstance();
		this.cargarListadoTecnicos();
		this.setComboExpLaboral();
		this.setComboTurnoLaboral();
		this.vista.setMouseListener(this);
		this.vista.setActionListener(this);
	}
	
	private void cargarListadoTecnicos() {
		DefaultTableModel modeloTablaTecnicos = new DefaultTableModel();
		
		String[] columnas = {"Id","Nombre","Direccion","Turno", "Experiencia Laboral","Usuario","Contraseña"};
		modeloTablaTecnicos.setColumnIdentifiers(columnas);
		
		ArrayList<TecnicoView> tecnicos = this.modelo.getTecnicosView();
		for (TecnicoView tecnicoView : tecnicos) {
			modeloTablaTecnicos.addRow(new Object[] {tecnicoView.getId(), tecnicoView.getNombre(), tecnicoView.getDireccion(), tecnicoView.getTurnoLaboral(),
					tecnicoView.getExperienciaLaboral(),tecnicoView.getUsuario(), tecnicoView.getContrasena()});
		}
		this.vista.setListadoTecnicos(modeloTablaTecnicos);	
	}
	
	private void setComboExpLaboral() {
		DefaultComboBoxModel<String> comboExpLaboral = new DefaultComboBoxModel<String>();
		comboExpLaboral.addElement(Junior.class.getSimpleName());
		comboExpLaboral.addElement(SemiSenior.class.getSimpleName());
		comboExpLaboral.addElement(Senior.class.getSimpleName());
		this.vista.setComboExpLaboral(comboExpLaboral);
	}
	
	private void setComboTurnoLaboral() {
		DefaultComboBoxModel<String> comboTurnoLaboral = new DefaultComboBoxModel<String>();
		comboTurnoLaboral.addElement(TurnoManana.class.getSimpleName());
		comboTurnoLaboral.addElement(TurnoTarde.class.getSimpleName());
		this.vista.setComboTurnoLaboral(comboTurnoLaboral);
	}
	
	public PanelAbmTecnicos getVista() {
		return this.vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int idFilaSeleccionada = this.vista.getIdFilaSeleccionada();
		if (idFilaSeleccionada != -1) {
			this.mostrarDatosTecnico(idFilaSeleccionada);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		System.out.println(comandoAccionado);
		switch (comandoAccionado) {
			case "NUEVO_TECNICO":
				this.vista.pedirDatosTecnico();
				break;
			case "CREAR_TECNICO":
				this.crearTecnico();
				break;
			case "MODIFICAR_TECNICO":
				this.modificarTecnico();
				break;
			case "CANCELAR":
				this.vista.cerrarDialogoDatosTecnico();
				break;
			case "ELIMINAR_TECNICO":
				this.eliminarTecnico();
				break;
		}
	}
	
	
	private void mostrarDatosTecnico(int id) {
		TecnicoView tecnico = modelo.getTecnicoView(id);
		this.vista.mostrarDatosTecnico(tecnico.getId(), tecnico.getNombre(), tecnico.getDireccion(), tecnico.getUsuario(), tecnico.getContrasena(), 
				tecnico.getTurnoLaboral(), tecnico.getExperienciaLaboral());
	}
	
	
	
	private void crearTecnico() {
		//Falta validar si crearTecnico devuelve true or false
		this.modelo.crearTecnico(this.vista.getNombreTecnico(), this.vista.getDireccionTecnico(), this.vista.getTurnoLaboral(), this.vista.getUsuarioTecnico(), 
				this.vista.getContrasenaTecnico(), this.vista.getExpLaboral());
		
		this.vista.mostrarMensajeInformativo("Tecnico creado con exito", "Se creo el siguiente tecnico: " + this.datosTecnicoToString());
		this.vista.cerrarDialogoDatosTecnico();
		this.cargarListadoTecnicos();
	}
	
	
	private void modificarTecnico() {
		this.modelo.modificarTecnico(Integer.parseInt(this.vista.getId()), this.vista.getNombreTecnico() , this.vista.getDireccionTecnico(), 
				this.vista.getTurnoLaboral(), this.vista.getUsuarioTecnico(), this.vista.getContrasenaTecnico(), this.vista.getExpLaboral());
		System.out.println(this.vista.getTurnoLaboral());
		this.vista.cerrarDialogoDatosTecnico();
		this.cargarListadoTecnicos();
	}
	
	private void eliminarTecnico() {
		if (this.modelo.eliminarEmpleado(Integer.parseInt(this.vista.getId()))){
			this.vista.mostrarMensajeInformativo("Tecnico elimnado con exito", "Se elimino el siguiente tecnico: " + this.datosTecnicoToString());
		}
		else {
			this.vista.mostrarMensajeDeError("Ocurrio un error inesperado");
		}
		this.vista.cerrarDialogoDatosTecnico();
		this.cargarListadoTecnicos();
	}
	
	public String datosTecnicoToString() {
		String mensaje =  "\nNombre: " + this.vista.getNombreTecnico() + "\nDireccion: " + this.vista.getDireccionTecnico() + "\nTurno Laboral: " + 
				this.vista.getTurnoLaboral() + "\nExperiencia Laboral: " + this.vista.getExpLaboral() + "\nUsuario: " + this.vista.getUsuarioTecnico() +
				"\nContrasena: " + this.vista.getContrasenaTecnico();
		return mensaje;
	}
	
}