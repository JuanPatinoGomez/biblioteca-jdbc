const myHttp = new myHTTP();

const btnBuscar = document.getElementById('btn-buscar');
const buscar = document.getElementById('buscar');
const main = document.getElementById('resp');

const selectGenero = document.getElementById("option-genero");


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
            eleA.href = '/libreria/libros/' + response[i].id;
            
            let eleDiv = document.createElement('div');
            eleDiv.className = 'libro'
            
            eleDiv.innerHTML = `
            <img src="${response[i].linkImagen}" alt="">
            <p>${response[i].titulo}</p>
            <p>${response[i].autor.nombre}</p>
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

    const response = await myHttp.POST('/libreria/libros/rest/buscar/titulo', data);
    imprimirRespuesta(response);
}


console.log('hola');


btnBuscar.addEventListener('click', realizarBusqueda);


async function cambioGenero(){
    limpiarHTML();

    const data = {
        genero: parseInt(selectGenero.value)
    }

    console.log(JSON.stringify(data));

    const response = await myHttp.POST('/libreria/libros/rest/buscar/genero', data);
    imprimirRespuesta(response);
}

selectGenero.addEventListener('change', cambioGenero);






