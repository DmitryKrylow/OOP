import java.util.Arrays;

public class MyArrayList <T>{
    private T[] array;
    private int lastIndex = 0;
    public MyArrayList(T[] array){
        this.array = array.clone();
        for(int i = 0; i < array.length; ++i){
            if(array[i] == null){
                lastIndex = i;
                break;
            }
            lastIndex = i;
        }
    }
    public MyArrayList(){
        array = (T[]) new Object[1];
    }
    public void add(T obj){
        try {
            if (lastIndex >= array.length - 1) {
                array = Arrays.copyOf(array,2 * array.length);
            }
            array[lastIndex] = obj;
            lastIndex++;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public T get(int index){
        return array[index];
    }
    public void clear(){
        array = (T[]) new Object[1];
        lastIndex = 0;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i < lastIndex; i++) {
            str.append(array[i]).append(i == lastIndex - 1 ? "" : " ");
        }
        str.append("]\n");
        return str.toString();
    }
    public T[] toArray(){
        return Arrays.copyOf(array,lastIndex);
    }
}
