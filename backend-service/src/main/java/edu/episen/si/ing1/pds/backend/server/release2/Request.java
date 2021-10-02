package edu.episen.si.ing1.pds.backend.server.release2;

public class Request {

    private String event;
    private Object data;


    public String getEvent() {
        return event;
    }

    public Object getData() {
        return data;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
