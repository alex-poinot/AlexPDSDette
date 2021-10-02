package client;

public class Response {
    private boolean success;
    private Object message;
    private String dataType;
    private String event;

    public boolean isSuccess() {
        return success;
    }

    public Object getMessage() {
        return message;
    }

    public String getDataType() { return dataType; }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", event=" + event +
                ", message=" + message +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
