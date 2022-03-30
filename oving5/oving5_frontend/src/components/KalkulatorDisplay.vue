<template>
  <div class="container">
    <div class="kalkulator">
      <div id="display">{{ current || 0 }}</div>
      <button class="button-operator" @click="clear">C</button>
      <button class="button-operator" @click="calculate()"></button>
      <button class="button-operator" @click="del">DEL</button>
      <button
        class="button-operator"
        @click="setOperator('+')"
        v-bind:class="{ active: operator == '+' }"
      >
        +
      </button>
      <button class="button-nr" @click="append('9')">9</button>
      <button class="button-nr" @click="append('8')">8</button>
      <button class="button-nr" @click="append('7')">7</button>
      <button
        class="button-operator"
        @click="setOperator('-')"
        v-bind:class="{ active: operator == '-' }"
      >
        -
      </button>
      <button class="button-nr" @click="append('6')">6</button>
      <button class="button-nr" @click="append('5')">5</button>
      <button class="button-nr" @click="append('4')">4</button>
      <button
        class="button-operator"
        @click="setOperator('*')"
        v-bind:class="{ active: operator == '*' }"
      >
        x
      </button>
      <button class="button-nr" @click="append('3')">3</button>
      <button class="button-nr" @click="append('2')">2</button>
      <button class="button-nr" @click="append('1')">1</button>
      <button
        class="button-operator"
        @click="setOperator('/')"
        v-bind:class="{ active: operator == '/' }"
      >
        ÷
      </button>
      <button class="button-nr"></button>
      <button class="button-nr" @click="append('0')">0</button>
      <button class="button-nr" @click="addComma">.</button>
      <button class="button-operator" @click="getAnswer()">=</button>
    </div>
    <div class="log">
      <h2>Calculations</h2>
      <ul>
        <li
          v-for="calculation in this.$store.getters.GET_CALCULATIONLOG.slice().reverse()"
          v-bind:key="calculation"
        >
          {{ calculation }}
        </li>
      </ul>
    </div>
    <button @click="getPreviousCalculations()">previous answers</button>
  </div>
</template>

<script>
import axios from "axios";
//import https from "https";
export default {
  name: "KalkulatorDisplay",
  data() {
    return {
      previous: "",
      current: "",
      operator: null,
      calculations: [],
      hasComma: false,
      config: {
        headers: {
          Authorization: "Bearer " + this.$store.getters.GET_TOKEN,
        },
      },
    };
  },
  methods: {
    clear() {
      this.current = "";
      this.previous = null;
      this.operator = null;
      this.hasComma = false;
    },
    append(number) {
      if (this.operatorClicked) {
        this.current = "";
        this.operatorClicked = false;
      }
      this.current = `${this.current}${number}`;
    },
    addComma() {
      if (this.hasComma == false) {
        this.current = `${this.current}${"."}`;
        this.hasComma = true;
      }
    },
    setOperator(operator) {
      this.operator = operator;
      this.previous = this.current;
      this.current = "";
    },

    getPreviousCalculations() {
      this.fetchedPrevious = true;
      axios
        .get("http://localhost:8085/getCalculations", this.config)
        .then((response) => {
          if (response.data != this.$store.getters.GET_CALCULATIONLOG) {
            response.data.forEach((element) => {
              this.$store.commit("ADD_CALCULATION", element);
            });
          }
        });
    },
    async getAnswer() {
      await axios
        .post(
          "http://localhost:8085/user/calculate",
          {
            calculation: this.previous + this.operator + this.current,
          },
          this.config
        )
        .then((response) => {
          if (response.data.answer == null) {
            this.current = "error";
          } else {
            this.$store.commit(
              "ADD_CALCULATION",
              this.previous +
                " " +
                this.operator +
                " " +
                this.current +
                " = " +
                response.data.answer
            );
            this.current = response.data.answer;
          }
        });
    },
    del() {
      this.current = this.current.substring(0, this.current.length - 1);
      if (this.current.length < 1) {
        this.current = "0";
      }
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.kalkulator {
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(50px, auto);
}
.button-nr {
  display: flex;
  justify-content: center;
  margin: 1px;
  background-color: grey;
  border: solid 2px;
  border-radius: 20px;
  padding-top: 10px;
}
.button-operator {
  display: flex;
  justify-content: center;
  margin: 1px;
  background-color: orange;
  border: solid 2px;
  border-radius: 20px;
  padding-top: 10px;
}
#display {
  grid-column: 1 / 5;
  display: flex;
  justify-content: flex-end;
  border: solid 2px;
  background-color: slategray;
  border-radius: 10px;
  padding-top: 10px;
  
}
</style>
