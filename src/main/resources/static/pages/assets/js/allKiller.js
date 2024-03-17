
const containerDescription = document.getElementById("card-descr")
const $containerCards = document.querySelector(".container-cards")
console.log($containerCards.clientHeight)


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
    error => console.log(error)
 )


// console.log(allKiller)
//  const template = generateTemplate (allKiller)
// setCards(template,$containerCards)


// console.log($containerCards.clientHeight)


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
  
    setTimeout(() => {
       
    if( container.clientHeight > window.innerHeight ){

        container.style.overflow = 'scroll' 
        container.style['overflow-x'] = ' hidden'
    }
      }, 35);
      
    
    console.log(container.clientHeight)
    console.log(window.innerHeight)

}

        // container.style.gap ="5px"
