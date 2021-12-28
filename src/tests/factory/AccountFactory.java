package tests.factory;

import entities.Account;

/*
  Padr�o de projeto "F�brica" que � que tem que ter uma classe para instanciar os objetos para mim,
  se for uma opera��o repetitiva no sistema.
*/ 

public class AccountFactory {

	//m�todo auxiliar que sempre ir� criar um conta com saldo zero.
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	//m�todo para informar um certo saldo que quer informar.
	public static Account createAccount(double initialBalance) { //initialBalance = saldo inicial da conta.
		return new Account(1L, initialBalance);
	}
}
