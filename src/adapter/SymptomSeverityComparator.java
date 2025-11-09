package adapter;

import java.util.Comparator;

import domain.Symptom;

public class SymptomSeverityComparator implements Comparator<Object> {

	@Override
	public int compare(Object arg0, Object arg1) {
		Symptom s1 = (Symptom) arg0;
		Symptom s2 = (Symptom) arg1;
		return Integer.compare(s1.getSeverityIndex(), s2.getSeverityIndex());
	}

}
