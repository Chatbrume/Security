# DemStructsSecurte

[Lien vers le tp](https://objis.com/tutoriel-securite-declarative-jee-avec-jaas)

## Questions sur la sécurité J2EE

Qu’est ce que JAAS ?

— > Spécification Java pour gérer authentification et autorisation d’une applications web Java

Quelle différence entre Authentification et Autorisation

— > Authentification : vérif login et pwd OK, –> Autorisation –> Vérif que l’utilisateur a le bon role métier pour accéder.

Qu’est ce qu’un Realm ? Donner un exemple de Realm

— > Realm = royaume d’autentification = lieu de stockage des infos logi/pwd/role. Exemlple : dans un fichier (UserDataBAseRealm), dans une base de données non JNDI (JDBCRealm) dans une base de données DataSourceJNDI (JNDIRealm), Dans un annuaire LDAP (LDAPRealm)

Où déclare t’on un Realm ?

— > Coté serveur

— > Cela dépend du serveur

— > Dans Tomcat , on peut le faire dans 2 endroits : server.xml (mauvaise pratique car fichier très sensible) ou context.xml (bonne pratique. On y retrouve essentiellement 2 types de ressources : database + Realm Database)

— A quoi sert la balise ‘security-constraint’ ? Ou se trouve t’elle ?

— > dans web.xml

Précisez ce qu’est une authentification de type FORM dans J2EE

— > Exemple de réponse à la question COMMENT (dans web.xml, balise ‘auth-method’): on soumet un formulaire ‘normalisé’ à l’utilisateur : le champ ‘j_username’ pour login, le champ ‘j_password’ pour mdp , et l’action est ‘j_security_check’

## Création de la base de données

Créé une base de donner puis crée ces deux tables.
```sql
CREATE TABLE users (
        name VARCHAR(32),
        password VARCHAR(32)
);
CREATE TABLE roles (
        name VARCHAR(32),
        role VARCHAR(32)
);
```

Dans tomcat/conf/context.xml ajouter
```xml
    <Resource name="jdbc/demostrutssecurite" auth="Container" type="javax.sql.DataSource" maxActive="100" maxIdle="30" maxWait="10000" username="root" password="" driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/demostrutssecurite autoReconnect=true" />

    <Realm className="org.apache.catalina.realm.DatasourceRealm" dataSourceName="jdbc/demostrutssecurite" localDataSource="true" userTable="users" userRoleTable="roles" userNameCol="name" userCredCol="password" roleNameCol="role" />
```

```xml
    <security-constraint>
        <display-name>Test d'authentification Tomcat</display-name>
        <!-- Listes des pages a protégées -->
        <web-resource-collection>
            <web-resource-name>Page sécurisée</web-resource-name>
            <url-pattern>/admin/*</url-pattern>
        </web-resource-collection>
        <!-- Rôles des utilisateurs ayant le droit d'y accéder -->
        <auth-constraint>
            <role-name>admin</role-name>
        </auth-constraint>
    </security-constraint>
    <login-config>
        <!-- Type d'authentification -->
        <auth-methode>FORM</auth-methode>
        <realm-name>Espaces membres</realm-name>
        <form-login-congif>
            <form-login-page>/login.jsp</form-login-page>
            <form-error-page>/error.jsp</form-error-page>
        </form-login-congif>
    </login-config>
    <!-- Rôles utilisés dans l'application -->
    <security-role>
        <description>Administrateur</description>
        <role-name>admin</role-name>
    </security-role>
```