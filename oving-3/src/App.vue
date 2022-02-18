<template>
  <div id="nav">
    <router-link to="/homepage">Homepage</router-link> |
    <router-link to="/">Kalkulator</router-link> |
    <router-link to="/kontaktskjema">Kontaktskjema</router-link> |
    <router-link to="/loginpage">Loginpage</router-link>
  </div>
  <router-view />
</template>

<style>
html {
  -webkit-text-size-adjust: 100%;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
body {
  margin: 0;
  font-family: "Open Sans", sans-serif;
  font-size: 16px;
  line-height: 1.5;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;

}

label,
input,
textarea {
  display: inline-flex;
  font-family: "Open sans", sans-serif;
  font-size: 100%;
  line-height: 1.15;
  margin: 0;
}

label {
  color: rgba(0, 0, 0, 0.5);
  font-weight: 700;
}
input,
textarea {
  box-sizing: border-box;
  border: solid 1px rgba(0, 0, 0, 0.4);
}

textarea {
  width: 100%;
  overflow: auto;
  font-size: 20px;
}

.field {
  margin-bottom: 24px;
}

[type="text"] {
  height: 52px;
  width: 100%;
  padding: 0 10px;
  font-size: 20px;
}
[type="text"]:focus {
  border-color: #39b982;
}
</style>
