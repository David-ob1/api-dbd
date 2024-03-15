const cards = document.querySelectorAll(".card")
const containerDescription = document.getElementById("card-descr")
let descriptionImg 

let endpointGet = "/api/killers/all"
fetch(endpointGet)
 .then(response => response.json())
 .then(data =>{
    let killers = data

    console.log(killers)
 } )
 .catch()


cards.forEach(card => {
    card.addEventListener("click", () => {

        descriptionImg = `<img src="./assets/images/${card.id}.jpg" alt="" />`
        containerDescription.innerHTML  = descriptionImg
        
    })
})

const $containerCards = document.querySelector(".container-cards")
console.log($containerCards.clientHeight)

if( $containerCards.clientHeight > window.innerHeight ){
    $containerCards.style.overflow = 'scroll' 
    $containerCards.style['overflow-x'] = ' hidden'
    $containerCards.style.gap ="5px"
}


function generateTemplate (killer){
    return`
    <div class="card" id="${killer.name}">
    <p class="name-killer">${killer.name}</p>
    <figure>
      <img src="./assets/portada/${killer.name}.jpg" alt="" />
    </figure>
  </div>
    `
}

function setCards(cards,container){
    
}