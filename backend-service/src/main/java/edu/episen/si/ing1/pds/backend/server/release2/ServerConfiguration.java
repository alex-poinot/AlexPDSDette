package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ServerConfiguration {
    private final String configvar = "CONF";
    private final String configlocation ;
    private ServerProperties config;
    private int n;

    public ServerConfiguration(int  n) {
        configlocation = System.getenv(configvar); 
        this.n = n;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config = mapper.readValue(new File(configlocation),ServerProperties.class);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerProperties getConfig() {
        return config;
    }

    public int getN() {
            return n;

    }
}
