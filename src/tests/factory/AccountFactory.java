package tests.factory;

import entities.Account;

/*
  Padrão de projeto "Fábrica" que é que tem que ter uma classe para instanciar os objetos para mim,
  se for uma operação repetitiva no sistema.
*/ 

public class AccountFactory {

	//método auxiliar que sempre irá criar um conta com saldo zero.
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	//método para informar um certo saldo que quer informar.
	public static Account createAccount(double initialBalance) { //initialBalance = saldo inicial da conta.
		return new Account(1L, initialBalance);
	}
}
