
import java.util.Scanner;

public class Formal {
     public String FormalOutput(String s){
        String output="";
        String A[] = {"hello" , "help", "need","meet","create","tell me","what is"};
        for(int i=0;i<A.length;i++){
        if(s.contains(A[i])){
            if(A[i]=="hello" || A[i]=="meet"){
                output = "Hello Nice to meet you!\nHow may i Help You?";
            }
            else if(A[i]=="help" || A[i]=="need"){
                output = "Sure i am Will help you but i am not trained well \nso in the future may be i will help you";
            }
            else if(A[i]=="tell me" ||A[i]=="What is"){
                output="I am in phase of Training, so Sorry for now i cant help you just give me the time i will defenately help in future.....";
            }
            else{
                output = "\nWrong Input\nTry again\n";
            }
        }

        }
        return output;
     }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String InpuString = sc.nextLine();
        Formal obj1 = new Formal();
        System.out.println(obj1.FormalOutput(InpuString));            
    }
}


