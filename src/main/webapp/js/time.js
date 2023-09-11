//时间
function fn(){
    var time = new Date();
    var str= "";
    var div = document.getElementById("time");
//    console.log(time);
    var year = time.getFullYear();
    var mon = time.getMonth()+1;
    var day = time.getDate();
    var h = time.getHours();
    var m = time.getMinutes();
    var s = time.getSeconds();
    var week = time.getDay();
    switch (week){
        case 0:week="SUN";
            break;
        case 1:week="MON";
            break;
        case 2:week="TUE";
            break;
        case 3:week="WED";
            break;
        case 4:week="THU";
            break;
        case 5:week="FRI";
            break;
        case 6:week="SAT";
            break;
    }
    str = year +" year "+totwo(mon)+" month "+totwo(day)+" day "+" &nbsp; "+totwo(h)+" : "+totwo(m)+" : "+totwo(s)+" &nbsp; "+" week "+week;
    div.innerHTML = str;
}
fn();
setInterval(fn,1000);
function totwo(n){
    if(n<=9){
        return n = "0"+n;
    }
    else{
        return n =""+n;
    }
}

