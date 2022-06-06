

//let comboEstado = document.getElementById("cbEstado")
let comboEstado = document.querySelector("#cbEstado")

comboEstado.onchange = (e) =>{
    //console.log(e)
    console.log("alterou "+e.target.value)
    
    fetch("getCidades?estado="+e.target.value)
   .then( response => response.text())
   .then( (response)=>{
       let cidades = document.querySelector("#cbCidades")
       cidades.innerHTML = ""
        console.log(response)
        response.split(";").map( (cid)=>{
            console.log(cid)
            let opt = document.createElement("option")
            opt.innerHTML = cid
            cidades.appendChild(opt)
        })
        
    })
    
}


