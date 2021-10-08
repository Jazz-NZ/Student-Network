




//i should separate js files better
function showPosts(){


    let posts = JSON.parse(localStorage.getItem('posts'));
    //document.writeln(posts);
    for (let i = 0; i<posts.length; i++){
        document.writeln(posts[i].text);
    }
}
showPosts();

function handleSubmit(){
     let postText =  document.getElementById("postArea").value;
     let groupID = localStorage.getItem('groupID');
     let userID = localStorage.getItem('userID');

     sendRequest(userID,groupID,postText);

     //treba sacuvati ime grupe koja je otvorena

}

function sendRequest(userID,groupID,postText){
    let request = new XMLHttpRequest();
    request.open("GET", 'http://localhost:8085/post/'+userID+'/'+groupID+'/'+postText);
    request.send();
    request.onload = ()=>{
        //console.log(request.responseText);
        let posts = JSON.parse(request.responseText);

        if(request.status === 200){
            console.log("Json is loaded");

        }
        else{
            console.log('error on getting json '+request.status);
        }
    }
}