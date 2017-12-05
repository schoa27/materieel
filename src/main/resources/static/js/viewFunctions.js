function ChangeColor(tableRow, highLight) {
    if (highLight) {
        tableRow.style.backgroundColor = '#c0c0c0';//#dcfac9
    } else {
        tableRow.style.backgroundColor = '#909090'; //'white';
    }
}

function DetailGegevens(servlet) {
    document.location.href = servlet;
}

function openWindow(param, xsize, ysize) {
    var randomnumber = Math.floor((Math.random()*100)+1);
    window.open(param, "_blank", 'PopUp', randomnumber, xsize, ysize);
}