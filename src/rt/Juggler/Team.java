package rt.Juggler;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author rahultejwani
 * Bean class to write to file
 * contains all the jugglers for each circuit
 *
 */
public class Team {
	private Circuit circuit;
	private List<Juggler> possibleJugglers;
	public List<Juggler> getPossibleJugglers() {
		return possibleJugglers;
	}
	public Team()
	{
		this.possibleJugglers= new ArrayList<>();

	}
	public void setPossibleJugglers(List<Juggler> possibleJugglers) {
		this.possibleJugglers = possibleJugglers;
	}
	public Circuit getCircuit() {
		return circuit;
	}
	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	/**
	 * Adds to jugglers list for a circuit
	 * @param js
	 */
	public void AddtoPossibleJugglers(Juggler js)
	{
		this.possibleJugglers.add(js);
	}
	/**
	 * Replaces the minimum scored juggler with a juggler having better score
	 * @param j
	 */
	public void replaceMinimum(Juggler j)
	{

		int min = Integer.MAX_VALUE;
		Juggler id = null;
		for (Juggler juggler : possibleJugglers) {
			if(juggler.getCircuitScore(this.circuit.get_ID()) < min)
			{
				min = juggler.getCircuitScore(this.circuit.get_ID());
				id = juggler;
			}
		}

		if(j.getCircuitScore(this.circuit.get_ID()) > id.getCircuitScore(this.circuit.get_ID()))
		{ 
			int index = this.possibleJugglers.indexOf(id);
			this.possibleJugglers.set(index, j);
		}		

	}

}
