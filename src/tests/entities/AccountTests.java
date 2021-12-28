package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	//fazendo 1� teste unit�rio
	@Test //org.junit.jupiter.api.Test
	public void depositShouldIncreseBalanceWhenPositiveAmount() {
		
		//Criando o Padr�o AAA (Arrange, Act and Assert)
		
		//Padr�o Arrange
		double amount = 200.0; //deposito de 200.0
		double expectedValue = 196.0; //valor esperado ao fazer o test
		Account acc = AccountFactory.createEmptyAccount(); //vari�vel Account com valor 1L, com saldo inicial 0.0. Foi substitu�do 	com a chamada da classe Factory
		
		//Padr�o Act - Executar as a��es necess�rias
		acc.deposit(amount); //depositou 200.0
		
		//Padr�o Assert - Declarar o que vai acontecer
		//Assertions Biblioteca
		Assertions.assertEquals(expectedValue, acc.getBalance()); //assertEquals(expected, actual). Se o valor esperado "expectedValue" ser� igual ao valor do saldo da conta "acc.deposit(amount)" 
	}
	
	@Test //fazendo o 2� teste unit�rio
	public void depositShouldDoNothingWhenNegativeAmount() {

		//Padr�o Arrange
		double expectedValue = 100.0; //valor esperado ao fazer o test
		Account acc = AccountFactory.createAccount(expectedValue); //criar uma conta j� com um valor no saldo, com a chamada da classe Factory 
		double amount = -200.0; //fazer um dep�sito -200.0
		
		//Padr�o Act - Executar as a��es necess�rias
		acc.deposit(amount); //depositou -200.0
		
		//Padr�o Assert - Declarar o que vai acontecer
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test //fazendo o 3� teste unit�rio
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		//Padr�o Arrange
		double expectedValue = 0.0; //valor esperado ao fazer o test. Poderia at� excluir essa linha de c�digo
		double initialBalance = 800.0; //valor inicial na conta com 800.0
		Account acc = AccountFactory.createAccount(initialBalance); //conta com um valor de 800.0 na conta
		
		//Padr�o Act - Executar as a��es necess�rias
		double result = acc.fullWithdraw(); //depositou -200.0
		
		//Padr�o Assert - Declarar o que vai acontecer
		//Obs: Pode ter v�rias Assertions para fazer quantas vezes que quiser os testes
		Assertions.assertTrue(expectedValue == acc.getBalance()); //assertTrue para dizer se � verdadeira que as duas condi��es que est�o no par�metro s�o iguais "=="
		Assertions.assertTrue(result == initialBalance); //assertTrue para dizer se � verdadeira o resultado
	}
	
	
	
	
	
	
	
	
	
	
	
}