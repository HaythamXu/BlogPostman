import Vue from 'vue'
import App from './App.vue'
import ViewUI from 'view-design'
import 'view-design/dist/styles/iview.css';
import router from './router';
import axios from 'axios';
import vueAxios from 'vue-axios';

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

Vue.config.productionTip = false
Vue.use(ViewUI)
Vue.use(vueAxios,axios)

Vue.use(mavonEditor)
mavonEditor.markdownIt

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
