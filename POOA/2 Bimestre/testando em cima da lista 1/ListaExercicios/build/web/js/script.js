let comboTipo = document.querySelector("#cbTipo")

comboTipo.onchange = (t) =>{
    //console.log(e)
    console.log("alterou "+t.target.value)
    
    fetch("getModelos?tipo="+t.target.value)
   .then( response => response.text())
   .then( (response)=>{
       let modelos = document.querySelector("#cbModelo")
       modelos.innerHTML = ""
        console.log(response)
        response.split(";").map( (mod)=>{
            console.log(mod)
            let opt = document.createElement("option")
            opt.innerHTML = mod
            modelos.appendChild(opt)
        })
        
    })
    
}


