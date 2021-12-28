package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	//fazendo 1º teste unitário
	@Test //org.junit.jupiter.api.Test
	public void depositShouldIncreseBalanceWhenPositiveAmount() {
		
		//Criando o Padrão AAA (Arrange, Act and Assert)
		
		//Padrão Arrange
		double amount = 200.0; //deposito de 200.0
		double expectedValue = 196.0; //valor esperado ao fazer o test
		Account acc = AccountFactory.createEmptyAccount(); //variável Account com valor 1L, com saldo inicial 0.0. Foi substituído 	com a chamada da classe Factory
		
		//Padrão Act - Executar as ações necessárias
		acc.deposit(amount); //depositou 200.0
		
		//Padrão Assert - Declarar o que vai acontecer
		//Assertions Biblioteca
		Assertions.assertEquals(expectedValue, acc.getBalance()); //assertEquals(expected, actual). Se o valor esperado "expectedValue" será igual ao valor do saldo da conta "acc.deposit(amount)" 
	}
	
	@Test //fazendo o 2º teste unitário
	public void depositShouldDoNothingWhenNegativeAmount() {

		//Padrão Arrange
		double expectedValue = 100.0; //valor esperado ao fazer o test
		Account acc = AccountFactory.createAccount(expectedValue); //criar uma conta já com um valor no saldo, com a chamada da classe Factory 
		double amount = -200.0; //fazer um depósito -200.0
		
		//Padrão Act - Executar as ações necessárias
		acc.deposit(amount); //depositou -200.0
		
		//Padrão Assert - Declarar o que vai acontecer
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test //fazendo o 3º teste unitário
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		//Padrão Arrange
		double expectedValue = 0.0; //valor esperado ao fazer o test. Poderia até excluir essa linha de código
		double initialBalance = 800.0; //valor inicial na conta com 800.0
		Account acc = AccountFactory.createAccount(initialBalance); //conta com um valor de 800.0 na conta
		
		//Padrão Act - Executar as ações necessárias
		double result = acc.fullWithdraw(); //depositou -200.0
		
		//Padrão Assert - Declarar o que vai acontecer
		//Obs: Pode ter várias Assertions para fazer quantas vezes que quiser os testes
		Assertions.assertTrue(expectedValue == acc.getBalance()); //assertTrue para dizer se é verdadeira que as duas condições que estão no parâmetro são iguais "=="
		Assertions.assertTrue(result == initialBalance); //assertTrue para dizer se é verdadeira o resultado
	}
	
	
	
	
	
	
	
	
	
	
	
}