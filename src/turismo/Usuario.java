package turismo;

import java.util.Objects;

public class Usuario {
	private String nombre ;
	private int tiempoDisponible ;
	private int presupuesto ;
	private String preferencias ;
    private String promocionesAdquiridas ;
    private Sugerencia sugerencia;
    
    private String nombreAtraccionAceptada;
    private int precioAtraccionAceptada;
    private int tiempoAtraccionAceptada;
    private String tipoAtraccionAceptada;
    private int totalDineroAtraccionesCompradas;
    private int totalTiempoAtraccionesCompradas;
    
	
    public Usuario(String nombre , int tiempoDisponible , int presupuesto , String gusto) {
    	this.nombre= nombre;
    	this.tiempoDisponible= tiempoDisponible;
    	this.presupuesto = presupuesto ;
    	this.preferencias= gusto ;
    }   
    
    public String getNombre() {
		return nombre;
	}
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	
	public void setPresupuesto(int presupuesto) {
		if (validarDato(presupuesto)) {
			this.presupuesto -= presupuesto;			
		}
	}
	
	public int getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public void setTiempoDisponible(int tiempoDisponible) {
		if (validarDato(tiempoDisponible)) {
			this.tiempoDisponible -= tiempoDisponible;
		}
	}
	
	public String getPreferencias() {
		return preferencias;
	}
	
	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}
	
	public String getPromocionesAdquiridas() {
		return promocionesAdquiridas;
	}
	
	public void setPromocionesAdquiridas(String promocionesAdquiridas) {
		this.promocionesAdquiridas = promocionesAdquiridas;
	}
	
	private boolean validarDato(int dato) {
		return dato>0;
	}

	public void aceptaSugerencia(String nombre, int precio, int tiempo, String tipo) {
		this.nombreAtraccionAceptada = nombre;
		this.precioAtraccionAceptada = precio;		
		this.tiempoAtraccionAceptada = tiempo;
		this.tipoAtraccionAceptada = tipo;
		this.totalDineroAtraccionesCompradas+=precio;
		this.totalTiempoAtraccionesCompradas+=tiempo;
	}
	

	public String getNombreAtraccionAceptada() {
		return nombreAtraccionAceptada;
	}

	public int getPrecioAtraccionAceptada() {
		return precioAtraccionAceptada;
	}	

	public int getTiempoAtraccionAceptada() {
		return tiempoAtraccionAceptada;
	}

	public String getTipoAtraccionAceptada() {
		return tipoAtraccionAceptada;
	}
	public int getTotalDineroAtraccionesCompradas() {
		return totalDineroAtraccionesCompradas;
	}

	public int getTotalTiempoAtraccionesCompradas() {
		return totalTiempoAtraccionesCompradas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, preferencias, presupuesto, promocionesAdquiridas, sugerencia, tiempoDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(preferencias, other.preferencias)
				&& presupuesto == other.presupuesto
				&& Objects.equals(promocionesAdquiridas, other.promocionesAdquiridas)
				&& Objects.equals(sugerencia, other.sugerencia) && tiempoDisponible == other.tiempoDisponible;
	}
		
}
