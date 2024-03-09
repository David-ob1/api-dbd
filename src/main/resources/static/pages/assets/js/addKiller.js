
let btn = document.getElementById("btn-addKiller")
let layout = document.querySelector("#layout")



btn.addEventListener("click", e =>{
    e.preventDefault()

  const valores = obtenerValores()
    
    console.log(valores.killer)
    console.log(valores.skill)
    console.log(valores.height)
    console.log(valores.speed)
    console.log(valores.terrorRadius)

})


function obtenerValores (){
  
    return {
        killer: document.getElementById("killer").value,
        skill: document.getElementById("skill").value,
        height: document.getElementById("height").value,
        speed: document.getElementById("speed").value,
        terrorRadius: document.getElementById("terrorRadius").value,
    

    };
}


function enviarDatos (data,url){

fetch(url,{
    method:"Post",
    body:JSON.stringify(data)
})
.then(response =>response.json())
.then(responseData =>{

    alert(responseData +" hola")

})
.catch(error =>{
    console.error("Hubo un error: ",error)
    alert("hubo un error")

}
    
)
        

}