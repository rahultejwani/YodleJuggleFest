package rt.Juggler;

/**
 * 
 * @author rahultejwani
 *
 */
/**
 * This is the parent abstract class, which is extended by both Juggler and the Circuit class
 */
public abstract class AbstractParent {
	private String _ID;
	private int H;
	private int E;
	private int P;
	public int getP() {
		return P;
	}
	protected void setP(int p) {
		this.P = p;
	}
	protected int getE() {
		return E;
	}
	protected void setE(int e) {
		E = e;
	}
	protected int getH() {
		return H;
	}
	protected void setH(int h) {
		H = h;
	}
	protected String get_ID() {
		return _ID;
	}
	protected void set_ID(String _ID) {
		this._ID = _ID;
	}
	
	
}
