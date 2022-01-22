$(document).ready(function () {
 $("#id").val("0");
	$.ajax({
		url: "Scontroller",
		data: { op: "load" },
		method: 'POST',
		success: function(data, textStatus) {
			remplir(data);
		},
		error: function(data, textStatus) {
			console.log(textStatus);
		}
	});
	
	
	 $("#add").click(function () {
    var id = $("#id").val();
        var code = $("#code").val();
        var type  = $("#type").val();
       
        $.ajax({
            url: "Scontroller",
            data: {id: id, code: code,  type: type },
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
                $("#code").val('');
               
                $("#type").val('');
                $("#id").val("0");
                
               
                 
                  
               
               

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });
     $("#content").on("click", ".update", function () {
        var id = $(this).closest('tr').find('td').eq(0).text();   
        $.ajax({
            url: "Scontroller",
            data: {id: id, op: "update"},
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                $('input[name=id]').val(data.id);
                $('input[name=code]').val(data.code);
                 $('input[name=type]').val(data.type);
                
               
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });
    
    
    $("#content").on("click", ".delete", function () {
        
        var id = $(this).closest('tr').find('td').eq(0).text();        
        $.ajax({
        url: "Scontroller",
        data: {op: "delete", id:id},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            $('input[name=id]').val("0 ");
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
    });
	
	  function remplir(data) {
        var ligne = "";
        for (var i = 0; i < data.length; i++) {
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].code + "</td><td>" + data[i].type +  "</td><td><button class='delete btn btn-danger btn-rounded btn-icon' val='" + data[i].id + "'><i class='bi bi-trash'></i></button></td><td><button class='update btn btn-info btn-rounded btn-fw' val='" + data[i].id + "'><i class='bi bi-box-arrow-in-up-left'></i></button></td></tr>";
        }
        $("#content").html(ligne);
    }

});