class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedKey = String.valueOf(ch);

            if(!map.containsKey(sortedKey)){
                map.put(sortedKey,new ArrayList<>());
            }
            map.get(sortedKey).add(str); 
        }
        return new ArrayList<>(map.values());
    }
}
