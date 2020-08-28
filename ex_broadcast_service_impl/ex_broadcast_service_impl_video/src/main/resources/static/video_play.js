$(function () {

alert($("#f_path").val());

});


var myVideo=document.getElementById("video");

function playPause()
{
    if (myVideo.paused)
        myVideo.play();
    else
        myVideo.pause();
}

function makeBig()
{
    myVideo.width=1600;
    myVideo.height=1000;
}

function makeSmall()
{
    myVideo.width=320;
    myVideo.height=240;
}

function makeNormal()
{
    myVideo.width=800;
    myVideo.height=600;
}