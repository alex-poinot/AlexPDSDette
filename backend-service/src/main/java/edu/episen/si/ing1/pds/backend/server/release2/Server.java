package edu.episen.si.ing1.pds.backend.server.release2;


import edu.episen.si.ing1.pds.backend.server.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Properties;


public class Server {
    private final static Logger log = LoggerFactory.getLogger(Server.class.getName());
    private ServerSocket server;
    private DataSource ds;
    private int nbCon = 5;
    public Server(ServerConfiguration c) {
        try {
            this.server = new ServerSocket(c.getConfig().getPort());
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
            this.ds = new DataSource(c.getN(), props);

            log.debug("Server starting...");
            log.debug(String.valueOf(c.getConfig().getPort()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverService(String pool)
    {
        try {

            while (true) {
                log.info(pool);
                if(!pool.trim().equalsIgnoreCase("overload")) {
                    log.info("test -" + pool + "-");
                    Socket client = server.accept();
                    log.debug("A new client is here !");

                    Connection connection = ds.addData();
                    ClientHandler clientSock = new ClientHandler(client, connection);

                    new Thread(clientSock).start();
                } else {
                    if(nbCon > 0) {
                        Socket client = server.accept();
                        log.debug("Client " + nbCon + " is here !");
                        nbCon = nbCon-1;

                        Connection connection = ds.addData();
                        ClientHandler clientSock = new ClientHandler(client, connection);

                        new Thread(clientSock).start();

                        try {
                            Thread.sleep(120000);
                            log.debug("End of client");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    } else {
                        log.debug("Max connection");
                    }

                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        new Server(new ServerConfiguration(25)).serverService(args[0]);
    }
}



