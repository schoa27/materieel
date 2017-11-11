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

function openWindow(param) {
    window.open(param, 650, 400);
    window.o

}