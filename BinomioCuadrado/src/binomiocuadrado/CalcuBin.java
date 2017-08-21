/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binomiocuadrado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Flores López - Soria Láscares
 * @version 1.0
 * 
 */
public class CalcuBin extends JFrame implements ActionListener{
    JLabel resul = new JLabel();
    JTextField first=new JTextField();
    JTextField second=new JTextField();
    JButton calcu = new JButton("Calcular");
    /**
     * Metodo Constructor
     * Inicializa el Frame
     */
    public CalcuBin(){
        Vent();
        Components();
    }
    /**
     * Metodo Ventana
     * Especifica las caraterísticas del Frame
     */
    public void Vent(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Binomio cuadrado");
        setLayout(null);
        setMinimumSize(new Dimension(500,500));
        setVisible(true);
        setLocationRelativeTo(null);
    }
    /**
     * Metodo componentes
     * Inicializa todos los componentes tanto los Campos de Texto y los Textos
     */
    public void Components(){
        first.setBounds(50, 50, 100, 50);
        add(first);
        second.setBounds(200, 50, 100, 50);
        add(second);
        calcu.setBounds(100, 200, 100, 50);
        calcu.addActionListener(this);
        add(calcu);
        resul.setBounds(100, 300, 200, 50);
        add(resul);
    }
    /**
     * Metodo Valida
     * Valida que la cadena introducida sea de numeros
     * @param val
     * @return 
     */
    public boolean Valida(String val){
        boolean ok = false;
        Pattern pat = Pattern.compile("[0-9]{1,7}");
        Matcher mat = pat.matcher(val);
        if(mat.matches()&&!val.equals("0")){
            ok=true;
        }
        return ok;
    }
    /**
     * Metodo Calcular
     * Es el que calcula el binomio cuadrado de los dos numeros ingresados en el respectivo orden
     * @param num1
     * @param num2 
     */
    public void Calcular(int num1,int num2){
        
        int abc,def,hij;
        abc = num1*num1;
        def=num2*num1*2;
        hij=num2*num2;
        int tot = abc+def+hij;
        resul.setText(String.valueOf(abc)+" + "+String.valueOf(def)+" + "+String.valueOf(hij)+" = "+String.valueOf(tot));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==calcu){
            if(Valida(first.getText())&&Valida(second.getText())){
                Calcular(Integer.parseInt(first.getText()),Integer.parseInt(second.getText()));
            }else{
                resul.setText("Caracteres incorrectos");
            }
        }
    }
}
