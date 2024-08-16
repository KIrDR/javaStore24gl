package ispirer.study.project.model;

public class State {

    private String code;
    private String sname;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "State{" +
                "code='" + code + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
