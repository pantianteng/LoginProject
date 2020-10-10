var i = 11;
function onTime(){
    i = i - 1;
    document.getElementById("leaveTime").innerHTML = i;
    
    setTimeout("onTime()",1000);
    
}