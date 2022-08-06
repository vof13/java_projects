$(function () {

    // $.get('/todos/', function (response) {
    //     if (response.length == 0) {
    //         $('.todos-list').append($('<i>Все дела переделаны </i>'));
    //     } else {
    //         $('.todos-list').append($('<i>Сегодня надо поработать:</i>' ));
    //         for (i in response) {
    //             $('.todos-list').append($('<h5>' + i + ': ' + response[i] + '</h5>'));
    //         }
    //     }
    // })

    $('.save-todo').on('click', function (){
        let todo = $('.add-todo').val();
        $.post('/todos/', {todo: todo}, function (responce){
            if (responce.result) {
                $('.add-todo').val('');
            } else {
                alert('Ошибка ввода');
            }
        })
    });

})