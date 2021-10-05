
let loadGroup = -1;

const btn = document.getElementById("joinBtn");

/*btn.addEventListener("click", ()=>{

    const userAction = async () => {
        const response = await fetch('http://localhost:8083/search/FON');
        const myJson = await response.json(); //extract JSON from the http response
        // do something with myJson
        console.log(myJson);
    }

    userAction();
    if(btn.value === "Join"){
        btn.value = "JOINED";


    }



})*/

//arr contains userID and groupID

//u slucaju da je korisnik clan grupe treba namestiti da na dugmetu vec pise join

function kliknuto(arg) {
    // document.getElementById(id).style.backgroundColor = "#F00";

    let argArray = arg.split(',');

    let userID = argArray[0];
    let groupID = argArray[1];




    const userAction = async () => {
        const response = await fetch('http://localhost:8083/join/'+userID+'/'+groupID);
        const myJson = await response; //extract JSON from the http response
        // do something with myJson
        console.log(myJson);
    }

    userAction();
    if(btn.value === "Join"){
        btn.value = "JOINED";


    }



}

