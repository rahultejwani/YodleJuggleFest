package rt.Juggler;

/**
 * 
 * @author rahul
 *
 */
/**
 * This class contains all the information about a circuit
 */
public class Circuit extends AbstractParent{
	
	/**
	 * Circuit constructor
	 * @param _ID
	 * @param H
	 * @param E
	 * @param P
	 */
	public Circuit(String _ID, int H, int E, int P)
	{
		this.set_ID(_ID);
		this.setH(H);
		this.setE(E);
		this.setP(P);
	}

}
