package observers;

import main.PilaPosiciones;

public interface RangoObserver {
	
	public void hayRangos(PilaPosiciones posiciones);
	
	public void pintaBroadways();
	
	public void cleanGrid();

}
