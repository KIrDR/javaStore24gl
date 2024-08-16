package ispirer.study.project.model;

public class Manufact {

    private String manuCode;
    private String manuName;
    private int unknown1;

    public String getManuCode() {
        return manuCode;
    }

    public void setManuCode(String manuCode) {
        this.manuCode = manuCode;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public int getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(int unknown1) {
        this.unknown1 = unknown1;
    }

    @Override
    public String toString() {
        return "Manufact{" +
                "manuCode='" + manuCode + '\'' +
                ", manuName='" + manuName + '\'' +
                ", unknown1=" + unknown1 +
                '}';
    }
}
