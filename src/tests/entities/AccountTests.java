package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	//import org.junit.jupiter.api.Test
	@Test //fazendo o m�todo do 1� teste unit�rio.
	public void depositShouldIncreseBalanceWhenPositiveAmount() { //dep�sito deveria incrementar o saldo, quando entrar com uma quantidade positiva de dinheiro para depositar.
		
		//Criando o Padr�o AAA (Arrange, Act and Assert).
		
		//Padr�o Arrange.
		double amount = 200.0; //deposito de $200.0.
		double expectedValue = 196.0; //valor esperado ao fazer o test.
		Account acc = AccountFactory.createEmptyAccount(); //vari�vel Account no valor de 1L, com saldo inicial $0.0. ATEN��O: foi substitu�do com a chamada da classe "Factory".
		
		//Padr�o Act - Executar as a��es necess�rias.
		acc.deposit(amount); //depositou $200.0.
		
		//Padr�o Assert - Declarar o que vai acontecer.
		//Assertions � uma Biblioteca do Junit = "import org.junit.jupiter.api.Assertions".
		Assertions.assertEquals(expectedValue, acc.getBalance()); //assertEquals(expected, actual). Se o valor esperado "expectedValue" ser� igual ao valor do saldo da conta "acc.deposit(amount)". 
	}
	
	@Test //fazendo o m�todo do 2� teste unit�rio.
	public void depositShouldDoNothingWhenNegativeAmount() { //dep�sito deveria fazer nada, quando a quantia for negativa.

		//Padr�o Arrange.
		double expectedValue = 100.0; //valor esperado ao fazer o test.
		Account acc = AccountFactory.createAccount(expectedValue); //criar uma conta j� com um valor no saldo, com a chamada da classe "Factory".
		double amount = -200.0; //fazer um dep�sito $-200.0.
		
		//Padr�o Act - Executar as a��es necess�rias.
		acc.deposit(amount); //depositou $-200.0.
		
		//Padr�o Assert - Declarar o que vai acontecer.
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test //fazendo o m�todo do 3� teste unit�rio.
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() { //saque total deveria limpar o saldo e retornar o saldo total.
		
		//Padr�o Arrange.
		double expectedValue = 0.0; //valor esperado ao fazer o teste. Poderia at� excluir essa linha de c�digo.
		double initialBalance = 800.0; //valor inicial na conta com $800.0.
		Account acc = AccountFactory.createAccount(initialBalance); //conta com um valor de $800.0 na conta.
		
		//Padr�o Act - Executar as a��es necess�rias.
		double result = acc.fullWithdraw(); //depositou $-200.0.
		
		//Padr�o Assert - Declarar o que vai acontecer.
		//Obs: Pode ter v�rias Assertions para fazer quantas vezes que quiser os testes.
		Assertions.assertTrue(expectedValue == acc.getBalance()); //assertTrue para dizer se � verdadeira que as duas condi��es que est�o no par�metro s�o iguais "==".
		Assertions.assertTrue(result == initialBalance); //assertTrue para dizer se � verdadeira as duas condi��es no par�metro.
	}
	
	@Test //fazendo o m�todo do 4� teste unit�rio.
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() { //saque deveria decrementa o saldo, quando o saldo estiver o suficiente.
		
		//Padr�o Arrange.
		Account acc = AccountFactory.createAccount(800.0); //criou uma conta com valor de $800.0 na conta.
		
		//Padr�o Act - Executar as a��es necess�rias.
		acc.withdraw(500.0);
		
		//Padr�o Assert - Declarar o que vai acontecer.
		Assertions.assertEquals(300.0, acc.getBalance()); //compara se o valor ser� esperado "$300.0", com o saldo "acc.getBalance".
	}
	
	@Test //fazendo o m�todo do 5� teste unit�rio.
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() { //saque deveria lan�ar uma exce��o quando o saldo for insuficiente.
			
		//Padr�o Assert - Declarar o que vai acontecer.
		/*
		  ATEN��O: Para fazer um teste de exce��o, tem a peculiaridade de fazer primeiro o padr�o "Assertions", para depois colocar o padr�o "Arrange" e "Act".
		  Veja abraixo:
		  
		  assertThrows(expectedType, executable) = testa uma exce��o do tipo de exce��o "expectedType" e um procedimento execut�vel "executable";
		  
		  IllegalArgumentException.class = � a exce��o que est� na classe "Account", no m�todo "withdraw".
		  O ".class" tem que por para dizer que � um tipo de classe;
		  
		  () -> {} = express�o Lambda � para passar todo o procedimento padr�o "Arrange" e "Act", para fazer o teste de exce��o, no padr�o "Assertions".
		*/
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //ler o coment�rio acima. 
			
			//Padr�o Arrange.
			Account acc = AccountFactory.createAccount(800.0); //criou uma conta com valor de $800.0 na conta.

			//Padr�o Act - Executar as a��es necess�rias.
			acc.withdraw(801.0); //tentou sacar $801.0.
		});
	}
}