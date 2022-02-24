import { shallowMount, mount } from "@vue/test-utils";
import RegisterLogin from "@/views/RegisterLogin.vue";

describe("RegisterLogin.vue", () => {
  it("Can fill out form", async () => {
    const wrapper = mount(RegisterLogin);

    wrapper.find("#inpFullName").setValue("Ida");
    wrapper.find("#inpAdress").setValue("Trondheim");
    wrapper.find("#inpUserName").setValue("Ida");
    wrapper.find("#inpPass").setValue("pass");
    wrapper.find("#inpFullName").setValue("Ida");
    wrapper.find("#inpEmail").setValue("Ida@gmail.no");
    wrapper.find("#inpPhone").setValue("46864938");

  });
});
