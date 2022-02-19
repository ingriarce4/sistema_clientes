package servicio;

import java.util.Map;

import modelo.Cliente;
//10.- create class abstrac explorador

public abstract class Exportador {
	public abstract void exportar  (String fileName, Map<String, Cliente> listaCliente); 
	 
 }

