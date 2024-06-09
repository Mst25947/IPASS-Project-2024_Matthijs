import { resolve } from 'path'
import { defineConfig } from 'vite'
export default defineConfig({
    build: {
        sourcemap: true,
        rollupOptions: {
            input: {
                main: resolve(__dirname, 'Index.html'),
                selectCar: resolve(__dirname, './SelectCar.html'),
                toyota: resolve(__dirname, './Toyota.html'),
                celicaST20: resolve(__dirname, './Celica-ST20.html'),
                contact: resolve(__dirname, './Contact.html'),
                catagories: resolve(__dirname, './Catagories.html'),
                aboutUs: resolve(__dirname, './About-us.html'),
                account: resolve(__dirname, './Account.html')

// to add more html pages....see FEP1 boilerplate section build&deploy
        },
    },
    outDir: "../src/main/webapp/",
    emptyOutDir: true,
},
})