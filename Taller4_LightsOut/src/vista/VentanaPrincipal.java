package vista;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame {

	
	private Tablero tablero;
	private Top10 top10;
	
	
	private PanelOpcionesNJuego pNorte;
	private PanelDatos pSur;
	
	private PanelOpciones pEste;
	
	private PanelTablero pCentro;
	private String jugador;
	
	
	
	public VentanaPrincipal()
	{
		
		this.top10=new Top10();
		
		setSize( 800, 720 );
        setTitle( "Lights Out" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        
        setLayout( new BorderLayout( ) );
        
        pNorte = new PanelOpcionesNJuego( );
        add(pNorte, BorderLayout.NORTH);
        
        //nuevo juego
        this.tablero=new Tablero(5);
        
        
        pSur = new PanelDatos();
        add(pSur, BorderLayout.SOUTH);
        
        pEste = new PanelOpciones(this);
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
        
        
        
//        while (this.jugador==null)
//        {
//        	this.cambiarJuegador();
//        }
//        
//        this.actualizarPuntos();
        this.pCentro.actualizarTablero(this.tablero);
        
	}
	
	

	public void reiniciarJuego() {
		// TODO Auto-generated method stub
        this.tablero.reiniciar();
        
        
        this.pCentro.actualizarTablero(this.tablero);
	}

	public void darTop10() {
		// TODO Auto-generated method stub
		
	}

	public void cambiarJuegador() {
		this.jugador = JOptionPane.showInputDialog( this, "Ingrese el nombre del jugador", "Jugador", JOptionPane.QUESTION_MESSAGE );
	
	}
	
	public static void main(String[] args) 
	{
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setResizable( false );
		ventana.setVisible( true );
		
		
	}
	public void gano()
	{
		JOptionPane.showMessageDialog( this, "¡Felicitaciones! ganó la partida", "¡Felicitaciones!", JOptionPane.INFORMATION_MESSAGE );
		this.iniciarJuego();
		
		int puntaje = this.tablero.calcularPuntaje();
		this.top10.agregarRegistro(jugador, puntaje);
	}

	public void actualizarPuntos() {
		int jugadas = this.tablero.darJugadas();
		String jugador = this.jugador;
		this.pSur.actualizar(jugadas, jugador);
		
	}
}
