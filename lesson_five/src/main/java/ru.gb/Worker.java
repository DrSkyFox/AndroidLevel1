package ru.gb;

import java.util.Objects;

public class Worker {

    private String firstName;
    private String secondName;
    private Integer age;
    private String email;
    private Integer phone;
    private Integer salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Worker(String firstName, String secondName, Integer age, String email, Integer phone, Integer salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }





    public static class Builder {
        private String firstName;
        private String secondName;
        private Integer age;
        private String email;
        private Integer phone;
        private Integer salary;


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(Integer phone) {
            this.phone = phone;
            return this;
        }

        public Builder salary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public Worker build() {
            return new Worker(firstName, secondName, age, email, phone, salary);
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(firstName, worker.firstName) && Objects.equals(secondName, worker.secondName) && Objects.equals(age, worker.age) && Objects.equals(email, worker.email) && Objects.equals(phone, worker.phone) && Objects.equals(salary, worker.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, email, phone, salary);
    }
}
