public class TaskB {
    private static int countSpace;

    public static String print(int n){
        return printSpaceFirst(n) + printSpaceSecond(n);
    }
    private static String printSpaceFirst(int n){
        String str = "";
        for(int i = n; i > 0; i--){
            countSpace = n - i;
            for(int j = countSpace; j > 0; j--){
                str += "  ";
            }
            for(int j = countSpace + 1; j <= n; j++){
                str += j + " ";
            }
            str +='\n';
        }
        return str;
    }
    private static String printSpaceSecond(int n){
        String str = "";
        for(int i = 1; i < n; i++){
            for(int j = countSpace; j > 0; j--){
                str += "  ";
            }
            for(int j = n - i; j <= n ; j++){
                str += j + " ";
            }
            str +='\n';
        }
        return str;
    }
}
