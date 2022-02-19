package modelo;

//4.- Create the class "cliente" in package "Model"
//with the following requeriments.

//Crear la clase Cliente en package modelo, con los siguientes requisitos:
//String runCliente
//String nombreCliente
//String apellidoCliente
//String aniosCliente (se puede cambiar a int si lo desea)
//CategoriaEnum nombreCategoria
//Generar el constructor con parámetros
//Generar los getter y setter correspondientes
//Generar el toString para los parámetros

public class Cliente {
	
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String  anionsCliente;
	
	private CategoriaEnum Categoria;

	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String anionsCliente,
			CategoriaEnum categoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.anionsCliente = anionsCliente;
		this.Categoria = categoria;
	}


	public String getRunCliente() {
		return runCliente;
	}
	
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getAnionsCliente() {
		return anionsCliente;
	}
	public void setAnionsCliente(String datos) {
		this.anionsCliente = datos;
	}
	public CategoriaEnum getCategoria() {
		return Categoria;
	}
	public void setCategoria(CategoriaEnum categoria) {
		this.Categoria = categoria;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Run del cliente : %s \n",       getRunCliente()));
		sb.append(String.format("Nombres del cliente : %s \n",   getNombreCliente()));
		sb.append(String.format("Apellidos del cliente : %s \n", getApellidoCliente()));
		sb.append(String.format("Años como cliente: %d \n",      getAnionsCliente()));
		sb.append(String.format("Categoria del cliente: %s \n",  getCategoria()));

		return sb.toString();
	}

//	@Override
//	public String toString() {
//		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
//				+ apellidoCliente + ", anionsCliente=" + anionsCliente + ", Categoria=" + Categoria
//				+ ", getRunCliente()=" + getRunCliente() + ", getNombreCliente()=" + getNombreCliente()
//				+ ", getApellidoCliente()=" + getApellidoCliente() + ", getAnionsCliente()=" + getAnionsCliente()
//				+ ", getCategoria()=" + getCategoria() + ", getValue()=" + getValue() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}

}
	
	
