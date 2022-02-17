<template>
    <div class="container">
        <BaseInput
            class="input"
            v-model="event.username"
            label="Username"
            type="text"
        />

        <BaseInput
            class="input"
            v-model="event.password"
            label="Password"
            type="text"
        />

        <button class="button" @click="onLogin()">Login</button>
    </div>
    
</template>
<script>
import axios from 'axios';
import BaseInput from './BaseInput.vue';
export default {
    components: {
        BaseInput
    },
    data() {
        return {
            event: {
                username: '',
                password: '',
                loginStatus: ''
            }
        } 
    },
    methods: {
        async onLogin() {
            const loginRequest = {username: this.username, password: this.password};
            const loginResponse = await axios.post("http://localhost:8082/loginpage", loginRequest);
            console.log(loginResponse)
            alert("Login: " + loginResponse.data.loginStatus)
        },
        onLogin_2 () {
            const loginRequest = { username: this.username, password: this.password };
            const loginResponse = axios.post("http://localhost:8082/loginpage", loginRequest);
            console.log(loginResponse)
            loginResponse.then((resolvedResult) => {
            this.loginStatus = resolvedResult.data.loginStatus;
            // alert("Login2: " + resolvedResult.data.loginStatus);
      });
    },


    } 
    
}
</script>