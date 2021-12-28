package entities;

public class Account {

	//atributo constante.
	public static double DEPOSIT_FEE_PERCENTAGE = 0.02;
	
	//atributos.
	private Long id;
	private Double balance;
	
	//contrutor vazio.
	public Account() {
	}
	
	//contrutor com argumentos.
	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	//getters e setters.
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getBalance() {
		return balance;
	}

	//m�todo para depositar uma certa quantidade de dinheiro que ser� descontada.
	public void deposit(double amount) {
		if (amount > 0) { //se a quantidade for maior que zero "$0.0".
			amount -= amount * DEPOSIT_FEE_PERCENTAGE; //quantidade menos (-) a quantidade multiplicada com a taxa de 2% (0.02) do banco.
			balance += amount; //o dep�sito ser� a quantidade, menos a quantidade descontada.
		}
	}
	
	//m�todo para sacar um valor na conta.
	public void withdraw(double amount) {
		if (amount > balance) { //a quantidade n�o poder� ser maior que o dep�sito.
			throw new IllegalArgumentException(); //IllegalArgumentException() = � uma exce��o que j� tem no Java como padr�o. Lan�ando uma exce��o, quando o saldo for insuficiente.
		}
		balance -= amount; //saldo menos a quantidade.
	}
	
	//m�todo para o saque total da conta.
	public double fullWithdraw() {
		double aux = balance; //vari�vel "aux" recebendo o saldo.
			balance = 0.0; //o saldo receber� $0.0.
			return aux; //retorna o que tinha salvo no "aux", ou seja, o saldo que recebeu.
	}
}
