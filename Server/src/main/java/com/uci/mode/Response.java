package com.uci.mode;

public class Response{

    private String status;
    private String code;
    private Object data;
    private ServerInstance serverInstance;

    public ServerInstance getServerInstance() {
        return serverInstance;
    }

    public Response setServerInstance(ServerInstance serverInstance) {
        this.serverInstance = serverInstance;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Response setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Response setCode(String code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public static <T> Response success(T data){
        return new Response().setData(data).setCode("200").setStatus("SUCCESS");
    }

    public static <T> Response fail(T data){
        return new Response().setData(data).setCode("500").setStatus("ERROR");
    }


    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

}