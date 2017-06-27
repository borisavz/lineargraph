package lineargraph;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LinearGraph {
    public static void main(String[] args) {
        JFrame window = new JFrame("LinearGraph");
        final JLabel setK = new JLabel("k = "), setN = new JLabel("n = ");
        JButton draw = new JButton("Draw"), clear = new JButton("Clear");
        final JComboBox func = new JComboBox();
        final JTextArea inputK = new JTextArea(), inputN = new JTextArea();
        final Graph graph = new Graph();
        window.setPreferredSize(new Dimension(550, 450));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(null);
        func.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean en = (Graph.func = func.getSelectedIndex()) != 1;
                if(!en)
                    inputK.setText("");
                inputK.setEnabled(en);
                setK.setEnabled(en);
            }
        });
        func.addItem("y = k*x + n");
        func.addItem("y = |x + n|");
        func.setBounds(420, 5, 100, 20);
        draw.setBounds(420, 300, 70, 30);
        clear.setBounds(420, 350, 70, 30);
        graph.setBounds(5, 5, 401, 401);
        inputK.setBounds(460, 100, 70, 30);
        inputN.setBounds(460, 150, 70, 30);
        setK.setBounds(420, 100, 30, 30);
        setN.setBounds(420, 150, 30, 30);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graph.drawGraph = false;
                graph.repaint();
            }
        });
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graph.drawGraph = true;
                try {
                    Graph.n = Integer.parseInt(inputN.getText());
                } catch(NumberFormatException ne) {
                    inputN.setText("0");
                    Graph.n = 0;
                }
                try {
                    Graph.k = Integer.parseInt(inputK.getText());
                } catch(NumberFormatException ne) {
                    if(Graph.func != 1)
                        inputK.setText("1");
                    Graph.k = 1;
                }
                graph.repaint();
            }
        });
        window.add(graph);
        window.add(func);
        window.add(draw);
        window.add(clear);
        window.add(inputK);
        window.add(inputN);
        window.add(setK);
        window.add(setN);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
