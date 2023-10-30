package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class PanelOpcionesTablero extends JPanel implements ItemListener {

	
	private JLabel lblTamanio;
	private JComboBox<String> cBoxTamanios;
	private JLabel lblDificultad;
	
	private ButtonGroup grupoDificultad;
	
	private int tamanioTablero =5;
	private int dificultad=5;
	
	
	
	public PanelOpcionesTablero()
	{
		setBorder(new EmptyBorder(0, 0, 2, 0));	
		setLayout(new GridLayout( 1, 8,30,0 ));
		
		add(new JLabel(" "));
		
		lblTamanio= new JLabel( "Tamaño:" );
		lblTamanio.setFont(VentanaPrincipal.darFuente());
		lblTamanio.setForeground(Color.WHITE);
        add(lblTamanio);
        
        
        cBoxTamanios = new JComboBox<String>();
        cBoxTamanios.addItem("5x5");
        cBoxTamanios.addItem("7x7");
        cBoxTamanios.addItem("9x9");
        
        cBoxTamanios.addItemListener(this);
        add(cBoxTamanios);
        
        
        JRadioButton rbtnFacil;
    	JRadioButton rbtnMedio;
    	JRadioButton rbtnDificil;
        
        lblDificultad = new JLabel ("Dificultad:");
        lblDificultad.setForeground(Color.WHITE);
        lblDificultad.setFont(VentanaPrincipal.darFuente());
        add(lblDificultad);
        
        rbtnFacil = new JRadioButton("Fácil");
        rbtnFacil.setBackground(new Color(48,140,228));
        rbtnFacil.setForeground(Color.WHITE);
        rbtnFacil.setFont(VentanaPrincipal.darFuente());
        rbtnFacil.setSelected(true);
        
        rbtnMedio = new JRadioButton("Medio");
        rbtnMedio.setBackground(new Color(48,140,228));
        rbtnMedio.setFont(VentanaPrincipal.darFuente());
        rbtnMedio.setForeground(Color.WHITE);
        
        rbtnDificil = new JRadioButton("Difícil");
        rbtnDificil.setBackground(new Color(48,140,228));
        rbtnDificil.setFont(VentanaPrincipal.darFuente());
        rbtnDificil.setForeground(Color.WHITE);
        
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            	if (e.getItem() == rbtnFacil)
            	{
            		dificultad=5;
            	}
            	else if (e.getItem() == rbtnMedio)
            	{
            		dificultad=13;
            	}
            	else if(e.getItem() == rbtnDificil)
            	{
            		dificultad=23;
            	}
            }
        };
        grupoDificultad=new ButtonGroup();
        grupoDificultad.add(rbtnFacil);
        grupoDificultad.add(rbtnMedio);
        grupoDificultad.add(rbtnDificil);
        
        rbtnFacil.addItemListener(itemListener);
        rbtnMedio.addItemListener(itemListener);
        rbtnDificil.addItemListener(itemListener);
        
        add(rbtnFacil);
        add(rbtnMedio);
        add(rbtnDificil);
        
        add(new JLabel(" "));
        
        
        
        setBackground(new Color(48,140,228));
               	
		
	}
	
	public int darTamanioTablero()
	{
		return tamanioTablero;
	}
	public int darDificultad()
	{
		return dificultad;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==cBoxTamanios) {
            String seleccionado=(String)cBoxTamanios.getSelectedItem();
            //seleccionado es el tamaño del tablero 5x5, 7x7
            if (seleccionado == "5x5")
            {
            	this.tamanioTablero =5;
            }
            else if (seleccionado == "7x7")
            {
            	this.tamanioTablero =7;
            }
            else if (seleccionado == "9x9")
            {
            	this.tamanioTablero = 9;
            }
        }
		
	}
	
	

}
