package no.ntnu.IDATT2105.oving_5_backend.models.Calculator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.ntnu.IDATT2105.oving_5_backend.models.User.LoginRequest;
import no.ntnu.IDATT2105.oving_5_backend.models.User.User;

import javax.persistence.*;

@Entity
@Table(name = "calculations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorResponse {
    @Column(name = "calculation")
    private String calculatorStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public CalculatorResponse(@JsonProperty("calculatorStatus")  String calculatorStatus, User user) {
        this.calculatorStatus = calculatorStatus;
        this.user = user;
    }

    public CalculatorResponse() {

    }

    @JsonProperty("calculatorStatus")
    public String getCalculatorStatus() {
            return calculatorStatus;
        }


}
