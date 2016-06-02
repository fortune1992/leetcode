public class Solution {
    // 判断一个字符串是否是另一个字符串的子串
    // 从haystack的起始位置扫描needle，并且一个个匹配所有接下去的字母。如果有其中一个字母不同，我们从haystack的接下去一个字符位置重新开始匹配。
    public int strStr(String haystack, String needle) {
      
        if (haystack == null || needle == null){
            return -1;
        }
         // 从heystack开始
        for (int i = 0; ; i++) {
           for (int j = 0; ; j++) {
               // 如果needle和j一样长，则直接返回i(当前匹配的起始位置)，因为已经匹配成功了
                if (j == needle.length()){ 
                    return i;
                }
                // 如果i+j为当前haystack的长度，则表明已经走完heystack所有的字符，并且没有匹配成功(注意如果最后一个字符正好匹配成功，则在上面一个判断就会返回)
                if (i + j == haystack.length()) {
                    return -1;
                    
                }
                 // 如果当前needle和haystack的字符相同的话(因为每次不成功匹配不成功，则i移动1位，而j又重新从0开始，所以haystack的当前位置是i+j)
                if (needle.charAt(j) != haystack.charAt(i + j)){ 
                    break;
                }
            } 
        }
    }
}
