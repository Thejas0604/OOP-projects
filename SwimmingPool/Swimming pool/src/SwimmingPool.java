import java.util.Scanner;
//hello guys
public class SwimmingPool {
    //Just give the count of people. This will generate objects.
    public static void main(String[] args) {
        Scanner noOfSw = new Scanner(System.in);
        System.out.println("Enter the number of swimmers : ");
        int nosW = Integer.parseInt(noOfSw.nextLine());

        Scanner noOfS = new Scanner(System.in);
        System.out.println("Enter the number of spectators : ");
        int nos = Integer.parseInt(noOfSw.nextLine());

        Scanner noOfJudges = new Scanner(System.in);
        System.out.println("Enter the number of judges : ");
        int noj = Integer.parseInt(noOfSw.nextLine());

        Scanner noOfSuS = new Scanner(System.in);
        System.out.println("Enter the number of supporting staff : ");
        int noSus = Integer.parseInt(noOfSw.nextLine());

        Swimmer [] sw = new Swimmer [nosW];
        for (int i = 0;i<nosW;i++){
           sw[i] = new Swimmer("00"+i,"sw"+i);
           System.out.println("name: "+sw[i].name +" ID :"+sw[i].id);
        }
        Spectators [] sp = new Spectators [nos];
        for (int i = 0;i<nos;i++){
            sp[i] = new Spectators("01"+i,"sp"+i);
            System.out.println("name: "+sp[i].name +" ID :"+sp[i].id);
        }
        Judges [] ju = new Judges [noj];
        for (int i = 0;i<noj;i++){
            ju[i] = new Judges("02"+i,"ju"+i);
            System.out.println("name: "+ju[i].name +" ID :"+ju[i].id);
        }
        SupportingStaff [] sus = new SupportingStaff [noSus];
        for (int i = 0;i<noSus;i++){
            sus[i] = new SupportingStaff("03"+i,"sus"+i);
            System.out.println("name: "+sus[i].name +" ID :"+sus[i].id);
        }


    }
}
class Person {
    public String id;
    public String name;

    public Person(String i_d,String n){
        this.id = i_d;
        this.name = n;
    }

    public void get_check_scoreboard(){
        System.out.println(this.name+ " checked the scoreboard.");
    }
}

class Swimmer extends Person{
    public Swimmer(String i_d, String n) {
        super(i_d, n);
    }
    public void isSwimming(){
        System.out.println(this.name+" has started swimming.");
    }

}

class Judges extends Person{
    public Judges(String i_d, String n) {
        super(i_d, n);
    }

    public void whistleOn(){
        System.out.println(this.name+" has blown the whistle.");
    }

}

class Spectators extends Person{
    public Spectators(String i_d, String n) {
        super(i_d, n);
    }
}

class SupportingStaff extends Person{

    public SupportingStaff(String i_d, String n) {
        super(i_d, n);
    }
}
