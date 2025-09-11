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

<h2>📌Diagrama de Classes UML - Sistema Biblioteca</h2>

<img width="768" height="493" alt="uml_corrigido" src="https://github.com/user-attachments/assets/2e4bc0a6-4d20-4111-b3e9-c9ec972cca2c" />

<h2>📌Código Java</h2>

<code>
// Classe base Pessoa
public class Pessoa {
    private String nome;
    private String cpf;

    // Construtor, getters e setters
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}

// Cliente herda de Pessoa
public class Cliente extends Pessoa {
    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }
}

// Funcionário herda de Pessoa
public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}

// Gerente herda de Funcionário
public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, String cpf, double salario, double bonus) {
        super(nome, cpf, salario);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }
}

// Produto
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}

// ItemPedido
public class ItemPedido {
    private int quantidade;
    private Produto produto;

    public ItemPedido(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}

// Pedido
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date data;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(Date data, Cliente cliente, List<ItemPedido> itens) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<ItemPedido> getItens() { return itens; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }
}
</code>

<h2>📌Exemplo 2 de Diagrama de Classes UML - Sistema Bancário</h2>

<img width="2244" height="576" alt="image" src="https://github.com/user-attachments/assets/65f6a9cc-0971-4bf0-a6da-9e4a603f0ded" />

<h2>📌Código Java</h2>

<code>
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
</code>
