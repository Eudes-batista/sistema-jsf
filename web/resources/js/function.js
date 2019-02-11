function upperCase() {   
    var inputs = document.querySelectorAll("input[type=text]");
    inputs.forEach(input => {
        input.onkeyup = function () {
            this.value = this.value.toUpperCase();
        };
    });
}
function mostrarData() {
    var meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"];
    var data = new Date();
    var mes = meses[data.getMonth()];
    var dataFormatada = data.getDate() + " de " + mes + " de " + data.getFullYear();

    return dataFormatada;
}