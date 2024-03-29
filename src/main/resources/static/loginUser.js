let email = document.getElementById("email")
let password = document.getElementById("password")
let btn = document.getElementById("btn-login")


btn.addEventListener("click", e =>{
    // e.preventDefault()
    
    let info = `email=${email.value}&password=${password.value}`
    axios.post("/api/login", info)
    .then(data =>{
        console.log(data)
        console.log("sign in!")

        

        setTimeout(() => {
            location.href = '/pages/index.html';
            console.log("Retrasado por 2 segundo.");
          }, 1000);
          
    })

    .catch(error => {
        alert(error)
        console.log(error)
    })

})