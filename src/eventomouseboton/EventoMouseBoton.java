package eventomouseboton;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class EventoMouseBoton extends Frame{
   
    private Button boton;

    public EventoMouseBoton(){
        super("Mueve ventana");
        setLayout(new FlowLayout());
        addMouseMotionListener(new EscuchaMouse());
        boton = new Button("Boton");
        add(boton);
        
        setSize(200, 150);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new  EventoMouseBoton();
    }
    
    class EscuchaMouse implements MouseMotionListener{
        public void mouseMoved(MouseEvent e){
            int distancia = 10;
            Point pMouse = e.getPoint();
            
            Dimension dimBoton = boton.getSize();
            Point pBoton = boton.getLocation();
            
            int difX1 = Math.abs(pBoton.x-pMouse.x);
            int difX2 = Math.abs((pBoton.x+dimBoton.width)-pMouse.x);
            
            int difY1 = Math.abs(pBoton.y-pMouse.y);
            int difY2 = Math.abs((pBoton.y+dimBoton.height)-pMouse.y);
            
            if(difX1 < distancia || difX2 < distancia || difY1 < distancia ||difY2 < distancia){
                Dimension dimVentana = getSize();
                Dimension dimScreen = getToolkit().getScreenSize();
                
                int y = (int)(Math.random()*(dimScreen.height-dimVentana.height));
                int x = (int)(Math.random()*(dimScreen.width-dimVentana.width));
                
                setLocation(x, y);
            }
        }
        
        public void mouseDragged(MouseEvent e){}
    }
}
