package combos;

import carta.Combo;

public interface Combos {
	public abstract Combos parsea(char[ ] comboParsea);
	public Combo getCombo(int i);
	public int size();
}
