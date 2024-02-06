public class firstUnique {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if ((s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) == -1)) {
                return i;
            }
        }
        return -1;
    }

    //Bitwise
    public int singleNumber(int[] nums) {
        int ans = nums[0];

        for(int i = 1 ; i < nums.length; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
}



//for (int i = 0; i < s.length(); i++) {
//        for (int j = i+1; j < s.length(); j++) {
//        if (s.charAt(i) != s.charAt(j)) {
//        return i;
//                }
//                        }
//                        }
//                        return -1;