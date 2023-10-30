package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMenu extends JPanel implements ActionListener {

	private VentanaPrincipal vPrincipal;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarJugador;
	
	public PanelMenu (VentanaPrincipal vPrincipal)
	{
		setBorder(new EmptyBorder(5, 0, 5, 3));
		setBackground(new Color(255,253,247));
		
		
		this.vPrincipal =vPrincipal;
		setLayout(new GridLayout( 11, 1 ));
		add(new JLabel(" "));
		add(new JLabel(" "));
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(new Color(48,140,228));
		add(btnNuevo);
		btnNuevo.addActionListener( this );
		btnNuevo.setActionCommand( "NUEVO" );
		
		add(new JLabel(" "));
		
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setBackground(new Color(48,140,228));
		add(btnReiniciar);
		btnReiniciar.setActionCommand( "REINICIAR" );
		btnReiniciar.addActionListener( this );
		
		add(new JLabel(" "));
		
		btnTop10 = new JButton("VER TOP 10");
		btnTop10.setForeground(Color.WHITE);
		btnTop10.setBackground(new Color(48,140,228));
		add(btnTop10);
		btnTop10.setActionCommand( "TOP_10" );
		btnTop10.addActionListener( this );
		add(new JLabel(" "));
		
		btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setForeground(Color.WHITE);
		btnCambiarJugador.setBackground(new Color(48,140,228));
		add(btnCambiarJugador);
		btnCambiarJugador.setActionCommand( "CAMBIAR_JUGADOR" );
		btnCambiarJugador.addActionListener( this );
		
		add(new JLabel(" "));
		add(new JLabel(" "));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand( ).equals( "NUEVO" ))
		{
			this.vPrincipal.iniciarJuego();
			
		}
		if(e.getActionCommand( ).equals( "REINICIAR" ))
		{
			this.vPrincipal.reiniciarJuego();
		}
		if(e.getActionCommand( ).equals( "TOP_10" ))
		{
			this.vPrincipal.darTop10();
		}
		if(e.getActionCommand( ).equals( "CAMBIAR_JUGADOR" ))
		{
			this.vPrincipal.cambiarJugador();
		}
		
	}
	
	
	


}
