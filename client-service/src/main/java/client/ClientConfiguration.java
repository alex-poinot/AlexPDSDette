package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ClientConfiguration {
    private final String configvar = "CONF";
    private final String configlocation;
    private ClientProperties config;

    public ClientConfiguration() {
        configlocation = System.getenv(configvar); // récupérer la valeur de la variable d'environnement
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config = mapper.readValue(new File(configlocation),ClientProperties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientProperties getConfig() {
        return config;
    }
}


