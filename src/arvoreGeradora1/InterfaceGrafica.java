package arvoreGeradora1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceGrafica extends JFrame implements Observer, ActionListener {
	private JButton button_jbutton;
	private JPanel grafo_jpanel;
	private JPanel painelOP;
	private AGMKruskal kruskal;
	private boolean flag = true;

	public InterfaceGrafica() throws FileNotFoundException {
            
//                define os parametros iniciais da janela
		this.setSize(1350, 730);
		this.setTitle("Rotas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);

                
		grafo_jpanel = new GraphPanel();

		this.button_jbutton = new JButton();
		this.button_jbutton.setBounds(650, 600, 100, 50);
		this.button_jbutton.setText("Next");
		this.button_jbutton.addActionListener(this);

     
		this.add(button_jbutton);
		this.add(grafo_jpanel);

		this.kruskal = new AGMKruskal();
		this.kruskal.addObserver(this);

		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.repaint();
	}

	public void actionPerformed(ActionEvent evento) {
		Thread thread = new Thread(this.kruskal);
		thread.start();
	}

}