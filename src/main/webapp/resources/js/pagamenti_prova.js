$(function () {

    $('#pagamenti-form').validator();

    $('#pagamenti-form').on('submit', function (e) {
        if (!e.isDefaultPrevented()) {
            var url = "/spring-rest-service/api/v1.0/pagamenti";

            $.ajax({
                type: "GET",
                url: url,
                headers: {
                    "authorization_id":"12"
                },
                data: $(this).serialize(),
                success: function (data)
                {
                      console.log(data);
                        // then create your table
                        var results = data.results;
                        for (i = 0; i < results.length; i += 1) {
                          $('#table-content').append(
                            '<tr>' +
                              '<td>' + i + '</td>' +
                              '<td>' + results[i].codicePagamento + '</td>' +
                              '<td>' + results[i].importo + '</td>' +
                              '<td>' + results[i].codiceCausale + '</td>' +
                              '<td>' + results[i].descrizioneCausale + '</td>' +
                            '<td>'
                          );
                        }

                }
            });
            return false;
        }
    })


        $('#creaFileButton').click( function (e) {
            if (!e.isDefaultPrevented()) {
                var url = "/spring-rest-service/api/v1.0/file/pagamenti";


                $.ajax({
                    type: "POST",
                    url: url,
                    headers: {
                            'Content-Type':'application/json'
                        },
                    data: $(this).serialize(),
                    success: function (data)
                    {
                          console.log(data);
                          $('#download-file-div').append(
                          '<a href="/spring-rest-service/api/v1.0/file/pagamenti/'+data.fileName+'" class="btn btn-large">File Creato. Clicca qui per fare il download</a>'
                          )

                    }
                });
                return false;
            }
        })
});
