var owner = document.getElementById('owner'),
    catalog = document.getElementById('catalog'),
    dcc = document.getElementById('dcc'),
    br = document.getElementById('br');


function enableToggle(current, other) {
    other.disabled = current.value.replace(/\s+/, '').length > 0;
}

owner.onkeyup = function () {
    enableToggle(this, catalog);
    enableToggle(this, dcc);
    enableToggle(this, br);
}

catalog.onkeyup = function () {
    enableToggle(this, owner);
    enableToggle(this, dcc);
    enableToggle(this, br);
}

dcc.onkeyup = function () {
    enableToggle(this, owner);
    enableToggle(this, catalog);
    enableToggle(this, br);
}

br.onkeyup = function () {
    enableToggle(this, owner);
    enableToggle(this, catalog);
    enableToggle(this, dcc);
}
