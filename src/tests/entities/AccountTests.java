package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	//fazendo teste unit�rio
	@Test //org.junit.jupiter.api.Test
	public void depositShouldIncreseBalanceWhenPositiveAmount() {
		
		//Criando o Padr�o AAA (Arrange, Act and Assert)
		
		//Padr�o Arrange
		double amount = 200.0; //deposito de 200.0
		double expectedValue = 196.0; //valor esperado ao fazer o test
		Account acc = new Account(1L, 0.0); //vari�vel Account com valor 1L, com saldo inicial 0.0
		
		//Padr�o Act - Executar as a��es necess�rias
		acc.deposit(amount); //depositou 200.0
		
		//Padr�o Assert - Declarar o que vai acontecer
		//Assertions Biblioteca
		Assertions.assertEquals(expectedValue, acc.getBalance()); //assertEquals(expected, actual). Se o valor esperado "expectedValue" ser� igual ao valor do saldo da conta "acc.deposit(amount)" 
	}
}
