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

	//método para depositar uma certa quantidade de dinheiro que será descontada.
	public void deposit(double amount) {
		if (amount > 0) { //se a quantidade for maior que zero "$0.0".
			amount -= amount * DEPOSIT_FEE_PERCENTAGE; //quantidade menos (-) a quantidade multiplicada com a taxa de 2% (0.02) do banco.
			balance += amount; //o depósito será a quantidade, menos a quantidade descontada.
		}
	}
	
	//método para sacar um valor na conta.
	public void withdraw(double amount) {
		if (amount > balance) { //a quantidade não poderá ser maior que o depósito.
			throw new IllegalArgumentException(); //IllegalArgumentException() = é uma exceção que já tem no Java como padrão. Lançando uma exceção, quando o saldo for insuficiente.
		}
		balance -= amount; //saldo menos a quantidade.
	}
	
	//método para o saque total da conta.
	public double fullWithdraw() {
		double aux = balance; //variável "aux" recebendo o saldo.
			balance = 0.0; //o saldo receberá $0.0.
			return aux; //retorna o que tinha salvo no "aux", ou seja, o saldo que recebeu.
	}
}
