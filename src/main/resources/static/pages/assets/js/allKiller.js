const cards = document.querySelectorAll(".card")





cards.forEach(card => {
    card.addEventListener("click", () => {
        // Función que se ejecutará cuando se haga clic en cada elemento "card"
        console.log(card.id)
        alert(card.id)
    })
})

const $containerCards = document.querySelector(".container-cards")
console.log($containerCards.clientHeight)

if( $containerCards.clientHeight > window.innerHeight ){
    $containerCards.style.overflow = 'scroll' 
    $containerCards.style['overflow-x'] = ' hidden'
}
