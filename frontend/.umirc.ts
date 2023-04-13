import { defineConfig } from 'umi';
import { routes } from './routes';
export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  routes,
  define: {
    designWidth: 1920,
  },
  fastRefresh: {},
});
