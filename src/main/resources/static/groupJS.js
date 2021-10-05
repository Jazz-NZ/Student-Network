
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

    let request = new XMLHttpRequest();
    request.open("GET", 'http://localhost:8085/'+groupID);
    request.send();
    request.onload = ()=>{
        //console.log(request.responseText);
        const posts = JSON.parse(request.responseText);

        if(request.status === 200){
           //document.writeln(JSON.parse(request.responseText));

            for (let i = 0; i<posts.length; i++){
                document.writeln(posts[i].text);
            }
        }
       else{
           console.log('error on getting json '+request.status);
        }
    }

}