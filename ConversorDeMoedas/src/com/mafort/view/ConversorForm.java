package com.mafort.view;

import com.mafort.controller.Conversor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;

public class ConversorForm extends JFrame implements ActionListener {
    private static final String[] MOEDAS_DISPONIVEIS = {"USD", "BRL","GBP","CHF","CAD", "EUR"};
    private static final int TAMANHO_COLUMN = 12;

    protected JLabel lblMoedaAtual;
    protected JComboBox<String> cmbOpcoesMoedaOrigem;
    protected JLabel lblMoedaConvertida;
    protected JComboBox<String> cmbOpcoesMoedaDestino;
    protected JLabel lblValor;
    protected JTextField txtValor;
    protected JPanel pnlBtns;
    protected JPanel pnlForm;
    protected JButton btnCalcular;
    protected JLabel lblResultado;
    protected JTextField txtResultado;

    public ConversorForm(){
        this.inicializar();
    }
    private void inicializar() {
        this.setTitle("Conversor de moedas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlForm(),BorderLayout.CENTER);
        this.getContentPane().add(getPnlBtns(),BorderLayout.PAGE_END);
        this.setResizable(false);
        this.pack();
    }

    public JPanel getPnlBtns(){
        if(pnlBtns == null){
            pnlBtns = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlBtns.setBackground(Color.decode("#fffcf2"));
            btnCalcular = new JButton("Calcular");
            btnCalcular.setBackground(Color.decode("#344e41"));
            btnCalcular.setForeground(Color.decode("#fffcf2"));
            btnCalcular.addActionListener(this);
            pnlBtns.add(btnCalcular);
        }
        return pnlBtns;
    }
    public JPanel getPnlForm(){
        if(pnlForm == null){
            pnlForm = new JPanel(new GridLayout(4,2));
            pnlForm.setBorder(new EmptyBorder(16, 16, 16, 16));
            pnlForm.setBackground(Color.decode("#fffcf2"));
            lblMoedaAtual = new JLabel("De:");
            cmbOpcoesMoedaOrigem = new JComboBox<>(MOEDAS_DISPONIVEIS);
            cmbOpcoesMoedaOrigem.setBackground(Color.decode("#fffcf2"));
            lblMoedaConvertida = new JLabel("Para:");
            cmbOpcoesMoedaDestino = new JComboBox<>(MOEDAS_DISPONIVEIS);
            cmbOpcoesMoedaDestino.setBackground(Color.decode("#fffcf2"));
            lblValor = new JLabel("Valor:");
            txtValor = new JTextField(TAMANHO_COLUMN);
            txtValor.setBackground(Color.decode("#fffcf2"));
            lblResultado = new JLabel("Resultado:");
            txtResultado = new JTextField(TAMANHO_COLUMN);
            txtResultado.setBackground(Color.decode("#fffcf2"));
            txtResultado.setEditable(false);

            pnlForm.add(lblMoedaAtual);
            pnlForm.add(cmbOpcoesMoedaOrigem);

            pnlForm.add(lblMoedaConvertida);
            pnlForm.add(cmbOpcoesMoedaDestino);

            pnlForm.add(lblValor);
            pnlForm.add(txtValor);

            pnlForm.add(lblResultado);
            pnlForm.add(txtResultado);
        }
        return pnlForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Conversor conversor = new Conversor();
        try {
            if(validar()){
                BigDecimal valorConvertido = conversor.converter((String) cmbOpcoesMoedaOrigem.getSelectedItem(),(String) cmbOpcoesMoedaDestino.getSelectedItem(),new BigDecimal(txtValor.getText()));
                String valorEmString = String.valueOf(valorConvertido);
                txtResultado.setText(valorEmString.replace(".",","));
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean validar(){
        if(txtValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha o valor!", "Erro ao coverter", JOptionPane.INFORMATION_MESSAGE,null);
            return false;
        }
        return true;
    }
}
