package rt.Juggler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author rahultejwani
 */

public class AssignJugglersToCircuit {
	SlurpInputLoader sl = new SlurpInputLoader();
	ArrayList<Circuit> AllCircuits = new ArrayList<>();
	ArrayList<Juggler> AllJugglers = new ArrayList<>();
	ArrayList<Team> teams = new ArrayList<>();
	HashMap<Juggler,Integer> allottedJugglers = new HashMap<>();
/**
 * Default constructor
 */
	public AssignJugglersToCircuit()
	{
		sl.load();
		AllCircuits = sl.getCircuitList();
		AllJugglers = sl.getJugglerList();
	}

	/**
	 * Main function to assign jugglers to circuit 
	 */
	private void Assign()
	{
		for (Circuit circuit : AllCircuits) {
			String id = circuit.get_ID();
			Team team = new Team() ;
			team.setCircuit(circuit);
			for (Juggler juggler : AllJugglers) {
				ArrayList<String> circuitList = juggler.getCircuits();
				if(circuitList.contains(id))
				{
					if(team.getPossibleJugglers().size() < 6)
						team.AddtoPossibleJugglers(juggler);
					else 
					{
						team.replaceMinimum(juggler);
					}


				}
			}
			teams.add(team);
		}
	}

	/**
	 * function that creates the output file, in the present working directory
	 */
	public void WriteToFile()
	{
		Writer writer = null;

		try {

			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("./output.txt"), "utf-8"));
			System.out.println("Writing to file");
			ArrayList<Team> teams =getTeams();
			for (Team team : teams) {
				writer.write("\n");
				writer.write(team.getCircuit().get_ID() + " " );
				//System.out.print( team.getCircuit().get_ID() + " " );
				List<Juggler> js = team.getPossibleJugglers();
				//System.out.println(js.size());
				int count = 0;
				for (Juggler juggler : js) {
					writer.write(juggler.get_ID());
					//System.out.print(juggler.get_ID());
					for(int i = 0; i < 10; i++)
					{
						writer.write(" " + juggler.getCircuits().get(i) + ":" + juggler.getScores().get(i));
						//		System.out.print(" " + juggler.getCircuits().get(i) + ":" + juggler.getScores().get(i));
					}
					//					System.out.print(",");
					count++;
					if(count < 6)
						writer.write(",");
				}

			}

		} catch (IOException ex) {

		} finally {
			try {
				writer.close();
				System.out.println("Finished :)");
			} catch (IOException ex) {
				System.out.println("Problem in Writer.close");
			}
		}
	}


	public ArrayList<Team> getTeams()
	{
		Assign();
		return this.teams;

	}




}
