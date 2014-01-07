/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testaforcasenha;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.regex.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Pedro Cantarelli
 */

public class TestaForca extends javax.swing.JPanel {

    private String senha = "";
    private Matcher match;
    private Pattern padraoNumero = Pattern.compile("\\d+");
    private Pattern padraoLetrasMinusculas = Pattern.compile("[a-z]+");
    private Pattern padraoLetrasMaiuscula = Pattern.compile("[A-Z]+");
    private Pattern padraoSimbolos = Pattern.compile("[!@#$%&*_]+");
    private int LetraMinusculamin = 0;
    private int LetraMinusculamax = 0;
    private int LetraMaiusculamin = 0;
    private int LetraMaiusculamax = 0;
    private int Numeromin = 0;
    private int Numeromax = 0;
    private int Simbolomin = 0;
    private int Simbolomax = 0;
    
    /** É usado para dar o numero minimo de Letras Minusculas disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  LetraMinusculamin int -  é a quantidade minima de letras minusculas possiveis na senha
    */
    public void setLetraMinusculamin(int LetraMinusculamin) {
        this.LetraMinusculamin = LetraMinusculamin;
    }
    /** É usado para dar o numero maximo de Letras Minusculas disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  LetraMinusculamax int -  é a quantidade maxima de letras minusculas possiveis na senha
    */      
    public void setLetraMinusculamax(int LetraMinusculamax) {
        this.LetraMinusculamax = LetraMinusculamax;
    }
    /** É usado para dar o numero minimo de Letras Maiusculas disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  LetraMaiusculamin int -  é a quantidade minima de letras maiusculas possiveis na senha
    */
    public void setLetraMaiusculamin(int LetraMaiusculamin) {
        this.LetraMaiusculamin = LetraMaiusculamin;
    }
    /** É usado para dar o numero maximo de Letras Maiusculas disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  LetraMaiusculamax int -  é a quantidade maxima de letras maiuscula possiveis na senha
    */    
    public void setLetraMaiusculamax(int LetraMaiusculamax) {
        this.LetraMaiusculamax = LetraMaiusculamax;
    }
    /** É usado para dar a quantidade de Numeros minimos disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  Numeromin int -  é a quantidade minima de numeros possiveis na senha
    */
    public void setNumeromin(int Numeromin) {
        this.Numeromin = Numeromin;
    }
    /** É usado para dar a quantidade de Numeros maximo disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  Numeromax int -  é a quantidade maxima de numeros possiveis na senha
    */
    public void setNumeromax(int Numeromax) {
        this.Numeromax = Numeromax;
    }
    /** É usado para dar a quantidade de Simbolos minimos disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  Simbolomin int -  é a quantidade minimo de simbolos possiveis na senha
    */
    public void setSimbolomin(int Simbolomin){
        this.Simbolomin=Simbolomin;
    }
    /** É usado para dar a quantidade de Simbolos maximo disponiveis pelo Sistema
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @param  Simbolomax int -  é a quantidade maxima de simbolos possiveis na senha
    */
    public void setSimboloMax(int Simbolomax){
        this.Simbolomax=Simbolomax;
    }
    /** É usado para receber a quantidade maxima de Letras Maiusculas foi escolhido.
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @return - Quantidade de Letras Maiusculas maximas.
    */
    public int getLetraMaiusculamax(){return LetraMaiusculamax;}
    /** É usado para receber a quantidade minima de Letras Maiusculas foi escolhido.
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @return - Quantidade de Letras Maiusculas minimas.
    */
    public int getLetraMaiusculamin(){return LetraMaiusculamin;}
    /** É usado para receber a quantidade maxima de Letras Minusculas foi escolhido.
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @return - Quantidade de letras Minusculas maximas.
    */
    public int getLetraMinusculamax(){return LetraMinusculamax;}
    /** É usado para receber a quantidade minima de Letras Minusculas foi escolhido.
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @return - Quantidade de Letras Minusculas minimas.
    */
    public int getLetraMinusculamin(){return LetraMinusculamin;}
    /** É usado para receber a quantidade maxima de Numeros foi escolhido.
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @return - Quantidade de Numeros maximos.
    */
    public int getNumeroMax(){return Numeromax;}
    /** É usado para receber a quantidade minima de Numeros foi escolhido.
	   Nota: Pode ser setado pelas propriedades do JPanel
    * @return - Quantidade de Numeros minimos.
    */
    public int getNumeroMin(){return Numeromin;}
    
    
           
