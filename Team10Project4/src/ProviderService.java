package Project4;

public class ProviderService {
    private String name;
    private String setting;

    public ProviderService(String name, String setting) {
        this.name = name;
        this.setting = setting;
    }

    public String getName() {
        return name;
    }

    
    
    public String getSetting() {
        return setting;
    }
}