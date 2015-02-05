import javax.swing.JFrame;


/**
 * 
 * Projeto 2 de SCC0604 - Programacao Orientada A Objetos
 *
 *		Turma : Engenharia de Computacao	
 * 
 * ****************************************************
 * 				Editor de Imagens					  *
 * 													  *
 * ****************************************************
 * 
 * Grupo :
 * 
 * 		Felipe Moreira Moura , n USP 8066461;
 * 		Pedro Morello Abbud	, n USP 8058718
 * 		Cristiano Jose dos Santos, n USP 8123040
 * 
 * @author felipe
 *
 */

public class Main {

	// Main
	public static void main( String args[] ){
		
		// Invoca Construtor de DesenhaFormas
		DesenhaFormas application = new DesenhaFormas();
		
		// Operacao de saida no exit
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	} 
		
}
