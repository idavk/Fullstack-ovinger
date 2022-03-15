<template>
  <div class="container">
    <div class="kalkulator">
      <div id="display">{{ current || 0 }}</div>
      <button class="button-operator" @click="clear">C</button>
      <button class="button-operator" @click="calculate()"></button>
      <button class="button-operator" @click="del">DEL</button>
      <button
        class="button-operator"
        @click="setOperator('plus')"
        v-bind:class="{ active: operator == 'plus' }"
      >
        +
      </button>
      <button class="button-nr" @click="append('9')">9</button>
      <button class="button-nr" @click="append('8')">8</button>
      <button class="button-nr" @click="append('7')">7</button>
      <button
        class="button-operator"
        @click="setOperator('minus')"
        v-bind:class="{ active: operator == 'minus' }"
      >
        -
      </button>
      <button class="button-nr" @click="append('6')">6</button>
      <button class="button-nr" @click="append('5')">5</button>
      <button class="button-nr" @click="append('4')">4</button>
      <button
        class="button-operator"
        @click="setOperator('multiply')"
        v-bind:class="{ active: operator == 'multiply' }"
      >
        x
      </button>
      <button class="button-nr" @click="append('3')">3</button>
      <button class="button-nr" @click="append('2')">2</button>
      <button class="button-nr" @click="append('1')">1</button>
      <button
        class="button-operator"
        @click="setOperator('divide')"
        v-bind:class="{ active: operator == 'divide' }"
      >
        ÷
      </button>
      <button class="button-nr"></button>
      <button class="button-nr" @click="append('0')">0</button>
      <button class="button-nr" @click="addComma">.</button>
      <button class="button-operator" @click="calculate()">=</button>
    </div>
    <box class="log">
      <h2>Calculations</h2>
      <ul>
        <li v-for="calculation in calculations" v-bind:key="calculation">
          {{ calculation }}
        </li>
      </ul>
    </box>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      previous: "",
      current: "",
      operator: null,
      calculations: [],
      hasComma: false,
      calulatorStatus: "",
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
    async calculate() {
      const CalculatorRequest = {
        firstNumber: this.previous,
        operator: this.operator,
        secondNumber: this.current,
      };
      let CalculatorResponse = await axios.post(
        `http://localhost:8888/calculate`,
        CalculatorRequest
      );
      console.log(CalculatorResponse.data.calculatorStatus);
      this.calculations.push(CalculatorResponse.data.calculatorStatus);
      return CalculatorResponse;
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
  margin: 1px;
  background-color: grey;
  border: solid 2px;
  border-radius: 20px;
}
.button-operator {
  margin: 1px;
  background-color: orange;
  border: solid 2px;
  border-radius: 20px;
}
#display {
  grid-column: 1 / 5;
  border: solid 2px;
  background-color: slategray;
  border-radius: 10px;
}
</style>
