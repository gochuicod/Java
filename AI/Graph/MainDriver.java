public class MainDriver {
    public static void main(String[]args){
        GraphTraversal gt = new GraphTraversal();

            gt.addPlace("arad", 46.186814826450906f, 21.31111915635444f);
            gt.addPlace("bucharest", 44.42529284931483f, 26.103561295659105f);
            gt.addPlace("craiova", 44.32990861646529f, 23.794991211837168f);
            gt.addPlace("dobreta", 44.6368583545335f, 22.66041747859019f);
            gt.addPlace("eforie", 44.04935974811589f, 28.652555296543298f);
            gt.addPlace("fagaras", 45.84183516221435f, 24.97191241386688f);
            gt.addPlace("giurgiu", 44.42529284931483f, 26.103561295659105f);
            gt.addPlace("hirsova", 44.68937146568236f, 27.945614235801607f);
            gt.addPlace("Iasi", 47.15704159547589f, 27.602760714638514f);
            gt.addPlace("lugoj", 45.69096405805116f, 21.902360266653876f);
            gt.addPlace("mehadia", 44.90405942036425f, 22.364322960474382f);
            gt.addPlace("neamt", 46.97551611851152f, 26.375932682621364f);
            gt.addPlace("oradea", 47.04424911952052f, 21.901634244777117f);
            gt.addPlace("pitesti", 44.85608428233382f, 24.86955397888502f);
            gt.addPlace("Ramnicu Valcea", 45.099521247171374f, 24.368790968616217f);
            gt.addPlace("sibiu", 45.78892543795597f, 24.118125865302268f);
            gt.addPlace("timisoara", 45.74677508447357f, 21.21498876536231f);
            gt.addPlace("urziceni", 44.717963503060375f, 26.645149212299472f);
            gt.addPlace("vaslui", 46.64044182439052f, 27.727174648105898f);
            gt.addPlace("zerind", 46.621473636468586f, 21.51848606876634f);

            gt.connect("arad", "zerind");
            gt.connect("arad", "timisoara");
            gt.connect("arad", "sibiu");

            gt.connect("zerind", "oradea");

            gt.connect("oradea", "sibiu");

            gt.connect("sibiu", "fagaras");
            gt.connect("sibiu", "Ramnicu Valcea");

            gt.connect("fagaras", "bucharest");

            gt.connect("bucharest", "pitesti");
            gt.connect("bucharest", "giurgiu");
            gt.connect("bucharest", "urziceni");

            gt.connect("urziceni", "vaslui");
            gt.connect("urziceni", "hirsova");

            gt.connect("hirsova", "eforie");

            gt.connect("vaslui", "Iasi");

            gt.connect("Iasi", "neamt");

            gt.connect("pitesti", "Ramnicu Valcea");
            gt.connect("pitesti", "craiova");

            gt.connect("craiova", "Ramnicu Valcea");
            gt.connect("craiova", "dobreta");

            gt.connect("dobreta", "mehadia");

            gt.connect("mehadia", "lugoj");

            gt.connect("lugoj", "timisoara");

            System.out.println("Adjacency List\n--------------");
            gt.displayAdjacencyList();
            System.out.println();

            System.out.println("BFS result\n----------");
            gt.breadthFirstSearch("arad", "bucharest");
            System.out.println();

            System.out.println("DFS result\n----------");
            gt.depthFirstSearch("arad", "bucharest");
            System.out.println();

            System.out.println("DFS Recursive result\n---------------------");
            gt.depthFirstSearchRecursive("arad", "bucharest");
            System.out.println();

            System.out.println("GBFS result\n-----------");
            gt.greedyBestFirstSearch("arad", "bucharest");
            System.out.println();
            
            System.out.println("A* result\n---------");
            gt.aStar("arad", "bucharest");
    }
}