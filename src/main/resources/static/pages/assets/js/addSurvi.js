const $btnEnviar = document.getElementById("btn-addSurvi")
const endPoint = "/api/survivor/add"

$btnEnviar.addEventListener("click", () =>{

 
    let Survivor = obtenerValores()

console.log(Survivor)
console.log(Survivor)
console.log(Survivor)
console.log(Survivor)

axios(endPoint,Survivor)
.then(response => {
console.log("error")
})
.catch(error => console.log(error))

})


function obtenerValores (){
return{
    name: document.getElementById("Survivor").value,
    perk1: document.getElementById("perk-1").value,
    perk2: document.getElementById("perk-2").value,
    perk3: document.getElementById("perk-3").value
}


}