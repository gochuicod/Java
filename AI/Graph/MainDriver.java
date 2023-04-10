public class MainDriver {
    public static void main(String[] args) {
        GraphTraversal gt = new GraphTraversal();
        gt.addPlace("Labangon");
        gt.addPlace("Calamba");
        gt.addPlace("Sambag I");
        gt.addPlace("Sambag II");
        gt.addPlace("Kalubihan");
        gt.addPlace("Carbon Market");
        gt.addPlace("Magellan's Cross");
        gt.addPlace("Casa Gorordo Museum");
        gt.addPlace("Radisson Blu");
        gt.addPlace("Express Inn Mabolo");
        gt.addPlace("Hipodromo");
        gt.addPlace("Hostel 7");
        gt.addPlace("Ayala Center");
        gt.addPlace("Landers Superstore");
        gt.addPlace("Waterfront");
        gt.addPlace("Lahug");
        gt.addPlace("IT Park");
        gt.addPlace("Apas");
        gt.addPlace("Banilad");
        gt.addPlace("Kasambagan");

        gt.connect("Labangon", "Calamba");
        gt.connect("Labangon", "Sambag I");
        gt.connect("Sambag I", "Sambag II");
        gt.connect("Sambag I", "Kalubihan");
        gt.connect("Sambag I", "Hostel 7");
        gt.connect("Sambag II", "Calamba");
        gt.connect("Sambag II", "Lahug");
        gt.connect("Kalubihan", "Carbon Market");
        gt.connect("Kalubihan", "Hipodromo");
        gt.connect("Carbon Market", "Magellan's Cross");
        gt.connect("Magellan's Cross", "Casa Gorordo Museum");
        gt.connect("Hipodromo", "Hostel 7");
        gt.connect("Hipodromo", "Ayala Center");
        gt.connect("Hipodromo", "Express Inn Mabolo");
        gt.connect("Hipodromo", "Casa Gorordo Museum");
        gt.connect("Casa Gorordo Museum", "Radisson Blu");
        gt.connect("Radisson Blu", "Express Inn Mabolo");
        gt.connect("Express Inn Mabolo", "Landers Superstore");
        gt.connect("Hostel 7", "Ayala Center");
        gt.connect("Ayala Center", "Landers Superstore");
        gt.connect("Landers Superstore", "Waterfront");
        gt.connect("Lahug", "Waterfront");
        gt.connect("Waterfront", "IT Park");
        gt.connect("IT Park", "Apas");
        gt.connect("Apas", "Banilad");
        gt.connect("Banilad", "Kasambagan");

        System.out.println("BFS\n---");
        gt.breadthFirstSearch("Labangon", "Ayala Center");
        System.out.println();
        System.out.println("DFS\n---");
        gt.depthFirstSearch("Labangon", "Ayala Center");
        System.out.println();
        System.out.println("DFS Recursive\n-------------");
        gt.depthFirstSearchRecursive("Labangon", "Ayala Center");
        System.out.println();
        gt.displayAdjacencyList();
    }
}