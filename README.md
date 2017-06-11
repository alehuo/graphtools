# GraphTools

## Introduction

GraphTools is toolkit that can calculate useful things about weighted and unweighted graphs.

## Features

* Calculating shortest or farthest distance between nodes (weighted and unweighted)
* Topological sorting
* Finding strongly connected components
* Finding minimum and maximum spanning tree

More features coming soon.

## Algorithms currently supported by GraphTools

* Dijkstra's algorithm (Shortest path)
* BFS algorithm (Shortest path)
* Kruskal's algorithm (Minimum or maximum spanning tree)

## Usage

For example, if you'd like to calculate shortest path between two nodes using Dijkstra's algorithm:

```java -jar GraphTools.jar graph.json shortestPath dijkstra 1 5```

Will return (depending on the graph):

```
42
```

For shortest spanning tree of a graph:

```java -jar GraphTools.jar graph.json shortestSpanningTree kruskal```

```
3 --> 4 (weight: 7)
2 --> 4 (weight: 6)
1 --> 3 (weight: 4)
```

To do

## Installation instructions

To do

## To do list

- [ ] Floyd-Warshall's algorithm
- [ ] Bellman-Ford's algorithm
- [ ] DFS algorithm
- [X] Kruskal's algorithm
- [ ] Prim's algorithm

## License

Copyright (C) 2017 alehuo

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.