const app = document.getElementById('root')

const logo = document.createElement('img')
logo.src = 'logo.png'
const container = document.createElement('div')
container.setAttribute('class', 'container')

app.appendChild(logo)
app.appendChild(container)


var request = new XMLHttpRequest()

request.open('GET','http://localhost:8080/listings', true)

request.onload = function () {
  // Begin accessing JSON data here
  var data = JSON.parse(this.response)

    console.log('poop1')
      if (request.status >= 200 && request.status < 400) {
        data.forEach(listing => {
          const card = document.createElement('div')
          card.setAttribute('class','card')

          const h1 = document.createElement('h1')
          h1.textContent = listing.productName

          const p = document.createElement('p')
          p.textContent = `${listing.price} Rs`

          container.appendChild(card)

          card.appendChild(h1)
          card.appendChild(p)
          console.log('is this actually doing something?3023039203')

        })
      } else {
        console.log('error')
      }
}
request.send()

/*
fetch('http://localhost:8080/listings-javaconfig')
  .then( response => {
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`);
    }
    return response.json();
  })
  .then( json => initialize(json) )
  .catch( err => console.error(`Fetch problem: ${err.message}`) );
*/