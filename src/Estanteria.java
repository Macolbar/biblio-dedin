
public class Estanteria {

	//Propiedades
	//Limite de registros en el array
	private int max_Reg = 5;
	//Array normal con objetos Libro dentro y un valor maximo de la variable max_reg
	Libro[] libros = new Libro[max_Reg];
	//Reg es el contador de registros, que nos sirve para saber la cantidad de libros almacenados
	private int reg=0;
	//Variable que uso, para moverme entre el array, y no crearla a nivel local de método
	
	/**
	 * Introducimos por parametros un libro previamente creado.
	 * Comprobamos que no exista o que el array no esté lleno y si se cumple todo lo introducimos
	 * @param libro
	 * @return Devolvera valores de : 1 en caso de libro introducido
	 * 								 -1 en caso de que el libro ya exista
	 * 								  0 en caso de que el array este lleno
	 */
	public int insertarLibro(Libro libro){
		int estado;
		if(reg<max_Reg){	
			if(posicionLibro(libro.getIsbn()) == -1){//AQUI ISBN
				libros[reg]=(Libro) libro;
				estado=1;
				reg ++;
			}//if
			else{
				estado=-1;
			}//else
		}//if
		else{
			estado=0;
		}//else
		return estado;
	}//insertarLibro

	/**
	 * Entra por parametros una String con un titulo, y te devuelve el objeto libro exacto
	 * @param nombre
	 * @return
	 */
	public Libro buscarLibro(Libro nombre){
		int loc=0;
		while(loc<max_Reg){
			if(libros[loc]!=null)
				if(libros[loc].getIsbn().equals(nombre.getIsbn())){//AQUI hay que comparar con el libro
					return libros[loc];
				}//if
			loc++;
		}//while
		return null;
	}//buscarLibro
	
	
	/**
	 * 
	 * @param nombre
	 * @return 1 en caso de borrar el libro, 0 en caso de error
	 */
	/*
	 * Puesto que para borrar necesito una posición exacta, llamo al metodo buscarLibro que me la devuelve a 
	 * través de un nombre
	 */
	public int borrarLibro(String nombre){
		int loc=0;
		loc=posicionLibro(nombre);
		libros[loc]=libros[reg-1];
		reg--;
		return 1;
	}//borrarLibro
	
	/**
	 * Introduce un nombre de un libro por parametros y lo busca
	 * @param nombre
	 * @return La posición del libro, en caso de que esté, o -1 si no está
	 */
	private int posicionLibro(String nombre){
		int loc=0;
		/*
		 * Uso 2 metodos para buscar libro, puesto que para cargarlo en pantalla es simple sabiendo el libro
		 * Pero para borrarlo, en un array normal, necesito la posición exacta, con lo cual para no repetir el mismo
		 * codigo en "BorrarLibro", monto 2 metodos.
		 */
		while (loc < max_Reg){
			if(libros[loc]!=null){
				if (nombre.equals(libros[loc].getIsbn())) {//AQUI ISBN
					return loc;	
				}//if
				else{
					loc++;
				}//else
			}//1IF
			else	
			loc++;
		}//while
		return -1;
	}//posicionLibro


}//class
