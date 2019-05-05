import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Hunter hunter = new Hunter(
				"https://www.utg.edu.gm/", 
				"web.utg.edu.gm"
				);

		hunter.hunt();
		
		System.out.println("Done!");

	}

}
