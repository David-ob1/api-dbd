let email = document.getElementById("email")
let password = document.getElementById("password")
let btn = document.getElementById("btn-login")


btn.addEventListener("click", e =>{
    e.preventDefault()
    
    let data = `email=${email.value}&password=${password.value}`
    axios.post("/api/login", data)
    .then(data =>{
        console.log("sign in!")

        alert("hola")
        

        setTimeout(() => {
            console.log("Retrasado por 2 segundo.");
          }, 2000);
          
    })

    .catch(error => {
        alert(error)
    })

})