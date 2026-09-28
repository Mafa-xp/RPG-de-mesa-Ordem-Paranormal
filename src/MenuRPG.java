import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MenuRPG {
    // VARIÁVEIS GLOBAIS DO AGENTE (Acessadas por todas as abas)
    private static String nomeDoAgente = "Thiago Fritz";
    private static int nexDoAgente = 20;

    private static int vidaAtual = 20, vidaMaxima = 20;
    private static int peAtual = 5, peMaximo = 5;
    private static int sanidadeAtual = 15, sanidadeMaxima = 15;

    // Componentes visuais que precisam atualizar em tempo real
    private static JLabel labelNomeExibido;
    private static JLabel labelVida;
    private static JLabel labelPE;
    private static JLabel labelSanidade;

    public static void main(String[] args) {
        // 1. Configuração da Janela Principal
        JFrame janela = new JFrame("Ordem Paranormal - Painel do Agente");
        janela.setSize(500, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        // O SEGREDO: Sistema de Abas
        JTabbedPane abas = new JTabbedPane();
        abas.setBackground(Color.DARK_GRAY);
        abas.setForeground(Color.WHITE);

        // 2. CONSTRUINDO A ABA 1: ALTERAR PERSONAGEM
        JPanel abaCriacao = new JPanel();
        abaCriacao.setBackground(new Color(20, 20, 20));
        abaCriacao.setLayout(new BoxLayout(abaCriacao, BoxLayout.Y_AXIS));
        abaCriacao.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titCriacao = new JLabel("MODIFICAR AGENTE");
        titCriacao.setFont(new Font("Arial", Font.BOLD, 18));
        titCriacao.setForeground(new Color(200, 30, 30));
        titCriacao.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblNomeInput = new JLabel("Nome do Agente:");
        lblNomeInput.setForeground(Color.WHITE);
        lblNomeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField txtNomeInput = new JTextField(nomeDoAgente, 15);
        txtNomeInput.setMaximumSize(new Dimension(200, 30));

        JLabel lblNexInput = new JLabel("NEX (% de Exposição):");
        lblNexInput.setForeground(Color.WHITE);
        lblNexInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField txtNexInput = new JTextField(String.valueOf(nexDoAgente), 5);
        txtNexInput.setMaximumSize(new Dimension(80, 30));

        JButton btnSalvar = new JButton("ATUALIZAR AGENTE");
        btnSalvar.setBackground(new Color(40, 40, 40));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setAlignmentX(Component.CENTER_ALIGNMENT);

        abaCriacao.add(titCriacao);
        abaCriacao.add(Box.createRigidArea(new Dimension(0, 20)));
        abaCriacao.add(lblNomeInput);
        abaCriacao.add(txtNomeInput);
        abaCriacao.add(Box.createRigidArea(new Dimension(0, 15)));
        abaCriacao.add(lblNexInput);
        abaCriacao.add(txtNexInput);
        abaCriacao.add(Box.createRigidArea(new Dimension(0, 25)));
        abaCriacao.add(btnSalvar);


        // 3. CONSTRUINDO A ABA 2: FICHA DE STATUS
        JPanel abaFicha = new JPanel();
        abaFicha.setBackground(new Color(15, 15, 15));
        abaFicha.setLayout(new BoxLayout(abaFicha, BoxLayout.Y_AXIS));
        abaFicha.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        labelNomeExibido = new JLabel("Agente: " + nomeDoAgente + " | NEX: " + nexDoAgente + "%");
        labelNomeExibido.setFont(new Font("Arial", Font.ITALIC, 16));
        labelNomeExibido.setForeground(Color.LIGHT_GRAY);
        labelNomeExibido.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Status Vida
        labelVida = new JLabel("PONTOS DE VIDA (PV): " + vidaAtual + " / " + vidaMaxima);
        labelVida.setForeground(new Color(46, 204, 113));
        labelVida.setFont(new Font("Arial", Font.BOLD, 14));
        labelVida.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel pnlVida = new JPanel(); pnlVida.setBackground(new Color(15, 15, 15));
        JButton btnMenosPV = new JButton("-1 PV"); JButton btnMaisPV = new JButton("+1 PV");
        pnlVida.add(btnMenosPV); pnlVida.add(btnMaisPV);

        // Status PE
        labelPE = new JLabel("PONTOS DE ESFORÇO (PE): " + peAtual + " / " + peMaximo);
        labelPE.setForeground(new Color(241, 196, 15));
        labelPE.setFont(new Font("Arial", Font.BOLD, 14));
        labelPE.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel pnlPE = new JPanel(); pnlPE.setBackground(new Color(15, 15, 15));
        JButton btnMenosPE = new JButton("-1 PE"); JButton btnMaisPE = new JButton("+1 PE");
        pnlPE.add(btnMenosPE); pnlPE.add(btnMaisPE);

        // Status Sanidade
        labelSanidade = new JLabel("SANIDADE (SAN): " + sanidadeAtual + " / " + sanidadeMaxima);
        labelSanidade.setForeground(new Color(155, 89, 182));
        labelSanidade.setFont(new Font("Arial", Font.BOLD, 14));
        labelSanidade.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel pnlSAN = new JPanel(); pnlSAN.setBackground(new Color(15, 15, 15));
        JButton btnMenosSAN = new JButton("-1 SAN"); JButton btnMaisSAN = new JButton("+1 SAN");
        pnlSAN.add(btnMenosSAN); pnlSAN.add(btnMaisSAN);

        abaFicha.add(labelNomeExibido);
        abaFicha.add(Box.createRigidArea(new Dimension(0, 20)));
        abaFicha.add(labelVida); abaFicha.add(pnlVida);
        abaFicha.add(Box.createRigidArea(new Dimension(0, 10)));
        abaFicha.add(labelPE); abaFicha.add(pnlPE);
        abaFicha.add(Box.createRigidArea(new Dimension(0, 10)));
        abaFicha.add(labelSanidade); abaFicha.add(pnlSAN);


        // 4. CONSTRUINDO A ABA 3: ROLAR DADOS
        JPanel abaDados = new JPanel();
        abaDados.setBackground(new Color(15, 15, 15));
        abaDados.setLayout(new BoxLayout(abaDados, BoxLayout.Y_AXIS));
        abaDados.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titDados = new JLabel("ROLANDO ATRIBUTOS");
        titDados.setFont(new Font("Arial", Font.BOLD, 18));
        titDados.setForeground(new Color(200, 30, 30));
        titDados.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblDadoInstrucao = new JLabel("Quantidade de dados (Atributo 0 a 5):");
        lblDadoInstrucao.setForeground(Color.WHITE);
        lblDadoInstrucao.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField txtDadoAtributo = new JTextField("1", 5);
        txtDadoAtributo.setMaximumSize(new Dimension(60, 30));
        txtDadoAtributo.setHorizontalAlignment(JTextField.CENTER);
        txtDadoAtributo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnRolar = new JButton("DISPARAR GATILHO");
        btnRolar.setBackground(Color.DARK_GRAY);
        btnRolar.setForeground(Color.WHITE);
        btnRolar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblDadosSorteados = new JLabel("Resultados: -");
        lblDadosSorteados.setForeground(Color.LIGHT_GRAY);
        lblDadosSorteados.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblResultadoMaior = new JLabel("-");
        lblResultadoMaior.setFont(new Font("Arial", Font.BOLD, 55));
        lblResultadoMaior.setForeground(Color.WHITE);
        lblResultadoMaior.setAlignmentX(Component.CENTER_ALIGNMENT);

        abaDados.add(titDados);
        abaDados.add(Box.createRigidArea(new Dimension(0, 15)));
        abaDados.add(lblDadoInstrucao);
        abaDados.add(txtDadoAtributo);
        abaDados.add(Box.createRigidArea(new Dimension(0, 15)));
        abaDados.add(btnRolar);
        abaDados.add(Box.createRigidArea(new Dimension(0, 25)));
        abaDados.add(lblDadosSorteados);
        abaDados.add(lblResultadoMaior);


        // ==========================================
        // LÓGICAS E CLIQUES
        // ==========================================

        // Ação de Salvar o Nome/NEX (Aba 1 afeta Aba 2!)
        btnSalvar.addActionListener(e -> {
            nomeDoAgente = txtNomeInput.getText().trim();
            try {
                nexDoAgente = Integer.parseInt(txtNexInput.getText().trim());
                labelNomeExibido.setText("Agente: " + nomeDoAgente + " | NEX: " + nexDoAgente + "%");
                JOptionPane.showMessageDialog(janela, "Dados do agente atualizados com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "NEX precisa ser um número inteiro!");
            }
        });

        // Cliques dos botões de ficha (Aba 2)
        btnMenosPV.addActionListener(e -> {
            if (vidaAtual > 0) vidaAtual--;
            labelVida.setText("PONTOS DE VIDA (PV): " + vidaAtual + " / " + vidaMaxima);
            if (vidaAtual == 0) JOptionPane.showMessageDialog(janela, "O Agente caiu!");
        });
        btnMaisPV.addActionListener(e -> {
            if (vidaAtual < vidaMaxima) vidaAtual++;
            labelVida.setText("PONTOS DE VIDA (PV): " + vidaAtual + " / " + vidaMaxima);
        });
        btnMenosPE.addActionListener(e -> { if (peAtual > 0) peAtual--; labelPE.setText("PONTOS DE ESFORÇO (PE): " + peAtual + " / " + peMaximo); });
        btnMaisPE.addActionListener(e -> { if (peAtual < peMaximo) peAtual++; labelPE.setText("PONTOS DE ESFORÇO (PE): " + peAtual + " / " + peMaximo); });

        btnMenosSAN.addActionListener(e -> {
            if (sanidadeAtual > 0) sanidadeAtual--;
            labelSanidade.setText("SANIDADE (SAN): " + sanidadeAtual + " / " + sanidadeMaxima);
            if (sanidadeAtual == 0) JOptionPane.showMessageDialog(janela, "O Agente enlouqueceu!");
        });
        btnMaisSAN.addActionListener(e -> {
            if (sanidadeAtual < sanidadeMaxima) sanidadeAtual++;
            labelSanidade.setText("SANIDADE (SAN): " + sanidadeAtual + " / " + sanidadeMaxima);
        });

        // Ação de Rolar os Dados (Aba 3)
        btnRolar.addActionListener(e -> {
            try {
                int atributo = Integer.parseInt(txtDadoAtributo.getText().trim());
                if (atributo < 0 || atributo > 5) {
                    JOptionPane.showMessageDialog(janela, "Atributos válidos apenas de 0 a 5.");
                    return;
                }
                Random dado = new Random();
                List<Integer> resultados = new ArrayList<>();
                int resFinal;

                if (atributo == 0) {
                    // Se for Atributo 0, rola dois dados e pega o menor
                    resultados.add(dado.nextInt(20) + 1);
                    resultados.add(dado.nextInt(20) + 1);
                    resFinal = Collections.min(resultados);
                } else {
                    // Se maior que 0, rola a quantidade do atributo e pega o maior
                    for (int i = 0; i < atributo; i++) {
                        resultados.add(dado.nextInt(20) + 1);
                    }
                    resFinal = Collections.max(resultados);
                }

                // Atualiza a tela com o resultado
                lblDadosSorteados.setText("Resultados: " + resultados.toString());
                lblResultadoMaior.setText(String.valueOf(resFinal));

                // Se o maior dado for 20, fica vermelho (Crítico!)
                if (resFinal == 20) lblResultadoMaior.setForeground(Color.RED);
                else lblResultadoMaior.setForeground(Color.WHITE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Insira um número válido.");
            }
        });

        // 5. Adiciona as abas criadas no painel gerenciador
        abas.addTab("Criar Agente", abaCriacao);
        abas.addTab("Ficha de Status", abaFicha);
        abas.addTab("Rolar Dados", abaDados);

        // 6. Coloca as abas na janela principal e exibe
        janela.add(abas);
        janela.setVisible(true);
    }
}
