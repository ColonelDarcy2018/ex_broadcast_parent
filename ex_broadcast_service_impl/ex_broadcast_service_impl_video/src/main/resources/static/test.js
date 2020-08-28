$(function () {
    findAllAjax();


});



function findAllAjax() {
    $.ajax({
        type:"POST",
        url:"/findAll",
        success:function (data) {
            let html="";
            for (let i = 0; i < data.length; i++) {
                let obj=data[i];
                html+='<tr>'+
                    '            <td width="80">'+obj.app+'</td>'+
                    '            <td width="80">'+obj.stream+'</td>'+
                    '            <td width="80" class="f_path">'+obj.file+'</td>'+
                    '        </tr>';
            }
            $("#mainTable").html(html);

            $(".f_path").click(function () {
                toVideoPlay($(this).html());
            });

        }
    })
}

function toVideoPlay(file) {
    window.location.href='/toVideoPlay?file='+file
}







