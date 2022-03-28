package Algorithms.Lesson7;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WeighedGraph {
    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;
    private int currentDistance = 0;

    public static class AddVertex {
        public String vertexLabel;
        public Integer weight;

        public String getVertexLabel() {
            return vertexLabel;
        }

        public Integer getWeight() {
            return weight;
        }

        public AddVertex(String vLabel, Integer adjWeight) {
            vertexLabel = vLabel;
            weight = adjWeight;
        }
    }


    public WeighedGraph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }


    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }


    public boolean addEdge(String startLabel, AddVertex vertex) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(vertex.getVertexLabel());

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = vertex.getWeight(); ////////////!!!!
//        adjMatrix[endIndex][startIndex] = true; ////////////!!!!

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public boolean exist(String vertex) {
        return indexOf(vertex) != -1;

    }

    public boolean addEdge(String startLabel, AddVertex secondLabel, AddVertex... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (AddVertex other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }


    public int getSize() {
        return vertexList.size();
    }


    public void display() {
        System.out.println(this);
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    System.out.print(adjMatrix[i][j] + " ");
                } else {
                    System.out.print("-- ");
                }

            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    ///////stopped
    public void fromAToB(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        int resultDistance = 0;
        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Нет доступной информации о городах " + startLabel + " "+ endLabel);
        }

        System.out.println("Начинаем поиск кратчайшего пути между городами " + startLabel + " и "+ endLabel);

        Stack<Vertex> stack = new Stack<>();
        Stack<Vertex> resultVertexList = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {

                incCurrendDistanceBetweenCities(stack.peek(), vertex);


                visitVertex(stack, vertex);
                if (vertex.getLabel().equals(endLabel)) {

                    System.out.print("Найден лучший путь ");
                    showRoad(stack);
                    System.out.println(" дистанция " + currentDistance);

                    resultVertexList = (Stack<Vertex>) stack.clone();
                    resultDistance = currentDistance;

                }
            } else {
                Vertex lastStackElement = stack.peek();
                stack.pop();
                if (currentDistance != 0) {
                    decCurrendDistanceBetweenCities(lastStackElement, stack.peek());
                }

            }
        }
        if (resultDistance > 0) {
            System.out.print("Кратчайший маршрут между городами:  ");
            showRoad(resultVertexList);
            System.out.println(" общая дистанция  = " + resultDistance);

        } else {
            System.out.printf("Между городами %s и %s нет доступного сообщения", startLabel,endLabel);
        }
    }

    private void showRoad(Stack<Vertex> stack) {
        stack.stream().collect(Collectors.toList()).forEach(new Consumer<Vertex>() {
            @Override
            public void accept(Vertex vertex) {
                System.out.print(vertex.getLabel() + "-->");
            }
        });

    }

    private void decCurrendDistanceBetweenCities(Vertex fromVertex, Vertex toVertex) {
        int startIndex = indexOf(fromVertex.getLabel());
        int endIndex = indexOf(toVertex.getLabel());
        currentDistance -= adjMatrix[endIndex][startIndex];
    }

    private void incCurrendDistanceBetweenCities(Vertex fromVertex, Vertex toVertex) {
        int startIndex = indexOf(fromVertex.getLabel());
        int endIndex = indexOf(toVertex.getLabel());
        currentDistance += adjMatrix[startIndex][endIndex];
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null) {
                if (vertexList.get(i).getDistanceToThisCity() > (currentDistance + adjMatrix[currentIndex][i])
                        || vertexList.get(i).getDistanceToThisCity() == 0) {
                    return vertexList.get(i);
                }

            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setDistanceToThisCity(currentDistance);
    }


}
