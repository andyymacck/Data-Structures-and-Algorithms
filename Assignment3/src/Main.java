import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] s1 = {0,1,2,3,4,5,6,6};
        int[] s2 = {3,1,4,0,2,6,5,6};

        System.out.println(equalSet(s1, s2));
    }
    public static boolean equalSet(int[] s1, int[] s2 ){
        if(s1.length != s2.length ) {
            return false;
        }
        else{
            ArrayList<Integer> s = new ArrayList<>();
            for(int element: s1){
                s.add(element);
            }
            for(int element: s2){
                if(!s.contains(element)){
                    return false;
                }
            }
            return true;
        }
    }
}