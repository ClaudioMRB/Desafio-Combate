package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Lutadores;

public class Combate {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		Lutadores lutador1, lutador2;

		System.out.println("Digite os dados do primeiro campeão.");
		System.out.print("nome: ");
		String name = scan.next();
		System.out.print("Vida inicial: ");
		int life0 = scan.nextInt();
		System.out.print("Ataque: ");
		int attack = scan.nextInt();
		System.out.print("Armadura: ");
		int armor = scan.nextInt();
		lutador1 = new Lutadores(name, life0, attack, armor);
		System.out.println();
		System.out.println("Digite os dados do segundo campeão.");
		System.out.print("nome: ");
		name = scan.next();
		System.out.print("Vida inicial: ");
		int life3 = scan.nextInt();
		System.out.print("Ataque: ");
		attack = scan.nextInt();
		System.out.print("Armadura: ");
		armor = scan.nextInt();
		lutador2 = new Lutadores(name, life3, attack, armor);

		System.out.println();
		System.out.print("Quantos turnos você deseja executar? ");
		int rounds = scan.nextInt();

		for (int i = 1; i <= rounds; i++) {
			int life1 = lutador1.getLife() - (lutador2.getAttack() - lutador1.getArmor());
			lutador1.setLife(life1);
			int life2 = lutador2.getLife() - (lutador1.getAttack() - lutador2.getArmor());
			lutador2.setLife(life2);

			System.out.println();
			System.out.println("Resultado do Turno " + i);

			// LUTADOR1
			if (lutador1.getLife() > 0 && lutador2.getAttack() > lutador1.getArmor()) {

				System.out.println(lutador1.getName() + ": " + lutador1.getLife() + " de vida.");
			} else if (lutador1.getLife() > 0 && lutador2.getAttack() < lutador1.getArmor()) {
				life0 -= 1;
				lutador1.setLife(life0);
				System.out.println(lutador1.getName() + ": " + lutador1.getLife() + " de vida.");

			} else if (lutador1.getLife() <= 0) {

				System.out.println(lutador1.getName() + ": " + "0 vida (Morreu)");
				i = rounds;
			}

			// LUTADOR 2
			if (lutador2.getLife() > 0 && lutador1.getAttack() > lutador2.getArmor()) {

				System.out.println(lutador2.getName() + ": " + lutador2.getLife() + " de vida.");
			} else if (lutador2.getLife() > 0 && lutador1.getAttack() < lutador2.getArmor()) {
				life3 -= 1;
				lutador2.setLife(life3);
				System.out.println(lutador2.getName() + ": " + lutador2.getLife() + " de vida.");
			} else if (lutador2.getLife() <= 0) {

				System.out.println(lutador2.getName() + ": " + "0 vida (Morreu)");
				i = rounds;
			}

		}

		System.out.println();
		System.out.println("FIM DO COMBATE");

	}

}
