class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();

        visited.add("0,0");

        for(char ch : path.toCharArray()){
            if(ch=='N') y++;
            else if(ch=='S') y--;
            else if(ch=='E') x++;
            else if(ch == 'W') x--;

            String currentPos = x + "," + y;

            if(visited.contains(currentPos)){
                return true;
            }
            visited.add(currentPos);
        }
        return false;

    }
}