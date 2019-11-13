import axios from "axios"

class HelloWorldService {
    executeHelloWorldService(){
        return axios.get("http://localhost:8080/hello-world")
        //console.log("executed service")
    }
    executeHelloWorldBeanService(){
        return axios.get("http://localhost:8080/hello-world-bean")
    }

    executeHelloWorldPathVariableService(name){
        return axios.get(`http://localhost:8080/hello-world/path-variable/${name}`);
    }
}

export default new HelloWorldService()