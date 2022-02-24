import { shallowMount, mount } from "@vue/test-utils";
import LoginInfo from "@/components/LoginInfo.vue";

describe("LoginInfo.vue", () => {
  it("check that LoginInfo renders", () => {
    const loginTitle = "Login";
    const wrapper = shallowMount(LoginInfo);
    expect(wrapper.text()).toMatch(loginTitle);

    // add some additional checks. For example related to loginStatusLabel element
    // check that loginstatusLabel component exists
    expect(wrapper.find("#loginstatusLabel").exists()).toBe(true);
    const statusId = wrapper.find("#loginstatusLabel");
    // check that id of the loginstatusLabel element is correct
    expect(statusId.element.id).toBe("loginstatusLabel");
    // check that the loginstatusLabel element is displaying correct value
    expect(statusId.element.textContent).toBe("");
  }),
    it("Modify LoginComponent data and test", async () => {
      const wrapper = shallowMount(LoginInfo);

      // get loginstatusLabel element
      const statusId = wrapper.find("#loginstatusLabel");
      // change loginStatus data and check that loginstatusLabel element is updated accordingly
      await wrapper.setData({ loginStatus: "Success" });
      expect(statusId.element.textContent).toBe("Success");
      await wrapper.setData({ loginStatus: "Failed" });
      expect(statusId.element.textContent).toBe("Failed");
    });
  it("Can log inn", async () => {
    const wrapper = mount(LoginInfo);

    wrapper.find("#inpUsername").setValue("user");
    wrapper.find("#inpPassword").setValue("pass");
    wrapper.find("#btnSubmit").trigger("click");
  });
  it("Login failed, show register link", async () => {
    const wrapper = mount(LoginInfo);

    wrapper.find("#inpUsername").setValue("user1");
    wrapper.find("#inpPassword").setValue("pass1");
    wrapper.find("#btnSubmit").trigger("click");

    // expect(wrapper.find("#alertRegister").text()).toContain(
    //   "Click here to sign up:"
    // );
  });
});
