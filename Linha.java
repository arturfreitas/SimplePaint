import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

// Classe Linha 
// subclasse de Figura
public class Linha extends Figura{

	// Desenha Linha
	@Override
	public void Desenha(Graphics2D g2d) {
	
		// Desenha Linha
		g2d.setPaint(getCor());
		
		// Espessura da Linha
		g2d.setStroke( new BasicStroke(getEspessura()));
		g2d.draw( new Line2D.Double(getX1(), getY1(), getX2(), getY2()));
	}

	// Construtor sem Parametros
	public Linha(){
		
		 this( 0, 0, 0, 0, Color.BLACK, false, 0.0f);
	}

	// Construtor com Parametros	
	public Linha(int NewX1, int NewX2, int NewY1, int NewY2, Color NewColor, boolean NewFill, float NewEspessura){
		
		super(NewX1, NewX2, NewY1,NewY2, NewColor, NewFill, NewEspessura);		
	}
}
