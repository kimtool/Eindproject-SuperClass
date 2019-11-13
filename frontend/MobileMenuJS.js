var picture = "hamburger";
function changeIcon(){
    var img = document.getElementById("menu_icon");
    var background = document.getElementById("body");
    if(picture == "hamburger"){
        //background.src = "../images/afbeeldingen/topbanner80.jpg";
        img.src = "../images/Menu button exit.png";
        picture = "exit";
    }
    else {
        //background.src = "../images/afbeeldingen/DLjGsMPX4AE-0Sy";
        img.src = "../images/Menu button.png";
        picture = "hamburger"
    }
    document.getElementById("menu").classList.toggle("change");
    document.getElementById("nav").classList.toggle("change");    
}