package servicio;

import modelo.CategoriaEnum;
import modelo.Cliente;

//9. Create the CustomerService class in the service package with the following requirements: 
//Interface what, but don't how.
public interface ClienteServicio {
	
	
	public void creaCliente(Cliente client);
 
	public void agregarCliente(Cliente client);
	
	public void editarCliente(Cliente client);

	void editarCliente1(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum Activo);
	
	
}
 