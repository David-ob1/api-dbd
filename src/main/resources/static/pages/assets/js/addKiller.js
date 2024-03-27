
let btn = document.getElementById("btn-addKiller")
let layout = document.querySelector("#layout")

btn.addEventListener("click", e =>{
    e.preventDefault()

  const valores = obtenerValores()
  console.log(valores)
    console.log(valores.name)
    console.log(valores.perk1)
    console.log(valores.perk2)
    console.log(valores.perk3)
    console.log(valores.power)
    console.log(valores.height)
    console.log(valores.speed)
    console.log(valores.terrorRadius)
    enviarDatos(valores,"/api/killers/add")    

})

function obtenerValores (){
  
    return {
        name: document.getElementById("killer").value,
        perk1: document.getElementById("perk-1").value,
        perk2: document.getElementById("perk-2").value,
        perk3: document.getElementById("perk-3").value,
        power: document.getElementById("power").value,
        speed: document.getElementById("speed").value,
        height: document.getElementById("height").value,
        terrorRadius: document.getElementById("terrorRadius").value,
    };

}


function enviarDatos (data,url){

axios.post(url,data)
.then(responseData =>{
    console.log(data)
    console.log("mandando")
   console.log(responseData)

})
.catch(error =>{
    console.error("Hubo un error: ",error)
    alert("hubo un error")

}
    
)

}


/*killer
Ghost Face
Night Shroud
Furtive Chase
I'm All Ears
Thrilling Tremors
average
3.8
32



// survivor

Leon
Bite the Bullet
Flashbang
Rookie Spirit
*/