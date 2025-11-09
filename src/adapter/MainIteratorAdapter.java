package adapter;

import java.util.Iterator;

public class MainIteratorAdapter {
	public static void main(String[] args) {

		Covid19Pacient pacient = new Covid19Pacient("Aitor", 35);
		pacient.addSymptomByName("fiebre", 3);
		pacient.addSymptomByName("tos seca", 2);
		pacient.addSymptomByName("astenia", 1);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("nauseas", 2);

		InvertedIterator adapter = new Covid19PacientInvertedAdapter(pacient);

		System.out.println("=== Ordenado por nombre ===");
		Iterator<Object> itName = Sorting.sortedIterator(adapter, new SymptomNameComparator());
		while (itName.hasNext()) {
			System.out.println(itName.next());
		}

		System.out.println("\n=== Ordenado por severidad ===");
		adapter.goLast();
		Iterator<Object> itSeverity = Sorting.sortedIterator(adapter, new SymptomSeverityComparator());
		while (itSeverity.hasNext()) {
			System.out.println(itSeverity.next());
		}
	}
}