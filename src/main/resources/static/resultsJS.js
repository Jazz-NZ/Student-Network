
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

function myFunction(groupID){


    // alert(groupID);

    //vraca objekte koji treba da se smeste u
    /*

        const userAction = async () => {
            const response = await fetch('http://localhost:8085/group/'+groupID);
            const myJson = await response; //extract JSON from the http response
            // do something with myJson

            document.writeln(groupID);
            document.writeln(response.body.toString());
        }
        userAction();
    */



    // location.replace("./group.html");
    location.href = "group.html";
    let request = new XMLHttpRequest();
    request.open("GET", 'http://localhost:8085/'+groupID);
    request.send();
    request.onload = ()=>{
        //console.log(request.responseText);
        let posts = JSON.parse(request.responseText);

        if(request.status === 200){
            console.log("Json is loaded");



            localStorage.setItem('posts', JSON.stringify(posts));
        }
        else{
            console.log('error on getting json '+request.status);
        }
    }

}
