package Algorithms.Lesson7;



public class Main {
    public static void main(String[] args) {
        WeighedGraph graph = new WeighedGraph(10);
        fiilGraph(graph);
        testGraph(graph);

        graph.fromAToB("Москва","Воронеж");

    }

    private static void fiilGraph(WeighedGraph graph) {
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");


        graph.addEdge("Москва",new WeighedGraph.AddVertex("Тула",70), new WeighedGraph.AddVertex("Рязань",10),new WeighedGraph.AddVertex("Калуга",65));
        graph.addEdge("Тула",new WeighedGraph.AddVertex("Липецк",95));
        graph.addEdge("Липецк",new WeighedGraph.AddVertex("Воронеж",99));
        graph.addEdge("Липецк",new WeighedGraph.AddVertex("Курск",12));
        graph.addEdge("Рязань",new WeighedGraph.AddVertex("Тамбов",40));
        graph.addEdge("Тамбов",new WeighedGraph.AddVertex("Саратов",66));
        graph.addEdge("Саратов",new WeighedGraph.AddVertex("Воронеж",70));
        graph.addEdge("Калуга",new WeighedGraph.AddVertex("Орел",33));
        graph.addEdge("Орел",new WeighedGraph.AddVertex("Курск",50));
        graph.addEdge("Курск",new WeighedGraph.AddVertex("Воронеж",29));
    }


    private static void testGraph(WeighedGraph graph) {
        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }


}
