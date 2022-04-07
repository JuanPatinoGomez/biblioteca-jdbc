const myHttp = new myHTTP();

const btnBuscar = document.getElementById('btn-buscar');
const buscar = document.getElementById('buscar');
const main = document.getElementById('resp');



function limpiarHTML(){

    main.innerHTML = '';
}


function imprimirRespuesta(response){

    console.log(response);
    
    let fragmento = document.createDocumentFragment();
    
    if(response.length != 0){

        for (let i = 0; i < response.length; i++) {
            console.log(response[i]);
    
            let eleA = document.createElement('a');
            eleA.href = '/libreria/autores/' + response[i].idAutor + "/libros";
            
            let eleDiv = document.createElement('div');
            eleDiv.className = 'autor'
            
            eleDiv.innerHTML = `
            <img src="/img/hand-.png" alt="">
            <p>${response[i].nombre}</p>
            `
    
            eleA.appendChild(eleDiv);
    
            fragmento.appendChild(eleA);
    
        }
    
        main.appendChild(fragmento);

    }else{

        main.innerHTML = `<b style="color: red; font-size: 2em;">No se encontraron libros con ese titulo</b>`
    }

    

}

async function realizarBusqueda(){
    limpiarHTML();

    const data = {
        buscador: buscar.value
    }

    console.log(JSON.stringify(data));

    const response = await myHttp.POST('/libreria/autores/rest/buscar/nombre', data);
    imprimirRespuesta(response);
}


console.log('hola');


btnBuscar.addEventListener('click', realizarBusqueda);


