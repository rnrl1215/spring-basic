
public class countingsort {
    public static void main(String[] args) {
        int maxCount = 30;
        int maxValue = 5;

        int[] arrayA  = {2,5,3,0,2,3,0,3};
        int[] count = new int [maxCount];
        int[] resultArray = new int[maxCount];

        for(int i = 0; i < arrayA.length; i++)
        {
            count[arrayA[i]]++;
        }

        for(int i = 1; i <= maxValue; i++)
        {
            count[i] += count[i-1];
        }

        for(int i = 0; i < 6; i++)
        {
            System.out.print(count[i]+",");
        }
        System.out.println();
        for(int i = arrayA.length-1; i >= 0; i--)
        {
            resultArray[count[arrayA[i]]] = arrayA[i];
            count[arrayA[i]]--;
        }

        for(int i = 1; i <= arrayA.length; i++)
        {
            System.out.print(resultArray[i]+",");
        }
    }
}
