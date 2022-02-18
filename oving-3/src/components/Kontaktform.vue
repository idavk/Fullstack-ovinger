<template>
    <div class="container">
        <form>
            <BaseInput
                class="input"
                v-model="event.name"
                label="Name"
                type="text"
            />
            
            <BaseInput
                class="input"
                v-model="event.email"
                label="Email "
                type="text"
            />
            
            <p class="textarea">
                <label for="review">Review:</label>
                <textarea v-model="review"></textarea>
            </p>
            
        
            <button class="button" @click="onSubmit()" type="submit">Submit</button>
        </form>
    </div>
    
    
</template>
<script>
import BaseInput from './BaseInput.vue';
export default {
  components: { BaseInput },
    data() {
        return {
            event: {
                name: '',
                email: '',
                review: ''
            }
        }
    },
    methods: {
        onSubmit() {
            if(this.event.name === '' || this.event.email === '' || this.event.review === '')
            alert("Alle felt må fære fylt ut før man kan sende inn skjemaet")
            
        }
    },
    
}
</script>
<style scoped>
    .container {
        margin-inline-start : 550px;
        border: solid black;
        padding: 4px;
        background-color: whitesmoke;
        align-self: auto;
        max-width: 250px;
        min-height: 200px;
        color: black;
    }
    #name {
        margin-inline-start: 30px;
        min-width: 50px;
        max-width: 5px;;
    }
    #epost {
        margin-inline-start: 30px;
        min-width: 50px;
        max-width: 5px;;
    }
    #review {
        max-width: 50px;
        max-width: 5px;;
        margin-inline-start: 30px;
    }
</style>