import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Menu extends JFrame{
    JPopupMenu opcoes;
    JMenuBar bar;
    JMenu operacao,sobre,sair;
    JMenuItem sobre2,sair2,somar2,subtrair2,multiplicar2,dividir2;
    JToolBar bar2;
    JButton somar,subtrair,multiplicar,dividir,sair3;
    Calculadora JLoperacao;
    Sobre JLsobre;
    ImageIcon imagens[];

    public Menu() {
        super("Menu");
        Container tela = getContentPane();
        setLayout(null);
        
        // Icones
        ImageIcon icone = new ImageIcon("image/menu.png");
        setIconImage(icone.getImage());
        
        String icones[]={"image/adicao.png","image/subtracao.png",
                         "image/multiplicacao.png","image/divisao.png","image/sair3.png"};
        
        imagens = new ImageIcon[5];
        for(int i = 0; i < 5; i++){
            imagens[i] = new ImageIcon(icones[i]);
        }
        
        // MENU BAR
        bar = new JMenuBar();
        setJMenuBar(bar);
        
        // operações
        operacao = new JMenu("Operações"); bar.add(operacao);        
        somar2 = new JMenuItem("Adição"); operacao.add(somar2);
        subtrair2 = new JMenuItem("Subtração"); operacao.add(subtrair2);
        multiplicar2 = new JMenuItem("Multiplicação"); operacao.add(multiplicar2);
        dividir2 = new JMenuItem("Divisão"); operacao.add(dividir2);
        
         // sobre 
        sobre = new JMenu("Sobre");
        bar.add(sobre);
        
        // sair
        sair = new JMenu("Sair");
        bar.add(sair);
        
        // BUTTONS
        somar = new JButton(imagens[0]);
        subtrair = new JButton(imagens[1]);
        multiplicar = new JButton(imagens[2]);
        dividir = new JButton(imagens[3]);
        sair3 = new JButton(imagens[4]);
        
        bar2 = new JToolBar("Barra de Ferramentas");
        bar2.setBounds(1,1,260,50);
        bar2.setRollover(true);
        
        tela.add(bar2);
        bar2.add(somar); bar2.add(subtrair);
        bar2.add(multiplicar); bar2.add(dividir);
        bar2.add(sair3);
        // operacao.addSeparator(); Linha separadora
        
        // POPUP 
        opcoes = new JPopupMenu();
        sobre2 = new JMenuItem("Sobre"); opcoes.add(sobre2);
        sair2 = new JMenuItem("Sair"); opcoes.add(sair2);
        
        tela.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                if(e.isPopupTrigger())
                opcoes.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        );
        
        // ADIÇÃO
        somar.addActionListener(new ActionListener(){ // Toolbar
                public void actionPerformed(ActionEvent e){
                    Adicao(); } } );
        somar2.addActionListener(new ActionListener(){ // JMenuItem
                public void actionPerformed(ActionEvent e){
                    Adicao(); } } );
        
        // SUBTRAÇÃO
        subtrair.addActionListener(new ActionListener(){ // Toolbar
                public void actionPerformed(ActionEvent e){
                    Subtracao(); } } );
        subtrair2.addActionListener(new ActionListener(){ // JMenuItem
                public void actionPerformed(ActionEvent e){
                    Subtracao(); } } );
        
        // MULTIPLICAÇÃO
        multiplicar.addActionListener(new ActionListener(){ // Toolbar
                public void actionPerformed(ActionEvent e){
                    Multiplicacao(); } } );
        multiplicar2.addActionListener(new ActionListener(){ // JMenuItem
                public void actionPerformed(ActionEvent e){
                    Multiplicacao(); } } );
        
        //DIVISÃO 
        dividir.addActionListener(new ActionListener(){ // Toolbar
                public void actionPerformed(ActionEvent e){
                    Divisao(); } } );
        dividir2.addActionListener(new ActionListener(){ // JMenuItem
                public void actionPerformed(ActionEvent e){
                    Divisao(); } } );
        
        // SOBRE
        sobre.addMouseListener(new java.awt.event.MouseAdapter() { // JMenu
                public void mouseClicked(java.awt.event.MouseEvent events) {
                if(events.getButton() == MouseEvent.BUTTON1) {
                    Sobre(); } } } );
        sobre2.addActionListener(new ActionListener(){ // Popup
                public void actionPerformed(ActionEvent e){
                    Sobre(); } } );
        
        // SAIR
        sair.addMouseListener(new java.awt.event.MouseAdapter(){ // JMenu
                public void mouseClicked(java.awt.event.MouseEvent events){
                    if(events.getButton() == MouseEvent.BUTTON1) {
                        Sair(); } } } );
        
        sair2.addActionListener(new ActionListener(){ // Popup
                public void actionPerformed(ActionEvent e){
                    Sair(); } } );
        
        sair3.addActionListener(new ActionListener(){ // Toolbar
                public void actionPerformed(ActionEvent e){
                    Sair(); } } );
               
        // ToolTip
        somar2.setToolTipText("Adição (ALT + S)");
        subtrair2.setToolTipText("Subtração (ALT + U)");
        multiplicar2.setToolTipText("Multiplicação (ALT + M)");
        dividir2.setToolTipText("Divisão (ALT + D)");
        sair3.setToolTipText("Sair (ALT + A)");
        
        // Atalhos
        somar.setMnemonic(KeyEvent.VK_S);
        subtrair.setMnemonic(KeyEvent.VK_U);
        multiplicar.setMnemonic(KeyEvent.VK_M);
        dividir.setMnemonic(KeyEvent.VK_D);
        sair3.setMnemonic(KeyEvent.VK_A);
        
        setSize(500,400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        Menu app = new Menu();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class Sobre extends JDialog{
        JButton voltar;
        JLabel rotulo1,rotulo2,rotulo3;
        
        public Sobre(Frame owner, String title, boolean modal){
        super(owner,title,modal);
        Container tela1 = getContentPane();
        tela1.setLayout(null);
        
        // Icones 
        ImageIcon icone = new ImageIcon("image/menu.png");
        setIconImage(icone.getImage());
        
        rotulo1 = new JLabel("Amanda Farias da Rocha");
        rotulo2 = new JLabel("26/06/2024");
        rotulo3 = new JLabel("2º DS - AMS");
        voltar = new JButton("Voltar");
        
        rotulo1.setFont(new Font("Courier New",Font.BOLD,14));
        rotulo2.setFont(new Font("Courier New",Font.BOLD,14));
        rotulo3.setFont(new Font("Courier New",Font.BOLD,14));
        
        rotulo1.setBounds(40,20,500,20);
        rotulo2.setBounds(40,40,500,20);
        rotulo3.setBounds(40,60,500,20);
        voltar.setBounds(40,90,90,25);
        
        voltar.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
                tela1.setVisible(false);
                dispose();
                }
            }
        );
        
        tela1.add(rotulo1);
        tela1.add(rotulo2);
        tela1.add(rotulo3);
        tela1.add(voltar);
        
        setSize(300,170);
        setResizable(false);
        setLocationRelativeTo(null);
        }
    }
    public void Operacao(String nome){
        JLoperacao = new Calculadora(null,nome,true);
        JLoperacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLoperacao.setVisible(true);
    }
    public void Sobre(){
        JLsobre = new Sobre(null,"Sobre",true);
        JLsobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLsobre.setVisible(true);
    }
    public void Sair(){
        int option;
        Object[] botoes = { "Sim", "Não" };
            option = JOptionPane.showOptionDialog(null, "Deseja mesmo fechar a janela?", "Fechar", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botoes, botoes[0]);
                    
            if(option == JOptionPane.YES_OPTION)
                System.exit(0); 
    }
    public void Adicao(){
        Operacao("Adição"); }
    public void Subtracao(){
        Operacao("Subtração"); }
    public void Multiplicacao(){
        Operacao("Multiplicação"); }
    public void Divisao(){
        Operacao("Divisão"); } 
}