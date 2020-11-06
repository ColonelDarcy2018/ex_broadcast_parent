$(function () {
    findAllAjax();
    findLiveChannelAjax();


    $(".input_btn").click(function () {

        let type=$(this).attr("data-type");
        if(type=="hls"){
            toHlsStream($(this).prev().val());
        }else if(type="rtmp"){
            toStream($(this).prev().val());
        }

    });


    $(".rtmp_channel").click(function () {
        toStream($(this).html());
    });
    $(".hls_channel").click(function () {
        toHlsStream($(this).html());
    });

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


function findLiveChannelAjax() {
    $.ajax({
        type:"POST",
        url:"/findLiveChannel",
        success:function (data) {
            let html="";
            for (let i = 0; i < data.length; i++) {
                let obj=data[i];
                html+='<tr>'+
                    '            <td width="80" class="live_channel">'+obj+'</td>'+
                    '        </tr>';
            }
            $("#liveTable").html(html);

            $(".live_channel").click(function () {
                toLivePlay($(this).html());
            });

        }
    })
}


function toLivePlay(channel) {
    window.location.href='/toLivePlay?channel='+channel
}

function toStream(channel) {
    window.location.href='/toStream?channel='+channel
}

function toHlsStream(channel) {
    window.location.href='/toHlsStream?channel='+channel
}






