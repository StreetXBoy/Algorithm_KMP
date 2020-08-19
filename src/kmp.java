/**
 * @author 重新做人idea基础学习
 * @date 2020-8-19
 */


//how to understand next arrary!!!!


//什么是kmp,kmp该怎么应对！！！！！！！



//char --->length   string -->.length()
public class kmp {
    public  static  int[] generateNext(char[] T){
        int len=T.length;
        int []next =new int[len];
        next[0]=-1;
        int k;
        for(int j=2;j< T.length;j++){
            k=next[j-1];
            while(k!=-1) {
                if (T[j - 1] == T[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                    //longset max prefix min lowprefix sub
                }
                next[j] = 0;
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
