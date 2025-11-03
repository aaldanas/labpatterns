package factory;

import java.util.HashMap;
import java.util.Map;
import domain.Symptom;

public class SymptomFactory {
    private static SymptomFactory instance = new SymptomFactory();
    private Map<String, Symptom> cache = new HashMap<>();

    // Constructor privado: nadie puede crear más instancias
    private SymptomFactory() {}

    public static SymptomFactory getInstance() {
        return instance;
    }

    public Symptom createSymptom(String symptomName, int severityIndex ,  ) {
        if (cache.containsKey(symptomName))
            return cache.get(symptomName);
        
        Symptom s = new Symptom(symptomName, severityIndex, impact);
        cache.put(symptomName, s);
        return s;
    }
}

