
public class IslandFinder {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	int mat[][] =  {{1, 1, 0, 0, 0},
        		{0, 1, 0, 0, 1},
        		{1, 0, 0, 1, 1},
        		{0, 0, 0, 0, 0},
        		{1, 0, 1, 0, 1} };
    	findIslands(mat);

	}
	
	
	//find island count
	
    static int  findIslands(int mat[][])
    {
    	
    	int xSize = mat.length;
    	int ySize = mat[0].length;
    	int islandCount = 0;
    	for(int y=0;y<ySize;y++){
    		int x=0;
    		
    		for(;x<xSize;x++)
    		{
    			Location loc = new Location(x, y);
    			if(Location.isSafe(mat, loc)){// island found
    				islandCount++;
    				Location.visitAll(mat, loc);
    			}
    		}    		
    	}
    	System.out.println(islandCount);
    	return islandCount;
    }

}
