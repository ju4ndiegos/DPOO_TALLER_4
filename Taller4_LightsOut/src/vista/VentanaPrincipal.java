package vista;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;


import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame {

	
	private Tablero tablero;
	private Top10 top10;
	
	
	private PanelNorte pNorte;
	private PanelSur pSur;
	
	private PanelEste pEste;
	
	private PanelCentro pCentro;
	
	
	
	public VentanaPrincipal()
	{
		
		this.top10=new Top10();
		
		setSize( 800, 720 );
        setTitle( "Lights Out" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        
        setLayout( new BorderLayout( ) );
        
        pNorte = new PanelNorte( );
        add(pNorte, BorderLayout.NORTH);
        
        //nuevo juego
        this.tablero=new Tablero(5);
        
        
        pSur = new PanelSur();
        add(pSur, BorderLayout.SOUTH);
        
        pEste = new PanelEste(this);
        add(pEste, BorderLayout.EAST);
        
        pCentro = new PanelCentro(tablero);
        add(pCentro,BorderLayout.CENTER);
        
		
		
		
	}
	
	public void iniciarJuego()
	{
		this.tablero=new Tablero(pNorte.darTamanioTablero());
        this.tablero.desordenar(pNorte.darDificultad());
        
        pCentro = new PanelCentro(tablero);
        add(pCentro,BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args) 
	{
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setResizable( false );
		ventana.setVisible( true );
		
		
	}
	
}
