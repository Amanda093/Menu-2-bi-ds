import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calculadora extends JDialog{
        JButton voltar, limpar, calc;
        JLabel rotulo1,rotulo2,rotulo3,resultado;
        JTextField texto1,texto2;
        
        public Calculadora(Frame owner, String title, boolean modal){
        super(owner,title,modal);
        Container tela2 = getContentPane();
        tela2.setLayout(null);
        
        // Icones 
        ImageIcon icone = new ImageIcon("image/menu.png");
        setIconImage(icone.getImage());
        
        // layout do formulário
        rotulo1 = new JLabel("1º Número: "); rotulo2 = new JLabel("2º Número: ");
        texto1 = new JTextField(5); texto2 = new JTextField(5);
        rotulo3 = new JLabel("Resultado: "); resultado = new JLabel("");
        calc = new JButton("Calcular");
        voltar = new JButton("Voltar"); limpar = new JButton("Limpar");
        
        rotulo1.setBounds(50,20,100,20); rotulo2.setBounds(50,50,100,20);
        texto1.setBounds(120,20,200,20); texto2.setBounds(120,50,200,20);
        rotulo3.setBounds(50,80,100,20); resultado.setBounds(120,80,200,20); 
        calc.setBounds(50,115,100,20);
        voltar.setBounds(160,115,80,20);
        limpar.setBounds(250,115,80,20);
        
        calc.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                double number1, number2, result;
                number1 = Integer.parseInt(texto1.getText());
                number2 = Integer.parseInt(texto2.getText());
                result = 0;
            
                if(title == "Adição")
                result = number1 + number2;
                if(title == "Subtração")
                result = number1 - number2;
                if(title == "Multiplicação")
                result = number1 * number2;
                if(title == "Divisão")
                result = number1 / number2;
            
                resultado.setText("" + result);
                resultado.setVisible(true);
                }
            }
        );
        limpar.addActionListener(
            new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    texto1.setText(null);
                    texto2.setText(null);
                    resultado.setVisible(false);
                }
            }
        );
        voltar.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                tela2.setVisible(false);
                dispose();
                }
            }
        );
        
        tela2.add(rotulo1);
        tela2.add(rotulo2);
        tela2.add(texto1);
        tela2.add(texto2);
        tela2.add(rotulo3);
        tela2.add(resultado);
        tela2.add(calc);
        tela2.add(voltar);
        tela2.add(limpar);
        
        setSize(400,200);
        setResizable(false);
        setLocationRelativeTo(null);
        }
}