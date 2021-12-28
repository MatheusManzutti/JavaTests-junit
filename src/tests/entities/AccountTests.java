package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	//import org.junit.jupiter.api.Test
	@Test //fazendo o método do 1º teste unitário.
	public void depositShouldIncreseBalanceWhenPositiveAmount() { //depósito deveria incrementar o saldo, quando entrar com uma quantidade positiva de dinheiro para depositar.
		
		//Criando o Padrão AAA (Arrange, Act and Assert).
		
		//Padrão Arrange.
		double amount = 200.0; //deposito de $200.0.
		double expectedValue = 196.0; //valor esperado ao fazer o test.
		Account acc = AccountFactory.createEmptyAccount(); //variável Account no valor de 1L, com saldo inicial $0.0. ATENÇÂO: foi substituído com a chamada da classe "Factory".
		
		//Padrão Act - Executar as ações necessárias.
		acc.deposit(amount); //depositou $200.0.
		
		//Padrão Assert - Declarar o que vai acontecer.
		//Assertions é uma Biblioteca do Junit = "import org.junit.jupiter.api.Assertions".
		Assertions.assertEquals(expectedValue, acc.getBalance()); //assertEquals(expected, actual). Se o valor esperado "expectedValue" será igual ao valor do saldo da conta "acc.deposit(amount)". 
	}
	
	@Test //fazendo o método do 2º teste unitário.
	public void depositShouldDoNothingWhenNegativeAmount() { //depósito deveria fazer nada, quando a quantia for negativa.

		//Padrão Arrange.
		double expectedValue = 100.0; //valor esperado ao fazer o test.
		Account acc = AccountFactory.createAccount(expectedValue); //criar uma conta já com um valor no saldo, com a chamada da classe "Factory".
		double amount = -200.0; //fazer um depósito $-200.0.
		
		//Padrão Act - Executar as ações necessárias.
		acc.deposit(amount); //depositou $-200.0.
		
		//Padrão Assert - Declarar o que vai acontecer.
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test //fazendo o método do 3º teste unitário.
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() { //saque total deveria limpar o saldo e retornar o saldo total.
		
		//Padrão Arrange.
		double expectedValue = 0.0; //valor esperado ao fazer o teste. Poderia até excluir essa linha de código.
		double initialBalance = 800.0; //valor inicial na conta com $800.0.
		Account acc = AccountFactory.createAccount(initialBalance); //conta com um valor de $800.0 na conta.
		
		//Padrão Act - Executar as ações necessárias.
		double result = acc.fullWithdraw(); //depositou $-200.0.
		
		//Padrão Assert - Declarar o que vai acontecer.
		//Obs: Pode ter várias Assertions para fazer quantas vezes que quiser os testes.
		Assertions.assertTrue(expectedValue == acc.getBalance()); //assertTrue para dizer se é verdadeira que as duas condições que estão no parâmetro são iguais "==".
		Assertions.assertTrue(result == initialBalance); //assertTrue para dizer se é verdadeira as duas condições no parâmetro.
	}
	
	@Test //fazendo o método do 4º teste unitário.
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() { //saque deveria decrementa o saldo, quando o saldo estiver o suficiente.
		
		//Padrão Arrange.
		Account acc = AccountFactory.createAccount(800.0); //criou uma conta com valor de $800.0 na conta.
		
		//Padrão Act - Executar as ações necessárias.
		acc.withdraw(500.0);
		
		//Padrão Assert - Declarar o que vai acontecer.
		Assertions.assertEquals(300.0, acc.getBalance()); //compara se o valor será esperado "$300.0", com o saldo "acc.getBalance".
	}
	
	@Test //fazendo o método do 5º teste unitário.
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() { //saque deveria lançar uma exceção quando o saldo for insuficiente.
			
		//Padrão Assert - Declarar o que vai acontecer.
		/*
		  ATENÇÃO: Para fazer um teste de exceção, tem a peculiaridade de fazer primeiro o padrão "Assertions", para depois colocar o padrão "Arrange" e "Act".
		  Veja abraixo:
		  
		  assertThrows(expectedType, executable) = testa uma exceção do tipo de exceção "expectedType" e um procedimento executável "executable";
		  
		  IllegalArgumentException.class = é a exceção que está na classe "Account", no método "withdraw".
		  O ".class" tem que por para dizer que é um tipo de classe;
		  
		  () -> {} = expressão Lambda é para passar todo o procedimento padrão "Arrange" e "Act", para fazer o teste de exceção, no padrão "Assertions".
		*/
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //ler o comentário acima. 
			
			//Padrão Arrange.
			Account acc = AccountFactory.createAccount(800.0); //criou uma conta com valor de $800.0 na conta.

			//Padrão Act - Executar as ações necessárias.
			acc.withdraw(801.0); //tentou sacar $801.0.
		});
	}
}