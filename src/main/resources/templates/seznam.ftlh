[#ftl]
[@c.page title="Přehled zápisků"]
    <h1>Přehled zápisků</h1>

    [#list seznam]
        <table class="u-full-width">
            <thead>
            <tr>
                <th>Titulek</th>
                <th>Perex</th>
                <th>Datum publikování</th>
                <th>Autor</th>
            </tr>
            </thead>
            <tbody>
            [#items as post]
                <tr>
                    <td>${post.title}</td>
                    <td>${post.perex}</td>
                    <td>${post.published?date?string}</td>
                    <td>${post.author}</td>
                    <td>
                            <nav>
                                <a href="/post/${post.slug}">◂ PŘEČÍST</a>
                            </nav>
                    </td>
                </tr>
            [/#items]
            </tbody>
        </table>
    [#else]
        <div>Seznam je prázdný.</div>
    [/#list]


[/@c.page]
