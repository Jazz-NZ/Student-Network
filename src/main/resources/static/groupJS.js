




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
     let proba =  document.getElementById("postArea").value;
     //treba sacuvati ime grupe koja je otvorena
     alert(proba);
}