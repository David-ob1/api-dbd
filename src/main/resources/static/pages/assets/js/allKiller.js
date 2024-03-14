const cards = document.querySelectorAll(".card")
const containerDescription = document.getElementById("card-descr")
let descriptionImg 


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
