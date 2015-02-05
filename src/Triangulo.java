import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


// classe Triangulo
// subclasse de Figura
public class Triangulo extends Figura {
			
	@Override
	public void Desenha(Graphics2D g2d){
		
		// Operacoes nas Coordenadas
		// Sempre Sera um triangulo Retangulo
		
		int x[] = new int[3];
		int y[] = new int[3];
		
		x[0] = getX1();
		x[1] = getX2();
		x[2] = x[1];
		
		y[0] = getY1();
		y[1] = getY1();
		y[2] = getY2();
		
		
		if (isFill() == true){
			
			// Desenha COM preenchimento
			g2d.setPaint(getCor());
			g2d.fillPolygon(x, y, 3);			
			
		}else{

			// Desenha SEM preenchimento
			g2d.setPaint(getCor());
			
			// Espessura do Triangulo
			g2d.setStroke( new BasicStroke(getEspessura()));
			g2d.drawPolygon( x, y, 3);
		}
	}

	// Construtor sem parametros
	public Triangulo(){
		
		this( 0, 0, 0, 0, Color.BLACK, false, 0.0f);
	}

	// Construtor Com Parametros
	public Triangulo(int NewX1, int NewX2, int NewY1, int NewY2, Color NewColor, boolean NewFill, float NewEspessura){

		super(NewX1, NewX2, NewY1,NewY2, NewColor, NewFill, NewEspessura);	
	}
}
