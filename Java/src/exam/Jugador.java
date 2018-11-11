package exam;

import java.util.Stack;

public class Jugador {

	private Integer id;
	private int amount = 100;
	private int valids = 100;
	private int invalids = 0;

	private Stack<Boolean> wallet = new Stack<Boolean>();
	private Stack<Boolean> walletB = new Stack<Boolean>();;

	public Jugador(Integer id) {
		boolean value = true;
		this.id = id;
		if (id == 0) {
			valids = 0;
			invalids = 100;
			value = false;
		}
//		if (id != 0)
			for (int i = 0; i < amount; i++)
				wallet.push(value);
//		else
//			for (int i = 0; i < amount; i++)
//				walletB.push(value);
	}

	void pay(Jugador creditor, int quantity) {
		assert quantity <= amount;
		for (int i = 0; i < quantity; i++) {
			Boolean bill = this.wallet.pop();
			creditor.collect(bill);
			decreaseAmount(bill);
		}
	}

	void payB(Jugador creditor, int quantity) {
		assert this.id == 0 && quantity <= amount;
		for (int i = 0; i < quantity; i++) {
			Boolean bill = this.wallet.pop();
			if(walletB != null)
				bill = this.walletB.pop();
			if(bill == true)
				bill = this.wallet.pop();
			creditor.collectB(bill);
			decreaseAmount(bill);
		}
	}

	public Integer getId() {
		return id;
	}

	public int getValid() {
		return valids;
	}

	public int getInvalids() {
		return invalids;
	}

	public int getAmount() {
		return amount;
	}

	private void collect(Boolean bill) {
		this.wallet.push(bill);
		this.increaseAmount(bill);
	}

	private void collectB(Boolean bill) {
		if (bill)
			this.wallet.push(bill);
		else
			this.walletB.push(bill);
		this.increaseAmount(bill);
	}

	private void increaseAmount(Boolean bill) {
		if (bill)
			valids++;
		else
			invalids++;
		amount++;
	}

	private void decreaseAmount(Boolean bill) {
		if (bill)
			valids--;
		else
			invalids--;
		amount--;
	}

}
