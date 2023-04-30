public class MainDriver {
    public static void main(String[]args){
        GraphTraversal gt = new GraphTraversal();

        gt.addPlace("Kasambagan", 10.32879895180722, 123.91510966800249);
        gt.addPlace("Banilad", 10.350499371484073, 123.91359317806132);
        gt.addPlace("Apas", 10.337633425847198, 123.90789623654945);
        gt.addPlace("IT Park", 10.331638737183246, 123.90762004809844);
        gt.addPlace("Waterfront", 10.324781234694639, 123.90450429652131);
        gt.addPlace("Lahug", 10.333785378031326, 123.89418879815669);
        gt.addPlace("Landers Superstore", 10.320333100328982, 123.90980518302793);
        gt.addPlace("Express Inn Mabolo", 10.314351145275142, 123.9151680965212);
        gt.addPlace("Radisson Blu", 10.309828845430964, 123.91943242535682);
        gt.addPlace("Casa Gorordo Museum", 10.299754650628861, 123.9048830541922);
        gt.addPlace("Hipodromo", 10.313277252749636, 123.9073600634409);
        gt.addPlace("Ayala Center", 10.31755054516487, 123.90574851186393);
        gt.addPlace("Hostel 7", 10.3131882233197, 123.89582302535685);
        gt.addPlace("Magellan's Cross", 10.293499252888791, 123.90195489652096);
        gt.addPlace("Carbon Market", 10.29140722115207, 123.8991309965211);
        gt.addPlace("Kalubihan", 10.296174995901193, 123.89739642775167);
        gt.addPlace("Sambag I", 10.301293879241358, 123.8930196086511);
        gt.addPlace("Sambag II", 10.305888671696428, 123.89077711583573);
        gt.addPlace("Labangon", 10.299011706821808, 123.88146039203174);
        gt.addPlace("Calamba", 10.30211991307135, 123.88554392544324);

        gt.connect("Banilad", "Kasambagan");
        gt.connect("Banilad", "Apas");
        gt.connect("IT Park", "Apas");

        gt.connect("Waterfront","IT Park");
        gt.connect("Waterfront","Lahug");
        gt.connect("Waterfront","Landers Superstore");

        gt.connect("Landers Superstore", "Ayala Center");
        gt.connect("Landers Superstore", "Express Inn Mabolo");

        gt.connect("Radisson Blu", "Express Inn Mabolo");
        gt.connect("Radisson Blu", "Casa Gorordo Museum");

        gt.connect("Ayala Center", "Hostel 7");
        gt.connect("Ayala Center", "Hipodromo");

        gt.connect("Hipodromo", "Hostel 7");
        gt.connect("Hipodromo", "Express Inn Mabolo");
        gt.connect("Hipodromo", "Casa Gorordo Museum");
        gt.connect("Hipodromo", "Kalubihan");

        gt.connect("Magellan's Cross", "Casa Gorordo Museum");
        gt.connect("Magellan's Cross", "Carbon Market");
        
        gt.connect("Kalubihan", "Carbon Market");
        gt.connect("Kalubihan", "Sambag I");

        gt.connect("Sambag I", "Hostel 7");
        gt.connect("Sambag II", "Hostel 7");
        gt.connect("Sambag I", "Sambag II");
        gt.connect("Sambag I", "Labangon");

        gt.connect("Calamba", "Labangon");
        gt.connect("Calamba", "Sambag II");

        gt.connect("Lahug", "Sambag II");

        System.out.println("Adjacency List\n--------------");
        gt.displayAdjacencyList();
        System.out.println();

        System.out.println("BFS result\n----------");
        gt.breadthFirstSearch("Labangon", "Kasambagan");
        System.out.println();

        System.out.println("DFS result\n----------");
        gt.depthFirstSearch("Labangon", "Kasambagan");
        System.out.println();

        System.out.println("DFS Recursive result\n---------------------");
        gt.depthFirstSearchRecursive("Labangon", "Kasambagan");
        System.out.println();

        System.out.println("GBFS result\n-----------");
        gt.greedyBestFirstSearch("Labangon", "Kasambagan");
        System.out.println();
        
        System.out.println("A* result\n---------");
        gt.aStar("Labangon", "Kasambagan");

        // gt.addPlace("arad", 46.186814826450906, 21.31111915635444);
        // gt.addPlace("bucharest", 44.42529284931483, 26.103561295659105);
        // gt.addPlace("craiova", 44.32990861646529, 23.794991211837168);
        // gt.addPlace("dobreta", 44.6368583545335, 22.66041747859019);
        // gt.addPlace("eforie", 44.04935974811589, 28.652555296543298);
        // gt.addPlace("fagaras", 45.84183516221435, 24.97191241386688);
        // gt.addPlace("giurgiu", 44.42529284931483, 26.103561295659105);
        // gt.addPlace("hirsova", 44.68937146568236, 27.945614235801607);
        // gt.addPlace("Iasi", 47.15704159547589, 27.602760714638514);
        // gt.addPlace("lugoj", 45.69096405805116, 21.902360266653876);
        // gt.addPlace("mehadia", 44.90405942036425, 22.364322960474382);
        // gt.addPlace("neamt", 46.97551611851152, 26.375932682621364);
        // gt.addPlace("oradea", 47.04424911952052, 21.901634244777117);
        // gt.addPlace("pitesti", 44.85608428233382, 24.86955397888502);
        // gt.addPlace("Ramnicu Valcea", 45.099521247171374, 24.368790968616217);
        // gt.addPlace("sibiu", 45.78892543795597, 24.118125865302268);
        // gt.addPlace("timisoara", 45.74677508447357, 21.21498876536231);
        // gt.addPlace("urziceni", 44.717963503060375, 26.645149212299472);
        // gt.addPlace("vaslui", 46.64044182439052, 27.727174648105898);
        // gt.addPlace("zerind", 46.621473636468586, 21.51848606876634);

        // gt.connect("arad", "zerind");
        // gt.connect("arad", "timisoara");
        // // gt.connect("arad", "sibiu");

        // gt.connect("zerind", "oradea");

        // gt.connect("oradea", "sibiu");

        // gt.connect("sibiu", "fagaras");
        // gt.connect("sibiu", "Ramnicu Valcea");

        // gt.connect("fagaras", "bucharest");

        // gt.connect("bucharest", "pitesti");
        // gt.connect("bucharest", "giurgiu");
        // gt.connect("bucharest", "urziceni");

        // gt.connect("urziceni", "vaslui");
        // gt.connect("urziceni", "hirsova");

        // gt.connect("hirsova", "eforie");

        // gt.connect("vaslui", "Iasi");

        // gt.connect("Iasi", "neamt");

        // gt.connect("pitesti", "Ramnicu Valcea");
        // // gt.connect("pitesti", "craiova");

        // gt.connect("craiova", "Ramnicu Valcea");
        // gt.connect("craiova", "dobreta");

        // gt.connect("dobreta", "mehadia");

        // gt.connect("mehadia", "lugoj");

        // gt.connect("lugoj", "timisoara");

        // System.out.println("Adjacency List\n--------------");
        // gt.displayAdjacencyList();
        // System.out.println();

        // System.out.println("BFS result\n----------");
        // gt.breadthFirstSearch("neamt", "timisoara");
        // System.out.println();

        // System.out.println("DFS result\n----------");
        // gt.depthFirstSearch("neamt", "timisoara");
        // System.out.println();

        // System.out.println("DFS Recursive result\n---------------------");
        // gt.depthFirstSearchRecursive("neamt", "timisoara");
        // System.out.println();

        // System.out.println("GBFS result\n-----------");
        // gt.greedyBestFirstSearch("neamt", "timisoara");
        // System.out.println();
        
        // System.out.println("A* result\n---------");
        // gt.aStar("neamt", "timisoara");
    }
}