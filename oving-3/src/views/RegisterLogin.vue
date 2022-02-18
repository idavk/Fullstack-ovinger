<template>
    <form>
        <BaseInput
            class="input"
            v-bind="$attrs"
            v-model="event.fullname"
            label="Full name"
            type="text"
        />
        <BaseInput
            class="input"
            v-bind="$attrs"
            v-model="event.adress"
            label="Adress"
            type="text"
        />
        <BaseInput
            class="input"
            v-bind="$attrs"
            v-model="event.username"
            label="Username"
            type="text"
        />
        <BaseInput
            class="input"
            v-bind="$attrs"
            v-model="event.password"
            label="Password"
            type="password"
        />
        <BaseInput
            class="input"
            v-bind="$attrs"
            v-model="event.email"
            label="Email"
            type="email"
        />
        <BaseInput
            class="input"
            v-bind="$attrs"
            v-model="event.name"
            label="Phone"
            type="Integer"
        />
        <button type="submit">Register</button>
    </form>
</template>
<script>
import BaseInput from './BaseInput.vue'
export default {
    components {
        BaseInput,
    },
    data() {
        return {
            event: {
                fullname: "",
                adress: "",
                username: "",
                password: "",
                email: "",
                phone: ""
            }
        }
    }
}
</script>