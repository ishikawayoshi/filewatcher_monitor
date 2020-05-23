import VueRouter from 'vue-router'
import WelcomePage from "./components/layout/WelcomePage";

const Foo = { template: '<div>foo</div>' }
const Bar = { template: '<div>bar</div>' }

const routes = [
  {path: '', component: WelcomePage},
  {path: '/bar', component: Bar}
];

const router = new VueRouter({
  mode: 'history',
  routes // short for `routes: routes`
});


export default router;
