package Project4;

public class ProviderDirectoryRequester {
    public static Provider requestProvider(int id) {
        return ProviderDirectory.getProvider(id);
    }

    public static void addProviderToDirectory(Provider provider) {
        ProviderDirectory.addProvider(provider);
    }

    
    
    public static void removeProviderFromDirectory(Provider provider) {
        ProviderDirectory.removeProvider(provider);
    }
}