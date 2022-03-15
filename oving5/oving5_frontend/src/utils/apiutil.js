import axios from "axios";

export async function doLogin(loginRequest) {
  let response = await axios.post(
    `http://localhost:8085/calculator/login`,
    loginRequest
  );
  return response;
}
