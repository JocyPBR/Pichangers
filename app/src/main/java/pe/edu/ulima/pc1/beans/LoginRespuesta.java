package pe.edu.ulima.pc1.beans;

public class LoginRespuesta {
    private String msg;

    public LoginRespuesta(String msg) {
        this.msg = msg;
    }

    public LoginRespuesta() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
