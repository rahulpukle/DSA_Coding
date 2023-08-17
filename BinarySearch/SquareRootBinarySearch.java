import java.util.Scanner;

public class SquareRootBinarySearch {
    //for integer part of the root
    static double findroot(long n){
        long start=1;
        long end = n;
        long mid = start+(end- start)/2;
        long result=start;
        while(start<=end){           
            if(mid*mid==n){
                result =mid;
                return result;
            }
            if(mid*mid>n)
                end=mid-1;
            else{
                result=mid;
                start=mid+1;
            }
             mid = start+(end- start)/2;
        }

        double decimal=findDecimal(result,3,n);
        return decimal;
    } 
    //for decimal part  
    static double findDecimal(long result,int precision,long n){
        double ans;
        double result2=result;
        int j=1;
        long divisor=10;
         double scaleFactor=1;
        while (j<=precision){
        for(int i=0;i<10;i++){
             ans=result2+(i*1.0/divisor);
            if(ans*ans <= n){
                result2=ans;
            }
            else{
                break;
            }          
           
        }
        divisor=divisor*10;
        j++;
        scaleFactor*=10;
    }

   
    for(int k=0;k<precision;k++)
            scaleFactor*=10;
         return (int)(result2*scaleFactor)/scaleFactor;
    }
    //for decimal part
    

    
    
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();
        double result=findroot(n);
        System.out.println("Root is "+ result);
        sc.close();
    }
    
}
