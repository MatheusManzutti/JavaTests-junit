package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	//fazendo teste unitário
	@Test //org.junit.jupiter.api.Test
	public void depositShouldIncreseBalanceWhenPositiveAmount() {
		
		//Criando o Padrão AAA (Arrange, Act and Assert)
		
		//Padrão Arrange
		double amount = 200.0; //deposito de 200.0
		double expectedValue = 196.0; //valor esperado ao fazer o test
		Account acc = new Account(1L, 0.0); //variável Account com valor 1L, com saldo inicial 0.0
		
		//Padrão Act - Executar as ações necessárias
		acc.deposit(amount); //depositou 200.0
		
		//Padrão Assert - Declarar o que vai acontecer
		//Assertions Biblioteca
		Assertions.assertEquals(expectedValue, acc.getBalance()); //assertEquals(expected, actual). Se o valor esperado "expectedValue" será igual ao valor do saldo da conta "acc.deposit(amount)" 
	}
}
