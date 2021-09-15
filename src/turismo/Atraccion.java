package turismo;

import java.util.Objects;

public class Atraccion extends Sugerencia implements Comparable<Atraccion>{
	private String nombre;
	private Integer costo;
	private Integer tiempo;
	private int cupo;
	private String tipoAtraccion;

	public Atraccion(String nombre, int costo, int tiempo, int cupo, String tipoAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;				
	}
	
	public String getAtraccion() {
		return this.nombre;
	}
	
	public int getPrecio() {
		return this.costo;
	}
	
	public int getTiempo() {
		return this.tiempo;
	}
	
	public int getCupo() {
		return this.cupo;
	}
	
	public void setCupo() {
		this.cupo--;
	}
	
	public String getTipoAtraccion() {
		return this.tipoAtraccion;
	}
	

	@Override
	public int compareTo(Atraccion o) {
		if (this.tipoAtraccion.compareTo(o.tipoAtraccion) == 0) {
			if (this.costo.compareTo(o.costo) == 0 ){
				return this.tiempo.compareTo(o.tiempo);
				
			}
			return this.costo.compareTo(o.costo);
		}
		return this.tipoAtraccion.compareTo(o.tipoAtraccion);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(costo, cupo, tipoAtraccion, nombre, tiempo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return Objects.equals(costo, other.costo) && cupo == other.cupo && Objects.equals(tipoAtraccion, other.tipoAtraccion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tiempo, other.tiempo);
	}
	
	

}
