package no.ntnu.IDATT2105.oving_5_backend.models.Calculator;

import javax.persistence.*;

@Entity
@Table(name = "calculation")
public class Calculation {
    @Id
    @Column(name = "idcalculation", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "calculation", nullable = false)
    private String calculation;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "id_user")
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Calculation() {
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
