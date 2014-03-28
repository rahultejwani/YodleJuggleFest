package rt.Juggler;

import java.util.ArrayList;

/**
 * @author rahultejwani
 */

/**
 * contains info about juggler
 */
public class Juggler extends AbstractParent{
	private ArrayList<String> circuits;
	private ArrayList<Integer> scores;
	/**
	 * The constructor to create a Juggler object
	 * @param H
	 * @param E
	 * @param P
	 * @param circuits
	 * @param scores
	 */
	public Juggler(String _ID, int H, int E, int P, ArrayList<String> circuits)
	{	
		this.set_ID(_ID);
		this.setH(H);
		this.setE(E);
		this.setP(P);
		this.setCircuits(circuits);
	}
	public int getCircuitScore(String circuit)
	{
		int id = circuits.indexOf(circuit);
		return scores.get(id);
	}
	ArrayList<String> getCircuits() {
		return circuits;
	}
	void setCircuits(ArrayList<String> circuits) {
		this.circuits = circuits;
	}
	ArrayList<Integer> getScores() {
		return scores;
	}
	void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}
	
	
}
