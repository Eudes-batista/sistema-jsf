$(document).ready(function () {
    $('#characterLeft').text('250 caracteres restantes');
    $('#mensagem').keydown(function () {
        var max = 250;
        var len = $(this).val().length;
        if (len >= max) {
            $('#characterLeft').text('Mensagem com até 250 caracteres.');
            $('#characterLeft').addClass('red');
            $('#btnSubmit').addClass('disabled');
        } else {
            var ch = max - len;
            $('#characterLeft').text(ch + ' caracteres restantes');
            $('#btnSubmit').removeClass('disabled');
            $('#characterLeft').removeClass('red');
        }
    });
});

