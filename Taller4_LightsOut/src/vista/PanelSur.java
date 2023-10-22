package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSur extends JPanel {
	
	private JLabel lblJugadas;
	private JTextField txtJugadas;
	private JLabel lblJugador;
	private JTextField txtJugador;
	
	public PanelSur()
	{
		setLayout(new GridLayout( 1, 6,30,0 ));
		
		add(new JLabel(" "));
		
		lblJugadas= new JLabel( "Jugadas:" );
//		lblJugadas.setForeground(Color.WHITE);
        add(lblJugadas);
        
        txtJugadas = new JTextField("0");
        txtJugadas.setEditable(false);
        add(txtJugadas);
        
        lblJugador= new JLabel( "Jugador:" );
//		lblJugador.setForeground(Color.WHITE);
        add(lblJugador);
        
        txtJugador = new JTextField(" ");
        txtJugador.setEditable(false);
        add(txtJugador);
        
        add(new JLabel(" "));
        
        
        
        
		
	}

}
