<HTML>
    <HEAD>
        <TITLE> ERREUR !</TITLE>
    </HEAD>
    <body>
        <h1> ERREUR d'AUTHENTIFICATION</h1>
        <p><%= request.getParameter("j_username") %>: <%= request.getParameter("j_password") %></p>
    </body>
</HTML> 