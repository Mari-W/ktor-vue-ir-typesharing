<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p v-if="this.user !== null">
      This example was created by <b>{{ this.user.first }} {{ this.user.last }}</b> by the age of
      <b>{{ this.user.age }}</b>.
    </p>
    <h3>Socials</h3>
    <ul v-if="this.socials !== null">
      <li v-for="social in this.socials" v-bind:key="social.name"><a :href="social.url" target="_blank"
                                            rel="noopener">{{ social.name }}</a></li>
    </ul>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator';
import axios from "axios";
import {models, social} from "shared-types";
import User = models.User;
import Social = social.Social;

@Component
export default class HelloWorld extends Vue {
  @Prop() private msg!: string;
  private user: User | null = null;
  private socials: Social[] | null = null;

  getUser() {
    if (!this.user) {
      axios.get<User>("/user").then(res => {
        this.user = res.data
      }).catch(err => {
        console.log(err)
      })
    }
  }

  getSocials() {
    if (!this.socials) {
      axios.get<Social[]>("/socials").then(res => {
        this.socials = res.data
      }).catch(err => {
        console.log(err)
      })
    }
  }

  mounted() {
    this.getUser()
    this.getSocials()
  }
}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
