public class TaskA {

    public static String print(int n){
        int size = n;
        String str = "";
        while(n > 0){
            str += n % 2 == 0 ? printEven(n, size) : printNotEven(n,size);
            str += "\n";
            n--;
        }
        return str;
    }
    private static String printEven(int n, int size){
        String str = "";
        while(size != 0){
            str += Integer.valueOf(n * size) + " ";
            size--;
        }
        return str;
    }
    private static String printNotEven(int n, int size){
        String str = "";
        int i = 1;
        while(i <= size){
            str += Integer.valueOf(n * i) + " ";
            i++;
        }
        return str;
    }
}
