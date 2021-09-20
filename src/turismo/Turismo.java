package turismo;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Turismo {


	
	public static void main(String[] args) throws IOException {
		String respuesta = " ";
		Scanner leer = new Scanner (System.in);
		
		LinkedList<Usuario> usuarios = Archivo.leerArchivoUsuario("usuarios.txt");
		LinkedList<Atraccion> atracciones = Archivo.leerArchivoAtracion("atracciones.txt");
		
		//Collections.sort(atracciones);
		
		Collections.sort(atracciones, new OrdenarPorPrecio());
		Collections.sort(atracciones, new OrdenarPorTiempo());
		
		
		for (Usuario cadaUsuario : usuarios) {
			
			System.out.println(" *** Bienvenido " + cadaUsuario.getNombre() + " ****");
			System.out.println("Dinero disponible: " + cadaUsuario.getPresupuesto());
			System.out.println("Tiempo disponible: " + cadaUsuario.getTiempoDisponible());
			System.out.println("Tipo de atracción preferida: " + cadaUsuario.getPreferencias());
			
			System.out.println("\nPodemos ofrecerte las siguientes atraccciones y promociones, basadas en tus intereses: ");			
			
		
			for (Atraccion cadaAtraccion : atracciones){		
				
				if (cadaAtraccion.getTipoAtraccion().equals(cadaUsuario.getPreferencias())) {
					if (cadaAtraccion.getPrecio() <= cadaUsuario.getPresupuesto()) 
						if (cadaAtraccion.getTiempo() <= cadaUsuario.getTiempoDisponible())
							if (cadaAtraccion.getCupo()>0) {
								
								System.out.println("Atracción: " + cadaAtraccion.getAtraccion());
								System.out.println("Monedas: " + cadaAtraccion.getPrecio());
								System.out.println("Tiempo: " + cadaAtraccion.getTiempo());
								System.out.println("Tipo de atracción: " + cadaAtraccion.getTipoAtraccion());
								
								System.out.println("Desea comprarlo? (S/N)");
								respuesta = leer.nextLine();
								
								if (respuesta.contentEquals("S") || respuesta.contentEquals("s")) {
									cadaUsuario.setPresupuesto(cadaAtraccion.getPrecio());
									cadaUsuario.setTiempoDisponible(cadaAtraccion.getTiempo());
									cadaAtraccion.setCupo();
									cadaUsuario.aceptaSugerencia(cadaAtraccion.getAtraccion(), cadaAtraccion.getPrecio(), cadaAtraccion.getTiempo());
									
									System.out.println("Compra exitosa!!!");
									System.out.println("Saldo disponible: " + cadaUsuario.getPresupuesto());
									System.out.println("Tiempo disponible: " + cadaUsuario.getTiempoDisponible());
									System.out.println("");
									Archivo.generarTicket(cadaUsuario, cadaUsuario.getNombre());
									
								}
								else {
									System.out.println("");
									System.out.println("Tenemos otra propuesta para que elijas: ");						
								}
							}
				
							}	
			}
			
			for (Atraccion cadaAtraccion2 : atracciones){

				if (!cadaAtraccion2.getTipoAtraccion().equals(cadaUsuario.getPreferencias()))
					if (cadaAtraccion2.getPrecio() <= cadaUsuario.getPresupuesto()) 
						if (cadaAtraccion2.getTiempo() <= cadaUsuario.getTiempoDisponible())
							if (cadaAtraccion2.getCupo()>0) {
								System.out.println("Atracción: " + cadaAtraccion2.getAtraccion());
								System.out.println("Monedas: " + cadaAtraccion2.getPrecio());
								System.out.println("Tiempo: " + cadaAtraccion2.getTiempo());
								System.out.println("Tipo de atracción: " + cadaAtraccion2.getTipoAtraccion());
								
								System.out.println("Desea comprarlo? (S/N)");
								respuesta = leer.nextLine();
								
								if (respuesta.contentEquals("S") || respuesta.contentEquals("s")) {
									cadaUsuario.setPresupuesto(cadaAtraccion2.getPrecio());
									cadaUsuario.setTiempoDisponible(cadaAtraccion2.getTiempo());
									cadaAtraccion2.setCupo();
									cadaUsuario.aceptaSugerencia(cadaAtraccion2.getAtraccion(), cadaAtraccion2.getPrecio(), cadaAtraccion2.getTiempo());
									
									System.out.println("Compra exitosa!!!");
									System.out.println("Saldo disponible: " + cadaUsuario.getPresupuesto());
									System.out.println("Tiempo disponible: " + cadaUsuario.getTiempoDisponible());
									System.out.println("");
									Archivo.generarTicket(cadaUsuario, cadaUsuario.getNombre());
									
								}
								
				}

			}

			Archivo.generarTicketDesdeArchivo(cadaUsuario.getNombre() + ".txt");
		}	
		
	}	
}