    /**
     * Creates new form TestaForca
     */
    public TestaForca() {
        initComponents();
        Listener l = new Listener();
        jTextSenha.addKeyListener(l);
        jProgress.setMaximum(100);
        jProgress.setMinimum(1);
        jProgress.setStringPainted(true);
        jProgress.setString("0%");


    }

    private void atualizaProgresso(String senha) {
        int cont = 0;
        int qtd = 100 / (LetraMaiusculamax + LetraMinusculamax + Numeromax + Simbolomax);

        int quantidadeLetrasMinusculas = 0;
        int quantidadeLetrasMaiusculas = 0;
        int quantidadeNumeros = 0;
        int quantidadeSimbolos = 0;


        //LETRAMAIUSCULA
        if (LetraMaiusculamax > 0) {
            match = padraoLetrasMaiuscula.matcher(senha);
            while (match.find()) {
                quantidadeLetrasMaiusculas += match.group().length();

            }
            if (quantidadeLetrasMaiusculas > LetraMaiusculamax) {
                quantidadeLetrasMaiusculas = LetraMaiusculamax;
            }
            cont += quantidadeLetrasMaiusculas * qtd;

        }

        //LETRA MINUSCULA
        if (LetraMinusculamax > 0) {
            match = padraoLetrasMinusculas.matcher(senha);
            while (match.find()) {
                quantidadeLetrasMinusculas += match.group().length();
            }
            if (quantidadeLetrasMinusculas > LetraMinusculamax) {
                quantidadeLetrasMinusculas = LetraMinusculamax;
            }
            cont += quantidadeLetrasMinusculas * qtd;

        }

        //NUMEROS
        if (Numeromax > 0) {
            match = padraoNumero.matcher(senha);
            while (match.find()) {
                quantidadeNumeros += match.group().length();
            }
            if (quantidadeNumeros > Numeromax) {
                quantidadeNumeros = Numeromax;
            }
            cont += quantidadeNumeros * qtd;

        }
        //SIMBOLOS
        if (Simbolomax > 0) {
            match = padraoSimbolos.matcher(senha);
            while (match.find()) {
                quantidadeSimbolos += match.group().length();
            }
            System.out.println("quantidade: "+quantidadeSimbolos);
            if (quantidadeSimbolos > Simbolomax) {
                quantidadeSimbolos = Simbolomax;
            }
            cont += quantidadeSimbolos * qtd;

        }
        jProgress.setValue(cont);
        jProgress.setString(cont + "%");
        System.out.println(jProgress.getString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextSenha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jProgress = new javax.swing.JProgressBar();

        jLabel1.setText("jLabel1");

        jTextSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSenhaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Força da Senha"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSenhaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgress;
    private javax.swing.JPasswordField jTextSenha;
    // End of variables declaration//GEN-END:variables

    class Listener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent evt) {
        }

        @Override
        public void keyReleased(KeyEvent evt) {
            if ((evt.getKeyCode() >= 33 && evt.getKeyCode() <= 125)) {
                senha = jTextSenha.getText();
                atualizaProgresso(senha);

            }
            else if (evt.getKeyCode() == evt.VK_BACK_SPACE && senha.length() > 0) {
                senha = jTextSenha.getText();
                atualizaProgresso(senha);
            }
            System.out.println(senha);
        }
    }
}
