let king = {};

king.defaultTableRender = function (url, cols) {
    return {
        url: url,
        cols: cols,
        elem: '#currentTableId',
        toolbar: '#toolbarDemo',
        defaultToolbar: ['filter', 'exports', 'print'],
        limits: [25, 50, 100],
        limit: 50,
        page: true,
        skin: 'line'
    }
};

king.getAge = function (birthday) { //yyyy-mm-dd
    return parseInt("" + new Date().getFullYear()) - parseInt(("" + birthday).substring(0, 4));
};

king.getGenderIcon = function (gender) {
    return gender === 1 ?
        '<i class="layui-icon layui-icon-male" style="color: #0000FF;"></i>' :
        '<i class="layui-icon layui-icon-female" style="color: #F581B1;"></i>'
};

king.getLayerDefaultArgs = function (title, url, end) {
    return {
        title: title,
        type: 2,
        shade: 0.2,
        maxmin: true,
        shadeClose: true,
        area: ['100%', '100%'],
        content: url,
        end: end
    }
};
