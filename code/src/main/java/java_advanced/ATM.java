package java_advanced;

/*
 * reference implementation to understand Thread
 */
public class ATM {

	class User extends Thread {

		public User(Runnable target) {
			super(target);
		}

	}

	class Operation implements Runnable {

		@Override
		public void run() {
			System.out.println("performing operation");

		}
	}

	public static void main(String[] args) {
		ATM.User user = new ATM().new User(new ATM().new Operation());
		user.start();
	}

}
