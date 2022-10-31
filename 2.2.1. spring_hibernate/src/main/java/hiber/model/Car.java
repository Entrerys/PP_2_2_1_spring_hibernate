package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Car(User user, int series, String model) {
        this.user = user;
        this.series = series;
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Override
    public String toString() {
        return "Car{" +
                "user=" + user +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
