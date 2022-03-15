package eu.ensup.demoprovider;

import java.security.Provider;
import java.security.Security;
import java.security.Provider.Service;

public class DemoService
{
    /**
     * @see <a href="http://objis.com/tutoriel-securite-java-initiation-cryptographie-avec-java-8/"> Lien tuto </a>
     */
    public static void getAllService()
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

    public static void getListServiceByType(String type)
    {
        Provider provider = Security.getProvider("SunJCE");

        System.out.println("Liste des algorithmes de type "+type+" disponible: ");

        for(Service service : provider.getServices())
            if( service.getType().equals(type) )
                System.out.println("\t"+service.getType()+" "+service.getAlgorithm());
    }

    public static void getNbServiceByType(String type)
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