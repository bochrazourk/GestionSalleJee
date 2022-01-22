$(document).ready(function () {
 $("#id").val("0");
	$.ajax({
		url: "ClientController",
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
        var nom = $("#nom").val();
        var prenom  = $("#prenom").val();
       
        $.ajax({
            url: "ClientController",
            data: {id: id, nom: nom,  prenom: prenom },
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
                $("#nom").val('');
               
                $("#prenom").val('');
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
            url: "ClientController",
            data: {id: id, op: "update"},
            type: 'GET',
            success: function (data, textStatus, jqXHR) {
                $('input[name=id]').val(data.id);
                $('input[name=nom]').val(data.nom);
                 $('input[name=prenom]').val(data.prenom);
                
               
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });
    
    
    $("#content").on("click", ".delete", function () {
        
        var id = $(this).closest('tr').find('td').eq(0).text();        
        $.ajax({
        url: "ClientController",
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
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].nom + "</td><td>" + data[i].prenom +  "</td><td><button class='delete btn btn-danger btn-rounded btn-icon' val='" + data[i].id + "'><i class='bi bi-trash'></i></button></td><td><button class='update btn btn-info btn-rounded btn-fw' val='" + data[i].id + "'><i class='bi bi-box-arrow-in-up-left'></i></button></td></tr>";
        }
        $("#content").html(ligne);
    }

});