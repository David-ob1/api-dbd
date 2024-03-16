
const containerDescription = document.getElementById("card-descr")

let allKiller
let descriptionImg 

let endpointGet = "/api/killers/all"
fetch(endpointGet)
 .then(response => response.json())
 .then(data =>{
     allKiller = data
     console.log(allKiller)
   

     const template = generateTemplate (allKiller)
     setCards(template,$containerCards)

 const cards = document.querySelectorAll(".card")

     cards.forEach(card => {
        card.addEventListener("click", () => {
    
            descriptionImg = `<img src="./assets/images/${card.id}.jpg" alt="" />`
            containerDescription.innerHTML  = descriptionImg
            
        })
    })

 } )
 .catch(
    error => alert(error)
 )


// console.log(allKiller)
//  const template = generateTemplate (allKiller)
// setCards(template,$containerCards)


// console.log($containerCards.clientHeight)
const $containerCards = document.querySelector(".container-cards")
scroll($containerCards)
function scroll ($containerCards){

    // alert("hola")
    if( $containerCards.clientHeight > window.innerHeight ){
        $containerCards.style.overflow = 'scroll' 
        $containerCards.style['overflow-x'] = ' hidden'
        $containerCards.style.gap ="5px"
    }


}


function generateTemplate (array){
    console.log(array)
    let template = ""
     for( item of array){
            template += createCard(item)
    
        }

       return template
}


function createCard (killer){
    return`
    <div class="card" id="${killer.name}">
    <p class="name-killer">${killer.name}</p>
    <figure>
      <img src="./assets/portada/${killer.name}.jpg" alt="" />
    </figure>
  </div>
    `
}






function setCards(template,container){
    
    container.innerHTML += template
}