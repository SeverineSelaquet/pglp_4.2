
public interface Command {
	
	public double execute(double a, double b);
	public void undo();
	public String getSymbole();

}
