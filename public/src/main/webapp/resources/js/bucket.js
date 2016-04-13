
//Добавление товара в корзину
function addBucket(id) {
    $.ajax({
        url: "/cart/addProduct",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            alert('Товар успешно добавлен в корзину');
            return true;
        }
    })
}
//Удаление товара из корзины
function deleteProduct(id) {
    $.ajax({
        url: "/cart/deleteProduct",
        type: "POST",
        data: {
            id: id
        },
        success: function () {
            window.location.href = "/cart";
            // alert('Удалено');
            return true;
        }
    })
}
// Изменение количества товаров в корзине
function changeNumberProduct(id) {
    var numberProduct = $('#numberProduct'+id).val();
    $.ajax({
        url: "/cart/changeNumberProduct",
        type: "POST",
        data: {
            id: id,
            number: numberProduct
        },
        success: function () {
            alert('Изменено');
            return true;
        }
    })
}
