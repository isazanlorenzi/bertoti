<h2>📌Comentário - Primeiro parágrafo</h2>

<p>O texto diferencia programação, ciência da computação e engenharia de software, destacando que esta última aplica teoria e práticas de forma rigorosa para criar sistemas grandes e confiáveis. Embora o software hoje exige padrões mais robustos, dado seu papel crítico na sociedade. A experiência do Google com sistemas massivos oferece uma visão prática única sobre como alcançar essa maturidade.</p>

<h2>📌Comentário - Segundo parágrafo</h2>

<p>Esse segundo trecho amplia a definição de engenharia de software, deixando claro que ela não é só escrever código, mas também envolve processos, ferramentas e práticas que permitem manter esse código útil e sustentável ao longo do tempo.

O Google propõe a ideia de que engenharia de software é como “programação integrada ao longo do tempo”, ou seja, não basta o código funcionar hoje; ele precisa ser fácil de evoluir, corrigir e eventualmente aposentar.

O texto apresenta três princípios centrais para guiar decisões e práticas:
<p>1.	Tempo e Mudança – O código inevitavelmente precisará se adaptar a novas necessidades, tecnologias e requisitos ao longo de sua vida.</p>
<p>2.	Escala e Crescimento – À medida que a organização e o produto crescem, processos e arquitetura também precisam evoluir.</p>
<p>3.	Trade-offs e Custos – Decisões devem ser tomadas considerando os impactos no longo prazo e o equilíbrio entre vantagens e desvantagens.</p>

<h2>📌Exemplos de trade-offs em engenharia de software:</h2>

<p>1.	Velocidade de entrega vs. Qualidade do código</p>
<p>•	Escolher entregar rapidamente pode ajudar a lançar uma funcionalidade no mercado, mas aumenta o risco de dívidas técnicas e problemas futuros.</p>
<p>•	Optar por investir mais tempo na qualidade reduz problemas a longo prazo, mas pode atrasar o lançamento.</p>

<p>2.	Performance vs. Legibilidade</p>
<p>•	Um código extremamente otimizado pode ser mais rápido, mas também mais complexo e difícil de entender.</p>
<p>•	Um código mais simples e legível é fácil de manter, mas pode não ser o mais eficiente em execução.</p>

<p>3.	Centralização vs. Descentralização de decisões técnicas</p>
<p>•	Centralizar decisões traz padronização e consistência, mas pode reduzir a autonomia e a agilidade das equipes.</p>
<p>•	Descentralizar dá mais liberdade e velocidade para cada time, mas pode gerar fragmentação e duplicação de esforços.</p>

<h2>📌Exemplo 1 de Diagrama de Classes UML - Sistema Bancário</h2>

<img width="2244" height="576" alt="image" src="https://github.com/user-attachments/assets/65f6a9cc-0971-4bf0-a6da-9e4a603f0ded" />

<h2>📌Código Java</h2>
<code><pre>
// Entidade base
public abstract class EntidadeEconomica {
    protected String nome;
    protected double saldo;

    public EntidadeEconomica(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println(nome + " não possui saldo suficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }
}

// Famílias
public class Familia extends EntidadeEconomica {
    public Familia(String nome, double saldo) {
        super(nome, saldo);
    }
}

// Empresas
public class Empresa extends EntidadeEconomica {
    public Empresa(String nome, double saldo) {
        super(nome, saldo);
    }

    public void solicitarEmprestimo(SistemaBancario banco, double valor) {
        banco.concederEmprestimo(this, valor);
    }
}

// Governo
public class Governo extends EntidadeEconomica {
    public Governo(String nome, double saldo) {
        super(nome, saldo);
    }

    public void emitirTitulos(SistemaBancario banco, double valor) {
        banco.comprarTitulosPublicos(this, valor);
    }
}

// Banco Central
public class BancoCentral {
    public void fornecerLiquidez(SistemaBancario banco, double valor) {
        banco.receberLiquidez(valor);
        System.out.println("Banco Central forneceu R$" + valor + " de liquidez.");
    }

    public void regularSistema(SistemaBancario banco) {
        System.out.println("Banco Central está regulando o sistema bancário.");
    }
}

// Sistema Bancário
import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
    private double reservas;
    private List<EntidadeEconomica> clientes = new ArrayList<>();

    public void adicionarCliente(EntidadeEconomica entidade) {
        clientes.add(entidade);
    }

    public void receberDeposito(EntidadeEconomica entidade, double valor) {
        entidade.sacar(valor);
        reservas += valor;
        System.out.println(entidade.getNome() + " depositou R$" + valor);
    }

    public void concederEmprestimo(EntidadeEconomica entidade, double valor) {
        if (valor <= reservas) {
            entidade.depositar(valor);
            reservas -= valor;
            System.out.println("Empréstimo de R$" + valor + " concedido a " + entidade.getNome());
        } else {
            System.out.println("Reservas insuficientes para conceder empréstimo.");
        }
    }

    public void comprarTitulosPublicos(Governo governo, double valor) {
        if (valor <= reservas) {
            reservas -= valor;
            governo.depositar(valor);
            System.out.println("Sistema bancário comprou R$" + valor + " em títulos públicos.");
        } else {
            System.out.println("Reservas insuficientes para comprar títulos.");
        }
    }

    public void receberLiquidez(double valor) {
        reservas += valor;
    }

    public double getReservas() {
        return reservas;
    }
}
</code></pre>

<h2>📌Exemplo 2 de Diagrama de Classes UML - Sistema Biblioteca</h2>

<img width="2680" height="584" alt="image" src="https://github.com/user-attachments/assets/46f96582-0c73-468a-aef4-9e7062ac1b43" />

<h2>📌Código Java</h2>
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
