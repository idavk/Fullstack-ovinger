package no.ntnu.IDATT2105.oving_5_backend.models.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    final private String loginStatus;
    final private Long userId;

    public LoginResponse(@JsonProperty("loginStatus")  String loginStatus, Long userId) {
        this.loginStatus = loginStatus;
        this.userId = userId;
    }

    @JsonProperty("loginStatus")
    public String getLoginStatus() {
        return loginStatus;
    }

}
