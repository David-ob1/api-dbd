
let btn = document.getElementById("btn-addKiller")
let layout = document.querySelector("#layout")



btn.addEventListener("click", e =>{
    e.preventDefault()

  const valores = obtenerValores()
    
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


// function enviarDatos(data, url) {
//     fetch(url, {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify(data)
//     })
//     .then(response => {
//         if (!response.ok) {
//             throw new Error('Network response was not ok');
//         }
//         return response.json();
//     })
//     .then(responseData => {
//         alert("mandando")
//         console.log(responseData);

//         // Puedes agregar aquí más lógica para manejar la respuesta del servidor
//     })
//     .catch(error => {
//         console.error("Hubo un error: ", error);
//         alert("Hubo un error al enviar los datos");
//         // Puedes agregar más lógica para manejar el error de manera adecuada
//     });
// }

// function enviarDatos (data,url){

// fetch(url,{
//     method:"Post",
//     body:JSON.stringify(data)
// })
// .then(response =>response.json())
// .then(responseData =>{

//    console.log(responseData)

// })
// .catch(error =>{
//     console.error("Hubo un error: ",error)
//     alert("hubo un error")

// }
    
// )
        

// }


/*
Ghost Face
Night Shroud
Furtive Chase
I'm All Ears
Thrilling Tremors
average
3.8
32

*/