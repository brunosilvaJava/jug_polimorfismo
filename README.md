# 🇧🇷☕ Sistema E-commerce - Demonstração de Polimorfismo

Projeto educacional desenvolvido para a comunidade **JUG Brasil** demonstrando conceitos avançados de **Polimorfismo em Java**.

## 📋 Sobre o Projeto

Este projeto simula um sistema completo de e-commerce aplicando diversos padrões de projeto e conceitos de POO, com foco especial em **Polimorfismo**.

## 🎯 Conceitos Demonstrados

### 1. **Polimorfismo de Herança**
- Classe abstrata `Pagamento`
- Implementações: `PagamentoCartao`, `PagamentoPix`, `PagamentoBoleto`
- Métodos abstratos e concretos
- Sobrescrita de métodos (`@Override`)

### 2. **Polimorfismo de Interface**
- `Desconto`: diferentes estratégias de desconto
- `CalculadoraFrete`: diversos tipos de frete
- `Notificador`: múltiplos canais de notificação

### 3. **Padrões de Projeto**

#### Padrão Factory (Fábrica)
- `PagamentoFactory`: criação de objetos de pagamento
- `NotificadorFactory`: criação de notificadores
- **Benefício**: Encapsulamento da lógica de criação

#### Padrão Strategy (Estratégia)
- Estratégias de desconto intercambiáveis
- Cálculos de frete dinâmicos
- **Benefício**: Algoritmos intercambiáveis em runtime

#### Padrão Template Method (Método Template)
- `GeradorRelatorio`: esqueleto do algoritmo
- `RelatorioVendas`, `RelatorioFinanceiro`: implementações específicas
- **Benefício**: Reutilização de código com pontos de extensão

## 🏗️ Estrutura do Projeto

```
jug_polimorfismo/
├── src/main/java/br/com/jug/ecommerce/
│   ├── dominio/             # Entidades do domínio
│   │   ├── Cliente.java
│   │   ├── TipoCliente.java
│   │   ├── DadosCartao.java
│   │   ├── ItemPedido.java
│   │   ├── Pedido.java
│   │   └── StatusPedido.java
│   │
│   ├── pagamento/           # Sistema de pagamentos (Herança)
│   │   ├── Pagamento.java (abstract)
│   │   ├── PagamentoCartao.java
│   │   ├── PagamentoPix.java
│   │   ├── PagamentoBoleto.java
│   │   ├── PagamentoService.java
│   │   ├── StatusPagamento.java
│   │   └── factory/
│   │       ├── PagamentoFactory.java
│   │       └── TipoPagamento.java
│   │
│   ├── desconto/            # Estratégias de desconto (Strategy)
│   │   ├── Desconto.java (interface)
│   │   ├── DescontoClienteVIP.java
│   │   ├── DescontoClientePremium.java
│   │   ├── DescontoPromocional.java
│   │   ├── DescontoCupom.java
│   │   └── DescontoService.java
│   │
│   ├── frete/               # Cálculo de frete (Strategy)
│   │   ├── CalculadoraFrete.java (interface)
│   │   ├── FreteCorreios.java
│   │   ├── FreteSedex.java
│   │   ├── FreteTransportadora.java
│   │   ├── FreteService.java
│   │   └── TipoFrete.java
│   │
│   ├── notificacao/         # Sistema de notificações (Interface)
│   │   ├── Notificador.java (interface)
│   │   ├── NotificadorEmail.java
│   │   ├── NotificadorSMS.java
│   │   ├── NotificadorWhatsApp.java
│   │   ├── NotificacaoService.java
│   │   └── factory/
│   │       ├── NotificadorFactory.java
│   │       └── TipoNotificacao.java
│   │
│   ├── pedido/              # Processamento de pedidos
│   │   ├── DadosPagamento.java
│   │   └── PedidoService.java
│   │
│   ├── relatorio/           # Geração de relatórios (Template Method)
│   │   ├── GeradorRelatorio.java (abstract)
│   │   ├── RelatorioVendas.java
│   │   ├── RelatorioFinanceiro.java
│   │   └── RelatorioService.java
│   │
│   └── Main.java            # Demonstração completa
```

