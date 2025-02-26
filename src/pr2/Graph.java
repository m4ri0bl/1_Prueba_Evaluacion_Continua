package pr2;

/**
 * Copyright 2025 Mario Blanco Herranz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
import java.util.*;

public class Graph<V> {
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    public boolean addVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            return false;
        }
        adjacencyList.put(v, new HashSet<>());
        return true;
    }

    public boolean addEdge(V v1, V v2) {
        if (!adjacencyList.containsKey(v1)) {
            addVertex(v1);
        }
        if (!adjacencyList.containsKey(v2)) {
            addVertex(v2);
        }
        return adjacencyList.get(v1).add(v2);
    }

    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("El vértice no existe");
        }
        return adjacencyList.get(v);
    }

    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v.toString()).append(": ");
            for (V adj : adjacencyList.get(v)) {
                sb.append(adj.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<V> onePath(V v1, V v2) {
        Map<V, V> traza = new HashMap<>();
        Stack<V> abierta = new Stack<>();
        abierta.push(v1);
        traza.put(v1, null);
        boolean encontrado = false;
        while (!abierta.isEmpty() && !encontrado) {
            V v = abierta.pop();
            encontrado = v.equals(v2);
            if (!encontrado) {
                try {
                    Set<V> adyacentes = obtainAdjacents(v);
                    for (V s : adyacentes) {
                        if (!traza.containsKey(s)) {
                            abierta.push(s);
                            traza.put(s, v);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        if (encontrado) {
            List<V> camino = new ArrayList<>();
            V actual = v2;
            while (actual != null) {
                camino.add(0, actual);
                actual = traza.get(actual);
            }
            return camino;
        } else {
            return null;
        }
    }
}