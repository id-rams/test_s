package brow.master.com.entity;

import java.util.Objects;

public class Code {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code = (Code) o;
        return Objects.equals(verifyCode, code.verifyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(verifyCode);
    }

    @Override
    public String toString() {
        return "Code{" +
                "verifyCode='" + verifyCode + '\'' +
                '}';
    }

    public Code() {
    }

    public String getVerifyCode() {

        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    private String verifyCode;
}
