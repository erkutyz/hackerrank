import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location {

	public int x;

	public int y;

	public Location(int x, int y) {

		this.y = y;
		this.x = x;
	}

	//define movements
	public static List<Direction> Directions() {

		Direction d1 = (Location l1) -> {
			l1.x--;
			return l1;
		};
		Direction d2 = (Location l1) -> {
			l1.x++;
			return l1;
		};
		Direction d3 = (Location l1) -> {
			l1.y++;
			return l1;
		};
		Direction d4 = (Location l1) -> {
			l1.y--;
			return l1;
		};
		Direction d5 = (Location l1) -> {
			l1.y--;
			l1.x++;
			return l1;
		};
		Direction d6 = (Location l1) -> {
			l1.y--;
			l1.x--;
			return l1;
		};
		Direction d7 = (Location l1) -> {
			l1.y++;
			l1.x--;
			return l1;
		};
		Direction d8 = (Location l1) -> {
			l1.y++;
			l1.x++;
			return l1;
		};
		List<Direction> directions = Arrays.asList(d2, d5, d4, d6, d1, d7, d3, d8);

		return directions;
	}

	//return true if not out of boundries and island(1)
	public static boolean isSafe(int mat[][], Location loc) {
		if (loc.x >= 0 && loc.x < mat.length) {
			if (loc.y >= 0 && loc.y < mat[0].length) {
				if (mat[loc.y][loc.x] == 1)
					return true;
			}
		}
		return false;
	}

	//mark visited locations
	public static void markVisited(int mat[][], Location loc) {

		mat[loc.y][loc.x] = 2;
	}

	//non necessary for island counter
	//but can be usefull for other problems
	public static void markExploring(int mat[][], Location loc) {

		mat[loc.y][loc.x] = 3;
	}

	// DFS Approach
	public static void visitAll(int mat[][], Location loc) {

		for (int index = 0; index < 8; index++) {
			markExploring(mat, loc);
			Location locTemp = new Location(loc.x, loc.y);
			Directions().get(index).go(loc);
			if (isSafe(mat, loc)) {
				visitAll(mat, loc);

			}
			loc = locTemp;
		}
	}

}
