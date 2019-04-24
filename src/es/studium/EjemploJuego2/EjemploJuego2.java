package es.studium.EjemploJuego2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class EjemploJuego2 extends Frame implements WindowListener,
MouseListener
{
	private static final long serialVersionUID = 1L;
	// Las coordenadas del cuadrado
	int posX, posY;
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las vidas
	int vidas, puntos;
	Random rnd = new Random();
	public EjemploJuego2()
	{
		vidas = 3;
		// Obtener los valores iniciales del cuadrado
		obtenerPosicion();
		setTitle("Moviendo...");
		addWindowListener(this);
		addMouseListener(this);
		setSize(220,220);
		setVisible(true);
	}
	public void obtenerPosicion()
	{
		// Obtenemos los valores teniendo en cuenta los límites de escenario
		posX=rnd.nextInt(186)+8;
		posY=rnd.nextInt(160)+32;
	}
	public void paint(Graphics g)
	{
		String texto1="Puntos = "+puntos;
		String texto2="Vidas = "+vidas;
		g.drawRect(posX, posY, 20, 20);
		g.drawString(texto1,80,60);
		g.drawString(texto2,80,70);
		if(vidas==0) {
			g.drawString("Sin vidas FIN.exe",30,120);
		}
	}
	public void windowActivated(WindowEvent we) {}
	public void windowClosed(WindowEvent we) {}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
	public static void main(String[] args)
	{
		new EjemploJuego2();
	}
	public void mouseClicked(MouseEvent me)
	{
		// Obtenemos las coordenadas del lugar donde se ha pulsado con elratón
		pulX = me.getX();
		pulY = me.getY();
		// Comprobamos si las coordenadas del ratón están entre las del cuadrado
		if((posX<pulX)&&(pulX<posX+20)&&(posY<pulY)&&(pulY<posY+20))
		{
			System.out.println("Acertaste");
			puntos++;
			// Obtenemos una nueva posición del cuadrado
			obtenerPosicion();
			// Y lo dibujamos
			repaint();
		}
		else
		{
			vidas--;
			if(vidas==0)
			{
					// Deshabilitamos el MouseListener pues se haacabado el juego
					//Y dibujamos el 0 vidas
						this.removeMouseListener(this);
						repaint();
			}
			else
			{
				//Dibujamos que le quitamos la vida
				repaint();
			}
		}
	}
	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
}
