const inputNme = document.getElementById("name")
const inputEmail = document.getElementById("email")
const inputPassword = document.getElementById("password")
const inputPasswordRepeat = document.getElementById("passwordRepeat")
const $btn = document.getElementById("btn-login")
const endPoint = "/api/persons/new"


    $btn.addEventListener("click",()=>{
        let validar
        validacion(inputPassword.value,inputPasswordRepeat.value) ? validar = true : validar = false
        console.log(validar)


        if (validar != true){
            alert("error")
        return false
        }

      let user =  obtenerDatos ();

      console.log(user)


    })

        function validacion(item1,item2){
            if(item1 !== item2){
                return false
            }
            
            return true
        }


    function obtenerDatos (){
console.log()
        return {
            name: inputNme.value,
            email: inputEmail.value,
            password: inputPassword.value,

        }

    }