package Lecture01;


public class SoccerTestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// *************************************************************
		// Team 1 (Germany)
		Trainer t1 = new Trainer("Juergen Klinsmann", 34, 9);
		Keeper k1 = new Keeper("J. Lehmann", 36, 8, 1, 9, 7);
		Player[] p1 = new Player[20];
		p1[0] = new Player("P. Lahm", 23, 9, 5, 9);
		p1[1] = new Player("C. Metzelder", 25, 8, 2, 7);
		p1[2] = new Player("P. Mertesacker", 22, 9, 2, 8);
		p1[3] = new Player("M. Ballack", 29, 7, 5, 8);
		p1[4] = new Player("T. Borowski", 26, 9, 8, 9);
		p1[5] = new Player("D. Odonkor", 22, 7, 5, 8);
		p1[6] = new Player("B. Schweinsteiger", 22, 2, 3, 2);
		p1[7] = new Player("L. Podolski", 21, 7, 8, 9);
		p1[8] = new Player("M. Klose", 28, 10, 9, 7);
		p1[9] = new Player("O. Neuville", 33, 8, 8, 7);
		p1[10] = new Player("R. Pipaluk", 21, 8, 9, 9);
		p1[11] = new Player("Hr. Waedeled", 23, 9, 9, 1);
		p1[12] = new Player("A. Aagren", 22, 3, 1, 2);
		// *************************************************************

		// *************************************************************
		// Team 2 (Brazil)
		Trainer t2 = new Trainer("Carlos Alberto Parreira", 50, 3);
		Keeper k2 = new Keeper("Dida", 25, 9, 1, 6, 8);
		Player[] p2 = new Player[20];
		p2[0] = new Player("Cafu", 33, 8, 4, 6);
		p2[1] = new Player("R. Carlos", 32, 9, 9, 2);
		p2[2] = new Player("Lucio", 29, 10, 9, 9);
		p2[3] = new Player("Ronaldinho", 25, 10, 9, 5);
		p2[4] = new Player("Zé Roberto", 27, 7, 7, 4);
		p2[5] = new Player("Kaká", 22, 10, 8, 10);
		p2[6] = new Player("Juninho", 26, 7, 10, 3);
		p2[7] = new Player("Adriano", 23, 8, 8, 4);
		p2[8] = new Player("Robinho", 19, 9, 8, 9);
		p2[9] = new Player("Ronaldo", 28, 4, 10, 2);
		p2[10] = new Player("A. McCumber", 21, 1, 1, 1);
		p2[11] = new Player("L. Aafeldt", 23, 3, 2, 1);
		p2[12] = new Player("E.Z.", 23, 2, 1, 3);

		// *************************************************************
		Team tm1 = new Team("Germany 2006",t1,k1,p1);
		Team tm2 = new Team("Brazil 2006",t2,k2,p2);

		FriendlySoccerMatch f1 = new FriendlySoccerMatch();

		System.out.println("------------------------------------------");
		System.out.println("Start Game between");
		System.out.println();
		System.out.println(tm1.getName());
		System.out.println(" Trainer: "+tm1.getTrainer().getName());
		System.out.println();
		System.out.println(" and");
		System.out.println();
		System.out.println(tm2.getName());
		System.out.println(" Trainer: "+tm2.getTrainer().getName());
		System.out.println("------------------------------------------");

		f1.startGame(tm1, tm2);

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println(f1.getResultText(tm1, tm2));
		System.out.println("------------------------------------------");
	}
}

