<h2>1. 📌Comentário livro Software Engineering at Google - Primeiro parágrafo</h2>

<p>O texto diferencia programação, ciência da computação e engenharia de software, destacando que esta última aplica teoria e práticas de forma rigorosa para criar sistemas grandes e confiáveis. Embora o software hoje exige padrões mais robustos, dado seu papel crítico na sociedade. A experiência do Google com sistemas massivos oferece uma visão prática única sobre como alcançar essa maturidade.</p>

<h2>2. 📌Comentário livro Software Engineering at Google - Segundo parágrafo</h2>

<p>Esse segundo trecho amplia a definição de engenharia de software, deixando claro que ela não é só escrever código, mas também envolve processos, ferramentas e práticas que permitem manter esse código útil e sustentável ao longo do tempo.

O Google propõe a ideia de que engenharia de software é como “programação integrada ao longo do tempo”, ou seja, não basta o código funcionar hoje; ele precisa ser fácil de evoluir, corrigir e eventualmente aposentar.

O texto apresenta três princípios centrais para guiar decisões e práticas:
<p>1.	Tempo e Mudança – O código inevitavelmente precisará se adaptar a novas necessidades, tecnologias e requisitos ao longo de sua vida.</p>
<p>2.	Escala e Crescimento – À medida que a organização e o produto crescem, processos e arquitetura também precisam evoluir.</p>
<p>3.	Trade-offs e Custos – Decisões devem ser tomadas considerando os impactos no longo prazo e o equilíbrio entre vantagens e desvantagens.</p>

<h2>3. 📌3 exemplos comentados de trade-offs</h2>

<p>1.	Velocidade de entrega vs. Qualidade do código</p>
<p>•	Escolher entregar rapidamente pode ajudar a lançar uma funcionalidade no mercado, mas aumenta o risco de dívidas técnicas e problemas futuros.</p>
<p>•	Optar por investir mais tempo na qualidade reduz problemas a longo prazo, mas pode atrasar o lançamento.</p>

<p>2.	Performance vs. Legibilidade</p>
<p>•	Um código extremamente otimizado pode ser mais rápido, mas também mais complexo e difícil de entender.</p>
<p>•	Um código mais simples e legível é fácil de manter, mas pode não ser o mais eficiente em execução.</p>

<p>3.	Centralização vs. Descentralização de decisões técnicas</p>
<p>•	Centralizar decisões traz padronização e consistência, mas pode reduzir a autonomia e a agilidade das equipes.</p>
<p>•	Descentralizar dá mais liberdade e velocidade para cada time, mas pode gerar fragmentação e duplicação de esforços.</p>

<h2>4. 📌Exemplo 1 de Diagrama de Classes UML - Sistema Bancário</h2>

<img width="2244" height="576" alt="image" src="https://github.com/user-attachments/assets/e4a7f97a-492f-4ccd-94ad-86e12baccc3f" />

<h2>5. 📌Código Java</h2>

<img width="1059" height="693" alt="image" src="https://github.com/user-attachments/assets/cacdcab5-3bbb-45f6-bb93-c001fd94cc1d" />
<img width="1065" height="694" alt="image" src="https://github.com/user-attachments/assets/41a3e0d7-6233-401c-84c1-eb65233dba37" />

<h2>6. 📌Teste JUnit</h2>
<code><pre>
package banco;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SistemaBancarioTest {

    private SistemaBancario sistema;
    private Banco banco1;
    private Banco banco2;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaBancario();
        banco1 = new Banco("001", "Banco do Brasil", "Av. Central, 100");
        banco2 = new Banco("237", "Bradesco", "Rua das Flores, 200");
    }

    @Test
    public void testCriacaoBanco() {
        assertEquals("001", banco1.getNumero());
        assertEquals("Banco do Brasil", banco1.getNome());
        assertEquals("Av. Central, 100", banco1.getEndereco());
    }

    @Test
    public void testSettersBanco() {
        banco1.setNumero("123");
        banco1.setNome("Novo Banco");
        banco1.setEndereco("Rua Nova, 50");

        assertEquals("123", banco1.getNumero());
        assertEquals("Novo Banco", banco1.getNome());
        assertEquals("Rua Nova, 50", banco1.getEndereco());
    }

    @Test
    public void testAdicionarBancoNoSistema() {
        sistema.addBanco(banco1);
        sistema.addBanco(banco2);

        List<Banco> bancos = sistema.getBancos();
        assertEquals(2, bancos.size());
        assertTrue(bancos.contains(banco1));
        assertTrue(bancos.contains(banco2));
    }

    @Test
    public void testListaBancosVaziaInicialmente() {
        assertTrue(sistema.getBancos().isEmpty());
    }
}
</code></pre>

<h2>7. 📌Exemplo 2 de Diagrama de Classes UML - Sistema Biblioteca</h2>

<img width="2680" height="584" alt="image" src="https://github.com/user-attachments/assets/829a2969-c9c0-4386-aea5-f668d4118d87" />

<h2>8. 📌Código Java</h2>

<h2>9. 📌Teste JUnit</h2>
<code><pre>
//Biblioteca.java

public class Biblioteca {
    private String nome;
    private String numero;

    public Biblioteca(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}

//SistemaBiblioteca.java

import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private List<Biblioteca> bibliotecas;

    public SistemaBiblioteca() {
        this.bibliotecas = new ArrayList<>();
    }

    public void addBiblioteca(Biblioteca b) {
        bibliotecas.add(b);
    }

    public List<Biblioteca> buscarBibliotecaPorNumero(String numero) {
        List<Biblioteca> resultado = new ArrayList<>();
        for (Biblioteca b : bibliotecas) {
            if (b.getNumero().equals(numero)) {
                resultado.add(b);
            }
        }
        return resultado;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }
}
</code></pre>
