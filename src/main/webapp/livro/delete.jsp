[16:09] ISAQUE KATAHIRA
    

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPEhtml>
<htmllang="pt-br">
<head>
<metacharset="utf-8"/>
<metaname="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Remover Livro</title>
<linkhref="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"crossorigin="anonymous">
</head>
<body>
<mainclass="container">
<h1>Remover Livro</h1>
<hr/>
<p>Tem certeza que deseja remover o livro <em>"${​​​​​​​livro.titulo}​​​​​​​"</em> ?</p>
<formaction="/livro/delete"method="post">
<inputtype="hidden"name="id"value="${​​​​​​​livro.id}​​​​​​​"/>
<ahref="/livro/list"class="btn btn-primary">Voltar</a>
<inputtype="submit"value="Remover"class="btn btn-danger"/>
</form>
</main>
 
<scriptsrc="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"crossorigin="anonymous"></script>
<scriptsrc="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"crossorigin="anonymous"></script>
</body>
</html>
