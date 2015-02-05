import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

// Classe Elipse
// subclasse de Figura
public class Elipse extends Figura {

	@Override
	public void Desenha(Graphics2D g2d) {
	
		// Operacoes nas Coordenadas
		int AcimaX = Math.min(getX1(), getX2());
		int AcimaY = Math.min(getY1(), getY2());
				
		int Largura = Math.abs( getX1() - getX2() );
		int Altura = Math.abs( getY1() - getY2());
				
		
		if (isFill() == true){

			// Desenha COM preenchimento
			g2d.setPaint(getCor());
			g2d.fill( new Ellipse2D.Double (AcimaX, AcimaY, Largura, Altura));
		
		}else{

			// Desenha SEM preenchimento
			g2d.setPaint(getCor());
			
			// Espessura da Elipse
			g2d.setStroke( new BasicStroke(getEspessura()));
			g2d.draw( new Ellipse2D.Double (AcimaX, AcimaY, Largura, Altura));
		}
	}
	
	// Construtor sem parametros
	public Elipse(){
		
		this( 0, 0, 0, 0, Color.BLACK, false, 0.0f);		
	}

	// Construtor Com Parametros
	public Elipse(int NewX1, int NewX2, int NewY1, int NewY2, Color NewColor, boolean NewFill, float NewEspessura){

		// Invoca Construtor de Figura
		super(NewX1, NewX2, NewY1,NewY2, NewColor, NewFill, NewEspessura);	
	}
}
