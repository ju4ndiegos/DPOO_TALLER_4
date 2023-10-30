package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame {

	//para modificar facil
	
	private String rutaFile ="./data/top10.csv";
	
	private Tablero tablero;
	private Top10 top10;
	
	private PanelOpcionesTablero pNorte;
	private PanelDatos pSur;
	
	private PanelMenu pEste;
	
	private PanelTablero pCentro;
	private String jugador;
	
	private static Font fuente = new Font("Arial", Font.BOLD, 14);
	
	
	
	public VentanaPrincipal()
	{
		getContentPane().setBackground(new Color(255,253,247));
		this.top10=new Top10();
		
		setSize( 805, 725 );
        setTitle( "Lights Out" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        
        
        setLayout( new BorderLayout( ) );
        
        pNorte = new PanelOpcionesTablero( );
        add(pNorte, BorderLayout.NORTH);
        
        //nuevo juego
        this.tablero=new Tablero(5);
        
        
        pSur = new PanelDatos();
        add(pSur, BorderLayout.SOUTH);
        
        pEste = new PanelMenu(this);
        add(pEste, BorderLayout.EAST);
        
        pCentro = new PanelTablero(tablero,this);
        add(pCentro,BorderLayout.CENTER);
        
		
		
		
	}
	
	public void iniciarJuego()
	{
		int tamanio = pNorte.darTamanioTablero();
		//System.out.println(pNorte.darTamanioTablero());
		this.tablero=new Tablero(tamanio);
        this.tablero.desordenar(pNorte.darDificultad());
        
        //while (this.tablero.tableroIluminado()==true)
		//{
		//	this.tablero.desordenar(pNorte.darDificultad());
		//}
        
        
        
        this.actualizarPuntos();
        this.pCentro.actualizarTablero(this.tablero);
        
	}
	
	

	public void reiniciarJuego() {
		// TODO Auto-generated method stub
        this.tablero.reiniciar();
        
        
        this.pCentro.actualizarTablero(this.tablero);
	}

	public void darTop10() {
		// TODO Auto-generated method stub
		//this.top10.cargarRecords(new File(this.rutaFile));
		
		Collection<RegistroTop10> top10Records = this.top10.darRegistros();
		
		DefaultListModel<RegistroTop10> top10ListModel = new DefaultListModel<>();

        // Agrega tus registros a la lista
        for (RegistroTop10 registro : top10Records) {
            top10ListModel.addElement(registro);
        }
        

        JList<RegistroTop10> top10List = new JList<>(top10ListModel);
        top10List.setBackground(new Color(112,193,179));
        top10List.setSize(220, 230);
        
        Font customFont = this.fuente;
        top10List.setFont(customFont);
        top10List.setForeground(new Color(241,227,243));
        
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) top10List.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        

        JPanel panel = new JPanel();
        panel.add(top10List);
        panel.setBackground(new Color(112,193,179));
        panel.setSize(220, 230);
        
        panel.setLayout(new GridBagLayout());

        // Configurar GridBagConstraints para que el JList ocupe todo el espacio horizontal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; // Establece weighty en 0 para evitar que el JList ocupe espacio vertical
        panel.add(top10List, gbc);
        
        
        JFrame frame = new JFrame("Top 10");
        frame.add(panel);
        frame.getContentPane().setBackground(new Color(112,193,179));
        frame.setLocationRelativeTo(null);
        frame.setSize(220, 230);
        frame.setVisible(true);
        frame.setResizable(false);
		
		
	}

	public void cambiarJugador() {
		String jugador = "";
		boolean funcionando = true;
		while (funcionando) {
		    jugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador (3 letras):", "Jugador", JOptionPane.QUESTION_MESSAGE);
		    //System.out.println(jugador+jugador.length());
		    if (jugador != null && jugador.length() == 3) { 
		    	//System.out.println("a");
		        funcionando =false;
		    } else {
		        JOptionPane.showMessageDialog(this, "Por favor, ingrese exactamente 3 letras válidas (A-Z, a-z).", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		this.jugador = jugador;
	
	}
	
	public static void main(String[] args) 
	{
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setResizable( false );
		ventana.setVisible( true );
		
		
	}
	public void gano() throws FileNotFoundException, UnsupportedEncodingException
	{
		JOptionPane.showMessageDialog( this, "¡Felicitaciones! ganó la partida", "¡Felicitaciones!", JOptionPane.INFORMATION_MESSAGE );
		this.iniciarJuego();
		
		this.cambiarJugador();
        

		int puntaje = this.tablero.calcularPuntaje();
		this.top10.agregarRegistro(jugador, puntaje);
		//this.top10.salvarRecords(new File("C:/Users/juand/git/Taller-4-/Taller4_LightsOut/data/top10.csv"));
	}

	
	
	public void actualizarPuntos() {
		int jugadas = this.tablero.darJugadas();
		String jugador = this.jugador;
		this.pSur.actualizar(jugadas, jugador);
		
	}

	public static Font darFuente() {
		// TODO Auto-generated method stub
		return fuente;
	}
}
