import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

// Classe Pincel
// SubClasse de Figura
public class Pincel extends Figura{
	
	// Pinta Pincel
	@Override
	public void Desenha(Graphics2D g2d) {		

		// Cor do Pincel
		g2d.setPaint(getCor());
		
		// Tamanho do Pincel relacionado com a espessura
		g2d.setStroke( new BasicStroke(getEspessura()));

		g2d.draw( new Line2D.Double(getX1(), getY1(), getX2(), getY2()));
	}
	
	// Construtor sem parametros
	public Pincel(){
		
		 this( 0, 0, 0, 0, Color.WHITE, false, 0.0f);
	}
	
	// Construtor Com Parametros
	public Pincel(int NewX1, int NewX2, int NewY1, int NewY2, Color NewColor, boolean NewFill, float NewEspessura){
		
		// Invoca Construtor de Figura
		super(NewX1, NewX2, NewY1,NewY2, NewColor, NewFill, NewEspessura);	
	}
}