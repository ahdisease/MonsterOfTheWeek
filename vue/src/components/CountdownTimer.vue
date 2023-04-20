<template>
  <aside id="timer">
      <div><p class="text">The Battle begins in: </p></div>
      <div class="timer">
          <span>{{days}}</span>
          <span> :</span>
          <span> {{hours}}</span>
          <span> : </span>
          <span> {{minutes}}</span>
          <span> : </span>
          <span> {{seconds}}</span>

          </div>
      <!-- <div class="timer">{{days}}</div>
      :
      <div class="timer">{{hours}}</div>
      :
      <div class="timer">{{minutes}}</div>
      :
      <div class="timer">{{seconds}}</div> -->
      <p id="DHMS">Days | Hours | Minutes | Seconds </p>
  </aside>


</template>

<script>

export default {
    data() {
        return {
            days:0,
            hours:0,
            minutes:0,
            seconds:0
        }
    },

    methods: {
        currentTime() {
            const currentTime = new Date();
            const cutoffTime = new Date('2023-04-22');

            let countdownSeconds = Number.parseInt(Math.abs(cutoffTime.getTime() - currentTime.getTime())/1000);
            const timerValues = [86400,3600,60,1];
            
            for (let i = 0; i < timerValues.length; i++) {
                const units = Math.floor(countdownSeconds / timerValues[i]);
                countdownSeconds = countdownSeconds % timerValues[i];
                timerValues[i] = units;
            }
            
            this.seconds = timerValues[3].toLocaleString('en-US', {
    minimumIntegerDigits: 2,
    useGrouping: false
  });
            this.minutes = timerValues[2].toLocaleString('en-US', {
    minimumIntegerDigits: 2,
    useGrouping: false
  });
            this.hours = timerValues[1].toLocaleString('en-US', {
    minimumIntegerDigits: 2,
    useGrouping: false
  });
            this.days = timerValues[0].toLocaleString('en-US', {
    minimumIntegerDigits: 2,
    useGrouping: false
  });
        }
    },

    created() {
        this.currentTime();
        setInterval(this.currentTime, 1000)
    }
}
</script>

<style scoped>
/* @font-face{
 font-family:'Orbitron';
} */

#timer {
    margin: 0 auto;

}
.timer {
    display: flex;
    justify-content: center;
    font-family: 'Orbitron';
    background-color: #00201e;
    color: lightgreen;
    /* font-weight: bold; */
    width: 75%;
    height: auto;
    font-size: 40px;
    border: 4px double goldenrod;
    border-radius: 20px;
    padding-left: 5px;
    margin: 0 auto;
}

.text{
    text-align: center;
    font-weight: bold;
    color: lightgreen;
    font-size: 20px;
}

#DHMS {
    color: lightgreen;
    font-weight: bold;
    text-align: center;
}
    
    /* background-image: linear-gradient(
    to right,
    #462523 0,
    #cb9b51 22%,
    #f6e27a 45%,
    #f6f2c0 50%,
    #f6e27a 55%,
    #cb9b51 78%,
    #462523 100%
  );
  color:transparent;
   -webkit-background-clip:text;
   font-size: 30px;
   text-align: center;

} */


</style>