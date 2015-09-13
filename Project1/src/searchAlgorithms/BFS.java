package searchAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS extends Search<Index>{
	
	public BFS(char[][] maze) throws InstantiationException, IllegalAccessException {
		super(maze, Index.class);
	}
	
	public List<Index> search() {
		Queue<Index> frontier = new LinkedList<>();
		List<Index> solutionPath = new ArrayList<>();
		
		Index starting = SearchUtils.getStartingIndex(maze);
		frontier.add(starting);
		while (frontier.size() > 0) {
			Index expand = frontier.poll();
			expanded.add(expand);
			Index[] adjNodes = adjList.get(expand);
//			System.out.println("" + expand.row + ", " + expand.column);
			
			for (Index i : adjNodes) {
				if (!expanded.contains(i)) {
					i.prev = expand;
					if (isGoal(i, maze)) {
						for (Index p = i; p != null; p = p.prev) {
							solutionPath.add(new Index(p.row, p.column, null));	
						}
						return solutionPath;
					} else {
						frontier.add(i);
					}
				}
			}
		}
		
		return solutionPath;
	}
}