package brow.master.com.entity;

import java.util.Objects;

public class UserService {
    private String id;
    private String time;
    private String service;
    private String phone;
    private String email;
    private String name;

    public UserService() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "Time='" + time + '\'' + "\n" +
                        "Service='" + service + '\'' + "\n" +
                        "Phone='" + phone + '\'' + "\n" +
                        "Email='" + email + '\'' + "\n" +
                        "Name='" + name + '\'';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserService that = (UserService) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {

        return Objects.hash(time, service);
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
