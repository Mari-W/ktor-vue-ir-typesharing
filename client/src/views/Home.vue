<template>
  <div class="home">
    <HelloWorld msg="Welcome to Your Vue.js + Ktor App with Shared Types!"/>
    <img alt="Ktor Logo" :src=" assets + 'ktor_logo.svg'">
    <h1>+</h1>
    <img alt="Vue logo" src="../assets/logo.png">
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
@Component({
  components: {
    HelloWorld,
  },
})
export default class Home extends Vue {
   private assets: string = process.env.VUE_APP_ASSETS as string;
}
</script>
