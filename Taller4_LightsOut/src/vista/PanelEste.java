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

public class PanelEste extends JPanel implements ActionListener {

	private VentanaPrincipal vPrincipal;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarJugador;
	
	public PanelEste (VentanaPrincipal vPrincipal)
	{
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
		
		add(new JLabel(" "));
		
		btnTop10 = new JButton("VER TOP 10");
		btnTop10.setForeground(Color.WHITE);
		btnTop10.setBackground(new Color(48,140,228));
		add(btnTop10);
		
		add(new JLabel(" "));
		
		btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setForeground(Color.WHITE);
		btnCambiarJugador.setBackground(new Color(48,140,228));
		add(btnCambiarJugador);
		
		add(new JLabel(" "));
		add(new JLabel(" "));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand( ).equals( "NUEVO" ))
		{
			this.vPrincipal.iniciarJuego();
		}
		
	}
	
	
	


}
