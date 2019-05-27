package AGM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giandoso
 */
public class GraphPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public GraphPanel() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            DAO dao = new DAO();
            Graphics2D g2d = (Graphics2D) g;

            List<Aresta> arestas = DAO.g.getArestasOrdenadas();
            for (Aresta a : arestas) {
                int xOrigem = (int) DAO.g.lista_vertices.get(a.getOrigem()).getX() * 5;
                int yOrigem = (int) DAO.g.lista_vertices.get(a.getOrigem()).getY() * 5;
                int xDestino = (int) DAO.g.lista_vertices.get(a.getDestino()).getX() * 5;
                int yDestino = (int) DAO.g.lista_vertices.get(a.getDestino()).getY() * 5;
//                System.out.println(xOrigem + "\t\t" + yOrigem + "\t\t" + xDestino + "\t\t" + yDestino);
                g2d.setColor(Color.BLACK);
                g2d.drawLine(xOrigem, yOrigem, xDestino, yDestino);
            }
            
            g2d.setColor(Color.red);

            for (double[] tupla : Reader.tuplas) {
                g2d.fillOval((int) (tupla[0] - 1) * 5, (int) (tupla[1] - 1) * 5, 7, 7);
            }

        } catch (IOException ex) {
            Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
