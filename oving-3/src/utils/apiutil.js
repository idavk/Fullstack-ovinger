import axios from "axios";

export function doLogin(loginRequest) {
  return axios
    .post(`http://localhost:8085/demo/login`, loginRequest)
    .then((resonse) => {
      return resonse.data;
    });
}
