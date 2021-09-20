package turismo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Archivo {
	
	public static LinkedList<Usuario> leerArchivoUsuario(String usuariosTxt){
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

		Scanner sc = null;
		
		try {
			sc = new Scanner (new File(usuariosTxt));
			
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				String nombre = datos[0];
				int tiempo = Integer.parseInt(datos[1]);
				int presupuesto = Integer.parseInt(datos[2]);
				String gusto = datos[3];
				
				Usuario usuario = new Usuario (nombre, tiempo, presupuesto, gusto);
				
				if (!usuarios.contains(usuario)) {
					usuarios.add(usuario);
				}
			}
		}

		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		sc.close();
		
		return usuarios;
	}
		
	public static LinkedList<Atraccion> leerArchivoAtracion(String atraccionTxt){
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();

		Scanner sc = null;
		
		try {
			sc = new Scanner (new File(atraccionTxt));
			
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				String nombre = datos[0];
				int costo = Integer.parseInt(datos[1]);
				int tiempo = Integer.parseInt(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				String gusto = datos[4];
				
				Atraccion atraccion = new Atraccion (nombre, costo, tiempo, cupo, gusto);
				
				if (!atracciones.contains(atraccion)) {
					atracciones.add(atraccion);
				}
			}
		}

		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		sc.close();
		
		return atracciones;
	}
	
	public static void generarTicketConTryCatch(Usuario usuario, String fileName) throws IOException {
		String nombreArchivo = fileName + ".txt";
		//PrintWriter ticket = new PrintWriter(archivo);
		
		try {		
			FileWriter archivo = new FileWriter(nombreArchivo + ".txt",true);
			PrintWriter ticket = new PrintWriter(nombreArchivo);
			
			String nombre = usuario.getNombreAtraccionAceptada();
			int presupuesto = usuario.getPrecioAtraccionAceptada();
			int tiempo = usuario.getTiempoAtraccionAceptada();
			int totalPresupuesto = usuario.getTotalDineroAtraccionesCompradas();
			int totalTiempo = usuario.getTotalTiempoAtraccionesCompradas();
			
			ticket.println(nombre + "," + tiempo + "," + presupuesto + "," + 
					totalTiempo + "," + totalPresupuesto);
			ticket.close();
		}
		
		catch (FileNotFoundException e) {
			  // File not found
			  e.printStackTrace();
			} 
		
		catch (IOException e) {
			  // Error when writing to the file
			  e.printStackTrace();
			}
		
	}
		
	
	public static void generarTicket(Usuario usuario, String fileName) throws IOException {
		String nombreArchivo = fileName + ".txt";
		FileWriter archivo = new FileWriter(nombreArchivo,true);
		//PrintWriter ticket = new PrintWriter(archivo);
		PrintWriter ticket = new PrintWriter(archivo);
		
		String nombreUsuario = usuario.getNombre();
		String nombreAtraccion = usuario.getNombreAtraccionAceptada();
		int presupuesto = usuario.getPrecioAtraccionAceptada();
		int tiempo = usuario.getTiempoAtraccionAceptada();
		int totalPresupuesto = usuario.getTotalDineroAtraccionesCompradas();
		int totalTiempo = usuario.getTotalTiempoAtraccionesCompradas();
		
		ticket.println(nombreUsuario + "," + nombreAtraccion + "," + presupuesto + "," + tiempo + "," + 
						totalPresupuesto + "," + totalTiempo);
	
		//no estoy pudiendo cargar los archivos en distintas líneas,
		//sólo me reescribe la primer línea con el último dato
		
        ticket.close();
	}
	
	public static void generarTicketDesdeArchivo(String fileName) throws IOException {
		
		String usuario = fileName;
		int totalPresupuesto = 0;
		int totalTiempo = 0;	
		System.out.println("****** TICKET ******");
		System.out.println("Usuario: " + usuario.substring(0, usuario.length()-4));
		
		
		Scanner sc = null;
		
		try {
			sc = new Scanner (new File(fileName));
			
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String compras[] = linea.split(",");		
				
				String nombreUsuario = compras[0];
				String atraccionAceptada = compras[1];
				int costoAtraccion = Integer.parseInt(compras[2]);
				int tiempoAtraccion = Integer.parseInt(compras[3]);
				//totalPresupuesto += Integer.parseInt(compras[4]);
				//totalTiempo +=Integer.parseInt(compras[5]);
				totalPresupuesto = Integer.parseInt(compras[4]);
				totalTiempo =Integer.parseInt(compras[5]);			
				
	
				System.out.println("\nAtracción elegida: \t\t\t" + compras[1]);
				System.out.println("Precio de la atracción: \t\t\t" + compras[2]);
				System.out.println("Tiempo de la atracción: \t\t\t" + compras[3]);					

			}
			
			System.out.println("\nTotal del ticket: \t\t\t\t" + totalPresupuesto);
			System.out.println("Total de horas de las atracciones compradas: \t" + totalTiempo);
			System.out.println("\n");
			
		}

		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		sc.close();
		
	}
}
