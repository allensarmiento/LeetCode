class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Boolean> numberMap = new HashMap<>();
        int currentIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!numberMap.containsKey(nums[i])) {
                numberMap.put(nums[i], true);
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        
        return currentIndex;
    }
}
