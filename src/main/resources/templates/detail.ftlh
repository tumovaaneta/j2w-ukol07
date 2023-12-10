[#ftl]
[@c.page title="detail"]
    <div class="detail">
        <div class="post">
                    <div class="author">${detail.author}</div>
                    <div class="title">${detail.title}</div>
                    <div class="perex">${detail.perex}</div>
                    <div class="body">${detail.body?no_esc}</div>
                    <div class="published">${detail.published?date?string}</div>
        </div>

        [@c.back /]
    </div>
[/@c.page]
