package factory;

import java.util.*; import domain.*;

public class SymptomFactory {

    // Instancia única (Singleton)
    private static SymptomFactory instance = new SymptomFactory();
    private Map<String, Symptom> cache = new HashMap<>();

    // Constructor privado
    private SymptomFactory() {}

    public static SymptomFactory getInstance() {
        return instance;
    }

    // Crea o recupera un síntoma según su nombre
    public Symptom createSymptom(String symptomName) {

        // Si ya existe, devuelve el mismo objeto
        if (cache.containsKey(symptomName)) {
            return cache.get(symptomName);
        }

        // Definición de síntomas según impacto
        List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia", "expectoracion");
        List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);

        List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea",
                                             "mialgia", "escalofrios");
        List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);

        List<String> impact1 = Arrays.asList("nauseas", "vómitos", "diarrea",
                                             "congestión nasal", "hemoptisis",
                                             "congestion conjuntival", "mareos");
        List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8, 0.7, 2.0);
        int impact = 0;
        double index = 0;

        if (impact5.contains(symptomName)) {
            impact = 5;
            index = index5.get(impact5.indexOf(symptomName));
        } else if (impact3.contains(symptomName)) {
            impact = 3;
            index = index3.get(impact3.indexOf(symptomName));
        } else if (impact1.contains(symptomName)) {
            impact = 1;
            index = index1.get(impact1.indexOf(symptomName));
        }

        Symptom s = null;
        if (impact != 0) {
            s = new Symptom(symptomName, impact , (int) index);
            cache.put(symptomName, s);
        }

        return s;
    }
}
