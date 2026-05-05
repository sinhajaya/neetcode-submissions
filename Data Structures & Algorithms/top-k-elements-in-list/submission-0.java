class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 2. Create buckets where index = frequency
        // List<Integer>[] is an array of lists
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=bucket.length-1; i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    result[index++]=num;
                    if(index==k)
                        return result;
                }
            }
        }
        return result;
    }
}
