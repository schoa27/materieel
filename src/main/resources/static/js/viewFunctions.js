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

function selectLanguage() {
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
}
//
// function toggleInputs() {
//     var inputs = document.getElementById('zoek');
//     for (var i = inputs.length, n = 0; n < i; n++) {
//         inputs[n].disabled = !inputs[n].disabled;
//     }
// }

