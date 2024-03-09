
let btn = document.getElementById("btn-addKiller")
let layout = document.querySelector("#layout")



btn.addEventListener("click", e =>{
    e.preventDefault()

  const valores = obtenerValores()
    
    console.log(valores.name)
    console.log(valores.perk)
    console.log(valores.skill)
    console.log(valores.height)
    console.log(valores.speed)
    console.log(valores.terrorRadius)

    // enviarDatos(valores,"/api/killers/add")    

})


function obtenerValores (){
  
    return {
        name: document.getElementById("killer").value,
        perk: document.getElementById("perk").value,
        speed: document.getElementById("speed").value,
        skill: document.getElementById("skill").value,
        height: document.getElementById("height").value,
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