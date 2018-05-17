$(document).ready(function () {
    inputs();
});
function inputs() {
    // Para tratar o colar
    jQuery(".form-control").bind('paste', function (e) {
        var el = jQuery(this);
        setTimeout(function () {
            var text = jQuery(el).val();
            el.val(text.toUpperCase());
        }, 1);
    });
    jQuery(".form-control").keypress(function (e) {
        var el = jQuery(this);
        setTimeout(function () {
            var text = jQuery(el).val();
            el.val(text.toUpperCase());
        }, 0);
        if (e.keyCode === 13) {
            $(this).parent().parent().next().find('.form-control').focus();
        }
    });
}



