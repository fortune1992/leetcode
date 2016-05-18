Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

public class Solution {
    // 注意:the two words do not share common letters!!!不包含相同字母
    public int maxProduct(String[] words) {
        // 一个int用32位二进制来表示，而小写字母的种类总数为26种。因此我们可以用一个int的低26位来表示一个word是否含有某个字符，比如int的32位为00000…0001，则说明含有字符‘a’，00000…0010，表示含有字符‘b’，这样在判断两个单词是否含有相同的字符时，只需要将对应的32位二进制进行按位与操作。
        int result = 0;
        if (words == null || words.length == 0){
            return 0;
        }
        int bitAlphabet[] = new int[words.length];
        for (int i=0; i<words.length; i++){
            int temp = 0;
            // 测量每个字符串转换后的int值
            for (int j=0; j<words[i].length(); j++){
                temp |= 1 << (words[i].charAt(j) - 'a');
            }
            bitAlphabet[i] = temp;// 每两个字符串对应的int值执行按位与操作，若包含相同的字符，则按位与结果不为0
        }
        
        for (int i=0; i<bitAlphabet.length; i++){
            for (int j=i+1; j<bitAlphabet.length; j++){// (bitAlphabet[i] & bitAlphabet[j]) == 0 两个字符串不包含相同字母
                if ((bitAlphabet[i] & bitAlphabet[j]) == 0 && (words[i].length()*words[j].length()) > result){
                    result = words[i].length()*words[j].length();
                }
            }
        }
        return result;
    }
}
