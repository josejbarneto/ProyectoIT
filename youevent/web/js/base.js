/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('.ui.dropdown').dropdown();
    $('.ui.checkbox').checkbox();
    $('.menu-tab .item').tab();

    var $irArriba = $("#ir-arriba");
    $(window).on("scroll", function () {
        if ($(window).scrollTop() > 100) {
            $irArriba.fadeIn();
        } else {
            $irArriba.fadeOut();
        }
    });

    $irArriba.on("click", function () {
        $("html, body").animate({scrollTop: 0}, 875);
    });
});