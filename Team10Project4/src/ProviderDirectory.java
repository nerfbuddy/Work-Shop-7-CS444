package Project4;

import java.util.HashMap;
import java.util.Map;

public class ProviderDirectory {
    private static Map<Integer, Provider> providers = new HashMap<>();

    public static void addProvider(Provider provider) {
        providers.put(provider.getID(), provider);
    }

    public static Provider getProvider(int id) {
        return providers.get(id);
    }

    
    
    

    public static void removeProvider(Provider provider) {
        providers.remove(provider.getID());
    }
}
