package eu.ensup.demoprovider;

import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

public class DemoProvider
{
    public static void getNbProviders()
    {
        System.out.println("Il y a "+Security.getProviders().length+" providers");
    }

    public static void getListProviders()
    {
        System.out.println("Providers:");

        for(Provider provider : Security.getProviders())
        {
            System.out.println("\t"+provider.getName());
        }
    }

    public static void getinformationProvider(String providerName)
    {
        System.out.println("Information sur le provider "+providerName);
        Provider provider = Security.getProvider(providerName);

        if( provider != null )
        {
            System.out.println("\tInfo"+provider.getInfo());
            System.out.println("\tNb services: "+provider.getServices().size());

            System.out.println("\tServices:");

            Map<String,Integer> mapServices = new HashMap<>();
            provider.getServices().forEach(service -> {
                if( mapServices.containsKey(service.getType()) )
                    mapServices.replace(service.getType(), mapServices.get(service.getType())+1);
                else
                    mapServices.put(service.getType(), 1);
            });

            mapServices.forEach((key, value) -> {
                System.out.println("\t"+key+": "+value);
            });
        }
    }

    /**
     * @see <a href="http://objis.com/tutoriel-securite-java-initiation-cryptographie-avec-java-8/"> Lien tuto </a>
     */
    public static void getAllAlgo()
    {
        // 1. Obtenr un fournisseur de sécurité particulier
        Provider provider = Security.getProvider("SunJCE");

        // 2. Obtenir des informations sur ce fournisseur
        System.out.println("Services du provider "+provider.getName());

        for(Service service : provider.getServices())
        {
            System.out.println("\t"+service.getType()+" "+service.getAlgorithm());
        }
    }

    public static void getNbAlgo(String provierName)
    {
        Provider provider = Security.getProvider("SunJCE");

        // 2. Obtenir des informations sur ce fournisseur
        System.out.println("Le provider "+provider.getName()+" possèdent "+provider.getServices().size()+" services");
    }

    public static void getListAlgoByType(String type)
    {
        Provider provider = Security.getProvider("SunJCE");

        System.out.println("Liste des algorithmes de type "+type+" disponible: ");

        for(Service service : provider.getServices())
            if( service.getType().equals(type) )
                System.out.println("\t"+service.getType()+" "+service.getAlgorithm());
    }

    public static void getNbAlgoByType(String type)
    {
        Provider provider = Security.getProvider("SunJCE");

        System.out.print("Nombre d'algorithmes de type "+type+" disponible: ");

        int nbAlgo = 0;
        for(Service service : provider.getServices())
            if( service.getType().equals(type) )
                nbAlgo++;

        System.out.println(nbAlgo);
    }
}
