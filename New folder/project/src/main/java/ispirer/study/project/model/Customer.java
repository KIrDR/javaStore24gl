package ispirer.study.project.model;

public class Customer {

    private int customerNum;
    private String fname;
    private String lname;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String phone;

    public int getCustomerNum() { return customerNum; }
    public void setCustomerNum(int customerNum) { this.customerNum = customerNum; }
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }
    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }
    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNum=" + customerNum +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", company='" + company + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
