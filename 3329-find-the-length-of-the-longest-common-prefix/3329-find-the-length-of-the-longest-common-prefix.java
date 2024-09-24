class Solution {
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<Integer> preSet = new HashSet<>();
            int maxLen = 0;
            if(arr1.length > arr2.length){
                for(int i : arr2){
                    int temp = i;
                    while(temp >= 1){
                        preSet.add(temp);
                        temp /= 10;
                    }
                }
                for(int i : arr1){
                    int temp = i;
                    while(temp >= 1){
                        if(preSet.contains(temp)){
                            maxLen = Math.max(maxLen, String.valueOf(temp).length());
                            break;
                        }
                        temp /= 10;
                    }
                }
            }
            else{
                for(int i : arr1){
                    int temp = i;
                    while(temp >= 1){
                        preSet.add(temp);
                        temp /= 10;
                    }
                }
                for(int i : arr2){
                    int temp = i;
                    while(temp >= 1){
                        if(preSet.contains(temp)){
                            maxLen = Math.max(maxLen, String.valueOf(temp).length());
                            break;
                        }
                        temp /= 10;
                    }
                }
            }
            return maxLen;
    }


}