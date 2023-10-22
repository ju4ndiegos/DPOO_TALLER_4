package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelCentro extends JPanel implements MouseListener{

	private boolean[][] tablero;
	private Tablero objTablero;
	
	public PanelCentro(Tablero tablero)
	{
		this.tablero=tablero.darTablero();
		addMouseListener( this );
		objTablero=tablero;
		
		setSize( 630, 630 );
	}
	

	
	public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int ancho= 630;
        int alto= 630;
        int anchoRect= ancho/tablero.length;
        int altoRect= alto/tablero.length;
        for( int i = 0; i < tablero.length; i++ )
        {
            for( int j = 0; j < tablero.length; j++ )
            {
                Rectangle2D.Double rect= new Rectangle2D.Double( i*anchoRect , j*altoRect, anchoRect, altoRect );
                if(tablero[i][j]==true)
                {
                    g.setColor( Color.YELLOW );
                }
                else
                {
                    g.setColor( Color.GRAY );
                }
                g2d.fill(rect);
                g.setColor( Color.BLACK );
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
	
	int columna=20;// si es 20 no se mueve
	int fila=20; 
	
    int ladoTablero = tablero.length;
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
        objTablero.jugar(casilla[0], casilla[1]);
        repaint(0,0,630,630);
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
