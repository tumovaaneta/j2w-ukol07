[#ftl]

[#macro page title]
    <!DOCTYPE html>
    <html lang="cs">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${title}</title>
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
    </head>
    <body>
    <main class="container">
        [#nested]
    </main>
    </body>
    </html>
[/#macro]


[#macro input name label type="text" attributes...]
    <div class="row">
        <label for="${name}">${label}</label>
        <input type="${type}" id="${name}" name="${name}" value="${bind[name]!}" [@attrs attributes /]>
        [@errors name=name /]
    </div>
[/#macro]

[#macro back]
    <nav>
        <a href="/post">◂ zpět na úvod</a>
    </nav>
[/#macro]
