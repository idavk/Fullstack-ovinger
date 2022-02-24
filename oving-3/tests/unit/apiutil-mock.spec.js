import { doLogin } from "@/utils/apiutil";
import axios from "axios";

jest.mock("axios");

describe("testing mocking of apiutil.vue", () => {
  it("check that login is successful - against mock", async () => {
    const expectedLoginRespone = { loginStatus: "Success" };
    axios.post.mockImplementation(() =>
      Promise.resolve({ data: expectedLoginRespone })
    );
    const loginRequest = { username: "user1", password: "pass1" };
    const loginResponse = await doLogin(loginRequest);
    console.log(loginResponse);
    expect(loginResponse.data).toEqual(expectedLoginRespone);
  });
});
