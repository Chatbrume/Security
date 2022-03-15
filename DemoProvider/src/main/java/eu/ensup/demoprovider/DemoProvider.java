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
}
