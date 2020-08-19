/**
 * @author 重新做人idea基础学习
 * @date 2020-8-19
 */


//how to understand next arrary!!!!


//什么是kmp,kmp该怎么应对！！！！！！！



//char --->length   string -->.length()

//i 不动回溯j！！！！

public class kmp {

    //求next 过程相当于错位匹配！！！！
    //https://www.zhihu.com/question/21923021
    //字符串中 i 指针之前的 PMT[j −1] 位就一定与模式字符串的第 0 位至第 PMT[j−1] 位是相同的。这是因为主字符串在 i 位失配，也就意味着主字符串从 i−j 到 i 这一段是与模式字符串的 0 到 j 这一段是完全相同的。
    public  static  int[] generateNext(char[] T){
        int len=T.length;
        int []next =new int[len];
        next[0]=-1;
        int i=0;
        int j=-1;
        while (i<len-1){
            if(j==-1||T[i]==T[j]){
                ++i;
                ++j;
                next[i]=j;
            }else{
                j=next[j];
            }
        }

    return  next;
    }


    public static  int kmp_algorithm(String S,String T){
        char[] s1=S.toCharArray();
        char[] s2=T.toCharArray();
        int []next=generateNext(s2);
        int i=0;
        int j=0;
        int result=0;
        while(i<s1.length&&j<s2.length){
            if(j==-1||s1[i]==s2[j]){
                i++;
                j++;
            }else{
                j=next[j];
            }

            if(j==s2.length){
                //开始位置！！！！！
                result=i-j;
            }else{
                result=-1;
            }
        }
        return  result;
    }
    public static void main(String[] args) {
        String S="abcdedssdgsdgsdgsdgsdgsfghabcd";
        String T="fgh";
        int result=kmp_algorithm(S,T);
        System.out.println(result);
    }
}
