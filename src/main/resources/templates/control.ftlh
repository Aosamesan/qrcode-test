<#setting url_escaping_charset="UTF-8" />

<#macro Outline>
    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8"/>
        <title>Generate QR Code</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
    <div class="container">
        <h1>Generate QR Code</h1>
        <#nested />
        <form class="input-group mb-3" action="/qrcode">
            <input type="text" class="form-control" placeholder="Input your text" name="text"/>
            <button class="btn btn-outline-secondary" type="submit">Generate</button>
        </form>
    </div>
    </body>
    </html>
</#macro>