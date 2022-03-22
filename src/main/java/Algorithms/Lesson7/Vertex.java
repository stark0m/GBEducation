package Algorithms.Lesson7;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean isVisited;
    private int distanceToThisCity;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" + "label='" + label + '\'' + '}';
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public int getDistanceToThisCity() {
        return distanceToThisCity;
    }

    public void setDistanceToThisCity(int distance) {
        this.distanceToThisCity = distance;
    }

    public boolean isVisited() {
        return isVisited;
    }
}
