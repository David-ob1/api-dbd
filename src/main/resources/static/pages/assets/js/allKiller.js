
const containerDescription = document.getElementById("card-descr")
const $containerCards = document.querySelector(".container-cards")
console.log($containerCards.clientHeight)


let allCharacter,descriptionImg ,endpointGet
let isSurvi = false

let endpointKiller = "/api/killers/all"
let endpointSurvi = "/api/survivor/all"



let ruta = window.location.pathname;
 ruta.toLocaleLowerCase().includes("killer") ? endpointGet ="/api/killers/all" : endpointGet = "/api/survivor/all"
 isSurvi = endpointGet == "/api/survivor/all";

fetch(endpointGet)
 .then(response => response.json())
 .then(data =>{
     allCharacter = data
     console.log(allCharacter)
   

     const template = generateTemplate (allCharacter)
     setCards(template,$containerCards)

 const cards = document.querySelectorAll(".card")
 
 
 cards.forEach(card => {
     card.addEventListener("click", () => {
         descriptionImg = `<img src="./assets/images/${card.id}.jpg" alt="" />`

         let pjSelect = allCharacter.find(character => character.name == card.id)
         
        let tabla =  isSurvi ? generateTableSurvi(pjSelect) : generateTableKiller (pjSelect)

         containerDescription.innerHTML  = descriptionImg
         containerDescription.innerHTML += tabla
         
        })
    })
    
    


 } )
 .catch(
    error => console.log(error)
 )


function generateTemplate (array){
    console.log(array)
    let template = ""
     for( item of array){
            template += createCard(item)
    
        }

       return template
}


function createCard (killer){
    let cardClass = isSurvi ? 'card survi' : 'card';

  return  `<div class="${cardClass}" id="${killer.name}">
    <p class="name-killer">${killer.name}</p>
    <figure>
      <img src="./assets/portada/${killer.name}.jpg" alt="" />
    </figure>
  </div>
    `
}


function setCards(template,container){
    
    container.innerHTML += template
  
    setTimeout(() => {
       
    if( container.clientHeight > window.innerHeight ){

        container.style.overflow = 'scroll' 
        container.style['overflow-x'] = ' hidden'
    }
      }, 500);
      
    
    console.log(container.clientHeight)
    console.log(window.innerHeight)

}

    function generateTableKiller (killer){

        return`
        <table class="tabla">
        <tr>
          <td class="dato1">name</td>
          <td class="dato2">${killer.name}</td>
        </tr>
        <tr>
          <td class="dato1">power</td>
          <td class="dato2">${killer.power}</td>
        </tr>
        <tr>
          <td class="dato1">perk-1</td>
          <td class="dato2">${killer.perk1}</td>
        </tr>
        <tr>
          <td class="dato1">perk-2</td>
          <td class="dato2">${killer.perk2}</td>
        </tr>
        <tr>
          <td class="dato1">perk-3</td>
          <td class="dato2">${killer.perk3}</td>
        </tr>
        <tr>
          <td class="dato1">Movement Speed</td>
          <td class="dato2">${killer.speed}</td>
        </tr>

        <tr>
          <td class="dato1">Terror Radius</td>
          <td class="dato2">${killer.terrorRadius}</td>
        </tr>
        <tr>
          <td class="dato1">Height</td>
          <td class="dato2">${killer.height}</td>
        </tr>
      </table>`
        
    }


    function generateTableSurvi (survi){

        return`
            <table class="tabla">
        <tr>
            <td class="dato1">name</td>
            <td class="dato2">${survi.name}</td>
        </tr>
        <tr>
            <td class="dato1">perk-1</td>
            <td class="dato2">${survi.perk1}</td>
        </tr>
        <tr>
          <td class="dato1">perk-2</td>
          <td class="dato2">${survi.perk2}</td>
      </tr>
      <tr>
        <td class="dato1">perk-3</td>
        <td class="dato2">${survi.perk3}</td>
    </tr>`
        
        



    }