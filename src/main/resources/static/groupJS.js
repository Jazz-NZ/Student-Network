
let div = document.createElement("div");
//div.innerHTML += "<h1> NASLOV</h1>"



//i should separate js files better
function showPosts(){


    let posts = JSON.parse(localStorage.getItem('posts'));
    //document.writeln(posts);


    console.log("Loaded from local storage");
    console.log("Group id" + localStorage.getItem("groupID"));
    for (let i = 0; i<posts.length; i++){


        div.innerHTML += "<div class=\"row\">" +
            "<div class=\"col-12 col-md-8\">"+
            "<div class=\"list-group\">\n" +
            "            <a class=\"list-group-item list-group-item-action active\" aria-current=\"true\">\n" +
            "                <div class=\"d-flex w-100 justify-content-between\">\n" +
            "                    <h5 class=\"mb-1\">"+posts[i].groupName+"</h5>\n" +
            "                    <small>3 days ago</small>\n" +
            "                </div>\n" +
            "                <p class=\"mb-1\">"+posts[i].text+"</p>\n" +
            "                <small>And some small print.</small>\n" +
            "            </a>\n" +
            "\n" +
            "        </div>\n"+
            "</div>"+
            "</div>"
      //  document.writeln(posts[i].text);
       // createListElement(posts[i].text);
    }
}
showPosts();

document.body.appendChild(div);

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

/*let into = $('#result');

function createListElement(text) {
    let el = $('<li></li>').html(text);
    el.appendTo(into);
}*/