## 🚀 Como Executar

### Pré-requisitos
- Java 21 ou superior (usa recursos modernos como `void main()` e `java.lang.IO`)

### Execução Direta

```bash
# Executar diretamente com java (Java 21+)
java --enable-preview src/main/java/br/com/jug/ecommerce/Main.java
```

## 📊 Cenários Demonstrados

### Cenário 1: Cliente VIP - Cartão de Crédito
- Cliente VIP recebe 15% de desconto
- Frete SEDEX (rápido)
- Pagamento parcelado em 3x
- Notificação por Email

### Cenário 2: Cliente Premium - PIX
- Cliente Premium recebe 25% de desconto
- Frete Correios
- Pagamento instantâneo via PIX
- Notificação por WhatsApp

### Cenário 3: Cliente Comum - Boleto
- Sem desconto (cliente comum)
- Frete via Transportadora
- Pagamento via boleto bancário
- Notificação por SMS

## 💡 Vantagens do Polimorfismo Demonstradas

1. **Extensibilidade**: Adicionar novo tipo de pagamento sem alterar código existente
2. **Manutenibilidade**: Mudanças isoladas em classes específicas
3. **Testabilidade**: Facilita criação de testes unitários e mocks
4. **Reusabilidade**: Código genérico trabalha com múltiplos tipos
5. **Flexibilidade**: Comportamentos trocados dinamicamente

## 📐 Princípios SOLID Aplicados

- ✅ **S**ingle Responsibility (Responsabilidade Única): Cada classe tem uma responsabilidade única
- ✅ **O**pen/Closed (Aberto/Fechado): Aberto para extensão, fechado para modificação
- ✅ **L**iskov Substitution (Substituição de Liskov): Subtipos substituem tipos base
- ✅ **I**nterface Segregation (Segregação de Interface): Interfaces específicas e coesas
- ✅ **D**ependency Inversion (Inversão de Dependência): Dependência de abstrações

## 🎓 Recursos de Aprendizado

### Polimorfismo
- **Herança**: `extends` com classes abstratas
- **Interface**: `implements` com contratos
- **Sobrescrita**: `@Override` de métodos
- **Coleções Polimórficas**: `List<TipoBase>`

### Padrões de Projeto
- **Fábrica (Factory)**: Criação de objetos
- **Estratégia (Strategy)**: Algoritmos intercambiáveis
- **Método Template (Template Method)**: Esqueleto de algoritmo

## 📝 Exemplos de Uso

### Adicionar Novo Tipo de Pagamento

```java
public class PagamentoCarteira extends Pagamento {
    
    public PagamentoCarteira(BigDecimal valor) {
        super(valor);
    }
    
    @Override
    public void processar() {
        // Implementação específica
        this.id = "CARTEIRA-" + System.currentTimeMillis();
        this.setStatus(StatusPagamento.APROVADO);
        println("✓ Pagamento via Carteira Digital processado");
    }
    
    @Override
    public String gerarComprovante() {
        return "Comprovante Carteira Digital - ID: " + id;
    }
}

// Atualizar Factory
public class PagamentoFactory {
    public static Pagamento criar(TipoPagamento tipo, BigDecimal valor, ...) {
        return switch (tipo) {
            case CARTEIRA_DIGITAL -> new PagamentoCarteira(valor);
            // ...existing cases...
        };
    }
}
```

### Adicionar Nova Estratégia de Desconto

```java
public class DescontoAniversario implements Desconto {
    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        // Lógica de desconto de aniversário
        return new BigDecimal("100.00");
    }
    
    @Override
    public String getDescricao() {
        return "Desconto de Aniversário";
    }
}
```

## 🤝 Contribuições

Contribuições são bem-vindas! Este é um projeto educacional da comunidade JUG Brasil.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.

## 👥 Comunidade

**JUG Brasil** - Java User Group Brasil 🇧🇷☕

---

*Projeto desenvolvido para demonstração de conceitos avançados de Programação Orientada a Objetos em Java*

