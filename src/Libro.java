
public class Libro {
	
	//Propiedades
	private String titulo;
	private String autor;
	private String tema;
	private String isbn;
	private int numPaginas;
	private String[] formato=new String[3];
	private String []estado=new String[2];
	private int locTema;

	//GETTERS AND SETTERS
	
	public String getTitulo() {
		return titulo;
	}//gettitulo
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}//setTitulo
	public String getAutor() {
		return autor;
	}//getAutor
	public void setAutor(String autor) {
		this.autor = autor;
	}//setAutor
	public String getTema() {
		return tema;
	}//getTema
	public void setTema(String tema) {
		this.tema = tema;
	}//setTema
	public int getNumPaginas() {
		return numPaginas;
	}//getNumPaginas
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}//setPaginas
	public String getFormato(int posicion) {
		return formato[posicion];
	}//getFormato
	public void setFormato(int posicion,String formato) {
		this.formato[posicion] = formato;
	}//setFormato
	public String getEstado(int posicion) {
		return estado[posicion];
	}//getEstado
	public void setEstado(int posicion,String estado) {
		this.estado[posicion] = estado;
	}//setEstado
	public int getLocTema() {
		return locTema;
	}//getLocTema
	public void setLocTema(int locTema) {
		this.locTema = locTema;
	}//setTema
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString(){
		return this.titulo;
	}
}//Libreria
