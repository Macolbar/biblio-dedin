import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

@SuppressWarnings("serial")
public class Libreria extends JFrame {

	private JPanel PanelLibreria;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtNumPaginas;
	private JTextField txtIsbn;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTemas;
	private JCheckBox chkCartone;
	private JCheckBox chkRustica;
	private JCheckBox chkTapaDura;
	private JRadioButton optNovedad;
	private JRadioButton optReedicion;
	@SuppressWarnings("rawtypes")
	private JList lstLibrosDisponibles;
	private JLabel lblMensaje;
	//dlmNombres serï¿½a array especï¿½fico de tipo Default DefaultListModel para cargar los datos en la 
	//lista lstLibrosDisponibles
	private DefaultListModel<Libro>dlmNombres=new DefaultListModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estanteria acceso = new Estanteria();
					Libreria frame = new Libreria(acceso);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//main
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Libreria(Estanteria acceso) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 500);
		PanelLibreria = new JPanel();
		PanelLibreria.setToolTipText("Libreria");
		PanelLibreria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelLibreria);
		PanelLibreria.setLayout(null);

		JLabel lblTitulo = new JLabel("LIBRER\u00CDA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setToolTipText("Librer\u00EDa\r\n");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTitulo.setBounds(10, 11, 298, 47);
		PanelLibreria.add(lblTitulo);

		JLabel lblTituloLibro = new JLabel("T\u00EDtulo");
		lblTituloLibro.setToolTipText("");
		lblTituloLibro.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTituloLibro.setBounds(10, 81, 64, 32);
		PanelLibreria.add(lblTituloLibro);

		JLabel lblAutorLibro = new JLabel("Autor");
		lblAutorLibro.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblAutorLibro.setBounds(10, 132, 64, 32);
		PanelLibreria.add(lblAutorLibro);

		JLabel lblTemaLibro = new JLabel("Tema");
		lblTemaLibro.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTemaLibro.setBounds(10, 185, 64, 32);
		PanelLibreria.add(lblTemaLibro);
		
		JLabel lblNumPaginas = new JLabel("Num.P\u00E1ginas");
		lblNumPaginas.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNumPaginas.setBounds(10, 240, 116, 32);
		PanelLibreria.add(lblNumPaginas);

		JPanel panelFormato = new JPanel();
		panelFormato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "FORMATO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFormato.setBounds(295, 81, 204, 120);
		PanelLibreria.add(panelFormato);
		panelFormato.setLayout(null);

		chkCartone = new JCheckBox("Cartone");
		chkCartone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		chkCartone.setBounds(6, 22, 97, 23);
		panelFormato.add(chkCartone);

		chkRustica = new JCheckBox("Rustica");
		chkRustica.setFont(new Font("Century Gothic", Font.BOLD, 14));
		chkRustica.setBounds(6, 57, 97, 23);
		panelFormato.add(chkRustica);

		chkTapaDura = new JCheckBox("Tapa Dura");
		chkTapaDura.setFont(new Font("Century Gothic", Font.BOLD, 14));
		chkTapaDura.setBounds(6, 90, 97, 23);
		panelFormato.add(chkTapaDura);

		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ESTADO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEstado.setBounds(295, 208, 204, 79);
		PanelLibreria.add(panelEstado);
		panelEstado.setLayout(null);
		
		JLabel lblLibrosDisponibles = new JLabel("Libres");
		lblLibrosDisponibles.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblLibrosDisponibles.setBounds(305, 290, 55, 32);
		PanelLibreria.add(lblLibrosDisponibles);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblIsbn.setBounds(10, 300, 55, 14);
		PanelLibreria.add(lblIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(71, 297, 123, 20);
		txtIsbn.setToolTipText("Introduce el ISBN");
		txtIsbn.setFont(new Font("Century Gothic", Font.BOLD, 11));
		PanelLibreria.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setToolTipText("Introduce el titulo\r\n");
		txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTitulo.setFont(new Font("Century Gothic", Font.BOLD, 11));
		txtTitulo.setBounds(71, 89, 123, 20);
		PanelLibreria.add(txtTitulo);
		txtTitulo.setColumns(10);


		txtAutor = new JTextField();
		txtAutor.setToolTipText("Introduce el Autor del Libro");
		txtAutor.setFont(new Font("Century Gothic", Font.BOLD, 11));
		txtAutor.setColumns(10);
		txtAutor.setBounds(71, 140, 123, 20);
		PanelLibreria.add(txtAutor);


		cmbTemas = new JComboBox();
		cmbTemas.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTemas.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Aventuras", "Biograf\u00EDa", "Ciencia", "Ciencia Ficci\u00F3n", "Cine", "Econom\u00EDa", "Gastronom\u00EDa", "Historia", "Inform\u00E1tica", "Medicina", "Misterio", "Naturaleza", "Polic\u00EDaco", "Pol\u00EDtica", "Rom\u00E1ntica", "Teatro", "Terror"}));
		cmbTemas.setToolTipText("Elige un Tema para tu Libro");
		cmbTemas.setBounds(71, 193, 123, 20);
		PanelLibreria.add(cmbTemas);


		txtNumPaginas = new JTextField();
		txtNumPaginas.setToolTipText("Introduce las P\u00E1ginas");
		txtNumPaginas.setFont(new Font("Century Gothic", Font.BOLD, 11));
		txtNumPaginas.setColumns(10);
		txtNumPaginas.setBounds(111, 240, 55, 32);
		PanelLibreria.add(txtNumPaginas);

		lblMensaje = new JLabel("");
		//lblMensaje.setIcon(new ImageIcon(Libreria.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		lblMensaje.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblMensaje.setBounds(300, 11, 258, 59);
		PanelLibreria.add(lblMensaje);
		PanelLibreria.setFocusable(false);
		

		
		/**
		 * BOTON NUEVO ------------------------------------------------
		 */
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vaciarPantalla();//enableAll() crear!
				cmbTemas.setSelectedIndex(0);
				lblMensaje.setText("");
			}
		});
		btnNuevo.setToolTipText("Nuevo Libro");
		btnNuevo.setBounds(10, 346, 116, 47);
		PanelLibreria.add(btnNuevo);
		 
		/**
		 * BOTON BAJA ------------------------------------------------
		 */
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Century Gothic", Font.BOLD, 17));
				btnBaja.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int borrarDisponible=lstLibrosDisponibles.getSelectedIndex();
						acceso.borrarLibro(lstLibrosDisponibles.getSelectedValue().toString());
						dlmNombres.remove(borrarDisponible);
						lstLibrosDisponibles.repaint();
						vaciarPantalla();
					}
				});
		btnBaja.setToolTipText("Dar de Baja");
		btnBaja.setBounds(140, 346, 116, 47);
		PanelLibreria.add(btnBaja);
		
		/**
		 * BOTON ALTA --------------------------
		 */
		JButton btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int estado = 0;
				/**** MARCO: Esta linea sobra ****/
				//cmbTemas.getSelectedIndex(); 
				estado = acceso.insertarLibro(recogerDatosPantalla());
				if(estado==1){
					//No deja usar Esta linea :
					//dlmNombres.addElement(dlmNombres.addElement(txtTitulo.getText()));
					lblMensaje.setText("Libro Creado Correctamente");
					dlmNombres.addElement(recogerDatosPantalla());//tiene que añadir el libro, no el titulo
					//si quiere que se muestre los nombres y no el ISBN
					lstLibrosDisponibles.setModel(dlmNombres);
				}
				else if(estado==-1)
					lblMensaje.setText("El libro ya existe");
				else if(estado == 0)
					lblMensaje.setText("No hay espacio para mas libros");
			}
		
		});
		btnAlta.setToolTipText("Alta Libro Nuevo");
		btnAlta.setBounds(10, 404, 116, 47);
		PanelLibreria.add(btnAlta);
		
		/**
		 *  BOTON SALIR ----------------------------------------
		 */
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setToolTipText("Salir del Programa");
		btnSalir.setBounds(140, 404, 116, 47);
		PanelLibreria.add(btnSalir);
		/**
		 *  OPCIï¿½N NOVEDAD ----------------------------------------
		 */
		optNovedad = new JRadioButton("Novedad");
		
		/********************* MARCO *************************
		 * 		Ver ButtonGroup en linea 311 
		 * 
		optNovedad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				//Si un optionButton esta seleccionado, desselecciono el otro, puesto que solo puede haber
				//una a la vez
				//********************* MARCO *************************
				//* if(optNovedad.isSelected())
				//*	optReedicion.setSelected(false);
				//*****************************************************
				optReedicion.setSelected(!optNovedad.isSelected());
				//****************************************************
			}
		});
		**************************************************************/
		
		optNovedad.setFont(new Font("Century Gothic", Font.BOLD, 14));
		optNovedad.setBounds(6, 24, 109, 23);
		panelEstado.add(optNovedad);
		
		/**
		 *  OPCIï¿½N REEDICCIï¿½N ----------------------------------------
		 */
		optReedicion = new JRadioButton("Reedici\u00F3n");
		
		/********************* MARCO *************************
		 * 		Ver ButtonGroup en linea 311
		 * 
		optReedicion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				//Si un optionButton esta seleccionado, desselecciono el otro, puesto que solo puede haber
				//una a la vez
				
				//********************* MARCO *************************
				//* if(optReedicion.isSelected())
				//*	optNovedad.setSelected(false);
				//*****************************************************				
				optNovedad.setSelected(!optReedicion.isSelected());				
				//***************************************************
			}
		});
		**************************************************************/
		
		optReedicion.setFont(new Font("Century Gothic", Font.BOLD, 14));
		optReedicion.setBounds(6, 50, 109, 23);
		panelEstado.add(optReedicion);
		
		/********************* MARCO *************************/
		ButtonGroup group = new ButtonGroup();
		group.add(optReedicion);
		group.add(optNovedad);
		/*****************************************************/
		
		/**
		 *  LISTA DISPONIBLES ----------------------------------------
		 */
		lstLibrosDisponibles = new JList();
		lstLibrosDisponibles.setVisibleRowCount(5);
				lstLibrosDisponibles.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						lstLibrosDisponibles.getSelectedIndex();
						//esto esta mal, tienes que coger el libro y despues su ISBN y pasarlo abajo
						enviarDatosAPantalla(acceso.buscarLibro(lstLibrosDisponibles.getSelectedValue()));
					}
				});
		lstLibrosDisponibles.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lstLibrosDisponibles.setBounds(310, 315, 189, 136);
		PanelLibreria.add(lstLibrosDisponibles);
		
		
		
	
		
		
		
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtTitulo, txtAutor, cmbTemas, txtNumPaginas,txtIsbn, chkCartone, chkRustica, chkTapaDura, optNovedad, optReedicion, PanelLibreria, btnAlta, btnBaja})); 
	}//constructor
	
	// ***********************  Mï¿½TODOS  ******************************************************
	
	/******************************************************************************************
	 * Metodo para recoger los datos
	 * Este metodo mas adelante, ira en la clase parcialLibreria
	 * Se encarga de montar un libro a travï¿½s de los datos que introduces en la ventana grï¿½fica
	 */

	private Libro recogerDatosPantalla(){
		Libro libro;
		//String categoria1 = (String) jCCategoria1.getSelectedItem();
		libro=new Libro();
		libro.setTitulo(txtTitulo.getText());
		libro.setAutor(txtAutor.getText());
		libro.setIsbn(txtIsbn.getText());
		//SI introducimos un parametro diferente a un numero nos pone por defecto 0
		try {
			libro.setNumPaginas(Integer.valueOf((txtNumPaginas.getText())));
		}//try
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			libro.setNumPaginas(0);
		}//catch
		String temaSeleccionado = cmbTemas.getSelectedItem().toString();
		libro.setTema(temaSeleccionado);
		libro.setLocTema(cmbTemas.getSelectedIndex());
		
		/************************ MARCO ************************************
		 * Yo cambiaria estas asignaciones por operadores ternarios
		 *******************************************************************
		if(chkCartone.isSelected()){
			libro.setFormato(0,"Carton");
		}//if
		else{
			libro.setFormato(0,".");
		}//else
		if(chkRustica.isSelected()){
			libro.setFormato(1,"Rustico");
		}//if
		else{
			libro.setFormato(1,".");
		}//if
		if(chkTapaDura.isSelected()){
			libro.setFormato(2,"Tapa Dura");
		}//if
		else{
			libro.setFormato(2,".");
		}//else
		//JradioButton
		if(optNovedad.isSelected()){
			libro.setEstado(0, "Novedad");
		}//if
		else{
			libro.setEstado(0, ".");
		}//if
		if(optReedicion.isSelected()){
			libro.setEstado(1, "Reedicion");
		}//if
		else{
			libro.setEstado(1, ".");
		}//else
		********************************************************************/
		libro.setFormato(0,chkCartone.isSelected() ? "Carton" : ".");
		libro.setFormato(1,chkRustica.isSelected() ? "Rustico" : ".");
		libro.setFormato(2,chkTapaDura.isSelected() ? "Tapa Dura" : ".");
		libro.setEstado(0, optNovedad.isSelected() ? "Novedad" : ".");
		libro.setEstado(1, optReedicion.isSelected() ? "Reedicion" : ".");
		/*******************************************************************/
		return libro;
	}//recogerDatosPantalla
	
	/*
	 * Metodo que limpia todos los campos y pone a null la parte grï¿½fica
	 */
	private void vaciarPantalla(){
		txtTitulo.setText(null);
		txtAutor.setText(null);
		txtNumPaginas.setText(null);
		txtIsbn.setText(null);
		chkCartone.setSelected(false);
		chkRustica.setSelected(false);
		chkTapaDura.setSelected(false);
		optNovedad.setSelected(false);
		optReedicion.setSelected(false);
	}//vaciarPantalla
	
	
	/**
	 * Pasamos por parametro un libro, y este mï¿½todo se encarga de mostrarnos en la parte grï¿½fica
	 * todo el contenido de ese libro.
	 */
	private void enviarDatosAPantalla(Libro libro){
		txtTitulo.setText(libro.getTitulo());
		txtAutor.setText(libro.getAutor());
		txtNumPaginas.setText(String.valueOf(libro.getNumPaginas()));
		cmbTemas.setSelectedIndex(libro.getLocTema());
		txtIsbn.setText(libro.getIsbn());
		/************************ MARCO ************************************
		 * Yo cambiaria estas asignaciones por asignaciones directas
		 *******************************************************************
		if(libro.getFormato(0)!="."){
			chkCartone.setSelected(true);
		}//
		else
			chkCartone.setSelected(false);
		if(libro.getFormato(1)!="."){
			chkRustica.setSelected(true);
		}//
		else
			chkRustica.setSelected(false);
		if(libro.getFormato(2)!="."){
			chkTapaDura.setSelected(true);
		}//if
		else
			chkTapaDura.setSelected(false);
		if(libro.getEstado(0)!="."){
			optNovedad.setSelected(true);
		}//if
		else
			optNovedad.setSelected(false);
		if(libro.getEstado(1)!="."){
			optReedicion.setSelected(true);
		}//if
		else
			optReedicion.setSelected(false);
		*********************************************************************/
		chkCartone.setSelected(libro.getFormato(0)!=".");
		chkRustica.setSelected(libro.getFormato(1)!=".");
		chkTapaDura.setSelected(libro.getFormato(2)!=".");
		optNovedad.setSelected(libro.getEstado(0)!=".");
		optReedicion.setSelected(libro.getEstado(1)!=".");
		/********************************************************************/
	}//enviarDatosAPantalla
}//class
