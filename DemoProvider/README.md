# Applicatiuon

Possibilities:
```text
DemoProvider

usage: java DemoProvider.jar [-h | --help] [-all | --all_algo]
                         [-nb <type> | --nb_algo <type>]
                         [-ls <type> | --list_algo <type>]

 -h, --help

 -all, --all_algo
    Display all algorithme disponble !

 -nb, --nb_algo <type>
    Display the number of algorythme disponible for this type

 -ls, --list_algo <type>
    Display the list of algorythme disponible for this type
```

## Exercices

La liste de tout les types et leurs algorithmes:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -all`<br/>

Le nombre d’algorithmes de type Chiffrement (Cipher) disponible:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -nb Cipher`<br/>

Le nombre d’algorithmes de type génération de clé (KeyGenerator) disponible:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -nb KeyGenerator`<br/>

Le nombre d’algorithmes de type Code d’Authentification de Message (Mac) disponible:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -nb Mac`<br/>

Le nombre d’algorithmes de type Fabrique de clé (KeyFactory) disponible:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -nb KeyFactory`<br/>

Le nombre d’algorithmes de type Fabrique de clé secrète (SecretKeyFactory) disponible:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -nb SecretKeyFactory`<br/>

Le nombre d’algorithmes de type Stockage de clés(KeyStore) disponible:<br/>
`java -jar Security-1.0-SNAPSHOT.jar -nb KeyStore`<br/>

## Definition

Secure Hash Algorithm (SHA)