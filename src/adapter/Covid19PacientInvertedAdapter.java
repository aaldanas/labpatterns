package adapter;

import java.util.ArrayList;
import java.util.List;

import domain.Symptom;

public class Covid19PacientInvertedAdapter implements InvertedIterator{

	private List<Symptom> symptons;
	private int index;
	
	public Covid19PacientInvertedAdapter(Covid19Pacient pacient) {
		this.symptons = new ArrayList<>(pacient.getSymptoms());
		this.index = symptons.size();
	}
	@Override
	public Object previous() {
		if (hasPrevious()) {
			index--;
			return symptons.get(index);
		}
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return index > 0;
	}

	@Override
	public void goLast() {
		index=symptons.size();
	}
	

}
