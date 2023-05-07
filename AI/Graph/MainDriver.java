public class MainDriver {
    public static void main(String[]args){
        GraphTraversal gt = new GraphTraversal();

       gt.addPlace("JY Square Mall", 10.33060255758329f, 123.89886501417799f);
       gt.addPlace("Bigdaddy", 10.329066813706893f, 123.90267375084049f);
       gt.addPlace("Palawan Pawnshop Lahug", 10.326459726128025f, 123.9070135649985f);
       gt.addPlace("Leona's Cakes & Pastries", 10.320949939575248f, 123.91075792874852f);
       gt.addPlace("Wakamatsu Yakiniku Japanese", 10.321868244022005f, 123.91300025540333f);
       gt.addPlace("Joed's Lutong Hapon", 10.323979278562906f, 123.9150494630161f);
       gt.addPlace("Citi Park Hotel", 10.325771008071678f, 123.91710403504936f);
       gt.addPlace("TANCOR 1 Residential Suites", 10.326520417656546f, 123.91259792406838f);
       gt.addPlace("RGM Footwear Trading", 10.326114047915128f, 123.90751782014905f);
       gt.addPlace("Helen's Native Lechon", 10.327473009702983f, 123.90825542763314f);

       gt.addPlace("Jackoo Agri - Feeds", 10.330200437697536f, 123.90032323499469f);
       gt.addPlace("Anita's Bakeshop Main", 10.332421694457574f, 123.90162971430925f);
       gt.addPlace("Club Serena Resort", 10.332959352793626f, 123.90105107219252f);
       gt.addPlace("U-Kitchen", 10.334072886013773f, 123.90156873852617f);
       gt.addPlace("Carleth Cuarto Boarding House", 10.333368352417878f, 123.9025477448045f);
       gt.addPlace("Julie's Bakeshop Salinas", 10.331296961730096f, 123.89805236262977f);
       gt.addPlace("Salinas Residences", 10.33355042303293f, 123.89557400153207f);
       gt.addPlace("The Second Cup Coffee", 10.331827344583091f, 123.90006804264812f);
       gt.addPlace("Sugbo Centro", 10.327079259956882f, 123.90604348635095f);
       gt.addPlace("Metro Supermarket IT Park", 10.329897441241487f, 123.90756966326776f);

        gt.connect("Salinas Residences", "Julie's Bakeshop Salinas");
        gt.connect("JY Square Mall", "Julie's Bakeshop Salinas");
        gt.connect("JY Square Mall", "The Second Cup Coffee");
        gt.connect("Club Serena Resort", "The Second Cup Coffee");
        gt.connect("Club Serena Resort", "U-Kitchen");
        gt.connect("Club Serena Resort", "Anita's Bakeshop Main");
        gt.connect("Carleth Cuarto Boarding House", "U-Kitchen");
        gt.connect("Carleth Cuarto Boarding House", "Anita's Bakeshop Main");
        gt.connect("Jackoo Agri - Feeds", "Anita's Bakeshop Main");
        gt.connect("Anita's Bakeshop Main", "Jackoo Agri - Feeds");
        gt.connect("JY Square Mall", "Jackoo Agri - Feeds");
        gt.connect("Bigdaddy", "Jackoo Agri - Feeds");
        gt.connect("Bigdaddy", "Sugbo Centro");
        gt.connect("Metro Supermarket IT Park", "Sugbo Centro");
        gt.connect("Palawan Pawnshop Lahug", "Sugbo Centro");
        gt.connect("Palawan Pawnshop Lahug", "RGM Footwear Trading");
        gt.connect("Helen's Native Lechon", "RGM Footwear Trading");
        gt.connect("Leona's Cakes & Pastries", "RGM Footwear Trading");
        gt.connect("Leona's Cakes & Pastries", "Wakamatsu Yakiniku Japanese");
        gt.connect("Joed's Lutong Hapon", "Wakamatsu Yakiniku Japanese");
        gt.connect("Joed's Lutong Hapon", "TANCOR 1 Residential Suites");
        gt.connect("Joed's Lutong Hapon", "Citi Park Hotel");

        System.out.println("Adjacency List\n--------------");
        gt.displayAdjacencyList();
        System.out.println();

        System.out.println("BFS result\n----------");
        gt.breadthFirstSearch("Carleth Cuarto Boarding House", "JY Square Mall");
        System.out.println();

        System.out.println("DFS result\n----------");
        gt.depthFirstSearch("Carleth Cuarto Boarding House", "JY Square Mall");
        System.out.println();

        System.out.println("DFS Recursive result\n---------------------");
        gt.depthFirstSearchRecursive("Carleth Cuarto Boarding House", "JY Square Mall");
        System.out.println();

        System.out.println("GBFS result\n-----------");
        gt.greedyBestFirstSearch("Carleth Cuarto Boarding House", "JY Square Mall");
        System.out.println();
        
        System.out.println("A* result\n---------");
        gt.aStar("Carleth Cuarto Boarding House", "JY Square Mall");
    }
}