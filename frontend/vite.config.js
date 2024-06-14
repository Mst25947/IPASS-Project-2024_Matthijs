import { resolve } from 'path'
import { defineConfig } from 'vite'
export default defineConfig({
    build: {
        sourcemap: true,
        rollupOptions: {
            input: {
                main: resolve(__dirname, 'index.html'),
                selectCar: resolve(__dirname, './selectCar.html'),
                toyota: resolve(__dirname, './toyota.html'),
                celicaST20: resolve(__dirname, './celica-ST20.html'),
                contact: resolve(__dirname, './contact.html'),
                catagories: resolve(__dirname, './catagories.html'),
                aboutUs: resolve(__dirname, './about-us.html'),
                account: resolve(__dirname, './account.html')

// to add more html pages....see FEP1 boilerplate section build&deploy
        },
    },
    outDir: "../src/main/webapp/",
    emptyOutDir: true,
},
})