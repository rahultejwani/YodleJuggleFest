package rt.Juggler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author rahultejwani
 * This class loads the input file into memory, at once
 */
public final class SlurpInputLoader {
	private ArrayList<Circuit> AllCircuits = new ArrayList<>();
	private ArrayList<Juggler> AllJugglers = new ArrayList<>();
	public void load()
	{
		BufferedReader br;
		String line;
		try
		{
			br= new BufferedReader(new FileReader("./InputFile/input"));
			while((line = br.readLine()) != null)
			{
				String[] parts = line.split("\\s");
				if(parts.length > 4)
				{
					if(line.charAt(0) == 'C' && parts.length == 5)
					{String _ID = parts[1];
					int H = Integer.parseInt(parts[2].split(":")[1]);;
					int E = Integer.parseInt(parts[3].split(":")[1]);
					int P = Integer.parseInt(parts[4].split(":")[1]);
					Circuit circuit = new Circuit(_ID, H, E, P);
					AllCircuits.add(circuit);

					}
					if(line.charAt(0) == 'J' && parts.length == 6)
					{
						String _ID = parts[1];
						int H = Integer.parseInt(parts[2].split(":")[1]);;
						int E = Integer.parseInt(parts[3].split(":")[1]);
						int P = Integer.parseInt(parts[4].split(":")[1]);
						ArrayList<String> circuits = new ArrayList<>();
						String[] circuitListArray = parts[5].split(",");
						for (String string : circuitListArray) {
							circuits.add(string);
						}
						Juggler juggler = new Juggler(_ID, H, E, P, circuits);
						AllJugglers.add(juggler);
					}
				}

			}
			for (Juggler juggler : AllJugglers) {
				ArrayList<String> circuitList = juggler.getCircuits();
				ArrayList<Integer>scores = new ArrayList<>();
				for (String string : circuitList) {
					int index = Integer.parseInt(string.substring(1, string.length()));
					scores.add(getScore(juggler, AllCircuits.get(index)));
				}
				juggler.setScores(scores);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("Completed Input File Load :)");
	}

	public ArrayList<Circuit> getCircuitList()
	{
		return this.AllCircuits;
	}

	public ArrayList<Juggler> getJugglerList()
	{
		return this.AllJugglers;
	}
	private int getScore(Juggler j,Circuit c )
	{
		return (j.getP() * c.getP() + j.getE() * c.getE() + j.getH() * c.getH());
	}
}
