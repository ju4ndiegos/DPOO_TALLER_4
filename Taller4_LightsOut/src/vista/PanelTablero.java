package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTablero extends JPanel implements MouseListener{

	private Tablero tablero;
	private VentanaPrincipal vPrincipal;
	private boolean puedeGanar;
	
	public PanelTablero(Tablero tablero,VentanaPrincipal vPrincipal)
	{	setBorder(new EmptyBorder(2, 2, 2, 1));
		setBackground(new Color(255,253,247));
		this.tablero=tablero;
		addMouseListener( this );
		
		this.vPrincipal = vPrincipal;
		this.puedeGanar=false;
		
		setSize( 630, 630 );
	}
	
	public void actualizarTablero(Tablero tablero)
	{
		this.tablero=tablero;
		
//		addMouseListener( this );
		
		setSize( 630, 630 );
		this.repaint();
		this.puedeGanar=true;
	}
	

	
	public void paint(Graphics g)
    {
		boolean[][] tableroBoolean = this.tablero.darTablero();
        Graphics2D g2d = (Graphics2D) g;
        int ancho= 630;
        int alto= 630;
        int anchoRect= ancho/tableroBoolean.length;
        int altoRect= alto/tableroBoolean.length;
        for( int i = 0; i < tableroBoolean.length; i++ )
        {
            for( int j = 0; j < tableroBoolean.length; j++ )
            {
                Rectangle2D.Double rect= new Rectangle2D.Double( i*anchoRect , j*altoRect, anchoRect, altoRect );
                if(tableroBoolean[i][j]==true)
                {
                    g.setColor( new Color(240,246,0) );
                }
                else
                {
                    g.setColor(new Color(99,88,94) );
                }
                g2d.fill(rect);
                g.setColor( new Color(2,2,2) );
                g2d.draw( rect );
            	}
            }
        }
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	private int[] convertirCoordenadasACasilla(int x, int y)
    {
	boolean[][] tableroBoolean = this.tablero.darTablero();
	
	int columna=20;// si es 20 no se mueve
	int fila=20; 
	
    int ladoTablero = tableroBoolean.length;
    int altoPanelTablero = 630;
    int anchoPanelTablero = 630;
    int altoCasilla = altoPanelTablero / ladoTablero;
    int anchoCasilla = anchoPanelTablero / ladoTablero;
    
    if (x<altoPanelTablero)
    {fila = (int) (x / altoCasilla);}
    
    if (y<anchoPanelTablero)
    {columna = (int) (y / anchoCasilla);}
    
   
	return new int[] { fila, columna };
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
        int click_x = e.getX();
        //System.out.println("x "+click_x);
        int click_y = e.getY();
        //System.out.println("y "+click_y);
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        
        //System.out.println("casilla 0 "+casilla[0]+"casilla 1 "+casilla[1]);
        this.tablero.jugar(casilla[0], casilla[1]);
        repaint(0,0,630,630);
        
        this.vPrincipal.actualizarPuntos();
        
        if (tablero.tableroIluminado() && this.puedeGanar)
        {try {
			this.vPrincipal.gano();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
    }

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
