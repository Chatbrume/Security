package eu.ensup.demoprovider;

public class Launcher
{
    public static void help()
    {
        System.out.println("DemoProvider");
        System.out.println("");
        System.out.println("usage: java DemoProvider.jar [-h | --help] [-all | --all_algo]");
        System.out.println("                         [-nb <type> | --nb_algo <type>]");
        System.out.println("                         [-ls <type> | --list_algo <type>]");
        System.out.println("");
        System.out.println(" -h, --help");
        System.out.println("");
        System.out.println(" -all, --all_algo");
        System.out.println("    Display all algorithme disponble !");
        System.out.println("");
        System.out.println(" -nb, --nb_algo <type>");
        System.out.println("    Display the number of algorythme disponible for this type");
        System.out.println("");
        System.out.println(" -ls, --list_algo <type>");
        System.out.println("    Display the list of algorythme disponible for this type");
    }

    public static void main(String[] args)
    {
        for(int i=0; i<args.length; i++)
        {
            String arg = args[i];
            if(arg.equals("-h") || arg.equals("--help"))
            {
                help();
                break;
            }
            else if(arg.equals("-all") || arg.equals("--all_algo"))
            {
                DemoService.getAllService();
                break;
            }
            else if(arg.equals("-nb") || arg.equals("--nb_algo"))
            {
                if( i+1 < args.length )
                    DemoService.getNbServiceByType(args[i+1]);
                else
                    System.out.println("The argument [-nb, --nb_algo] need a second argument !");
                break;
            }
            else if(arg.equals("-ls") || arg.equals("--list_algo"))
            {
                if( i+1 < args.length )
                    DemoService.getListServiceByType(args[i+1]);
                else
                    System.out.println("The argument [-ls, --list_algo] need a second argument !");
            }
        }
    }
}
