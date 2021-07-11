package pck01;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class CaminhoPacote extends Thread
{
	
    public Vertice saida;
    public Vertice chegada;
    public JLabel origem;
    public JLabel destino;
    public JTextPane log1;
    public JTextPane log2;
    public ArrayList<Vertice> caminho;
    private int count = 0 ;

    @Override
    public void run() {
        try
        {
            count++;
            log1.setText(log1.getText()+"  ["+count+"] "+saida.nome+" - "+saida.distanciaMinima+"\r\n");
            for (Vertice vertice : caminho) 
            {

                Thread.sleep(500);
                if (!vertice.equals(saida))
                    origem.setBounds(vertice.x-38, vertice.y-93, 100, 100);

                if (!vertice.equals(saida) && !vertice.equals(chegada))
                {
                    if (count <= 15)
                        log1.setText(log1.getText()+"  ["+count+"] "+vertice.nome+" - "+vertice.distanciaMinima+"\r\n");
                    else
                        log2.setText(log2.getText()+"  ["+count+"] "+vertice.nome+" - "+vertice.distanciaMinima+"\r\n");
                }

                count++;

            }

            destino.setVisible(false);
            origem.setVisible(false);

            if (count <= 15)
                log1.setText(log1.getText()+"  ["+count+"] "+chegada.nome+" - "+chegada.distanciaMinima+"\r\n");
            else
                log2.setText(log2.getText()+"  ["+count+"] "+chegada.nome+" - "+chegada.distanciaMinima+"\r\n");

            Thread.interrupted();

            JOptionPane.showMessageDialog(null, "PACOTE CHEGOU NO DESTINO COM SUCESSO.");

        }
        catch(Exception e)
        {
            Thread.interrupted();
            e.printStackTrace();
        }
    }

}
