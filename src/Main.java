import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1,n2,code,code2,amount,opt1,opt2,cant;
        String name,numetemp,type,imput="1";
        double price;
        System.out.println("Introduceti nr de produse:");
        n1 = sc.nextInt();
        Magazin[] mag = new Magazin[n1];
        Magazin magtemp = null;
        System.out.println("Introduceti produsul/produsele");
        for(int i=0;i<n1;i++){
            name = sc.next();
            type = sc.next();
            price = sc.nextDouble();
            code = sc.nextInt();
            amount = sc.nextInt();
            mag[i] = new Magazin(name,type,price,code,amount);
        }
        System.out.println("Din cauza unor defectiuni ale serverului trebuie sa va setati timpul de stat pe platforma.\n");
        System.out.println("Cat doriti sa stati pe platforma?(Maxim 100 de min)");
        n2 = sc.nextInt();
        while(!Objects.equals(imput, "0")){
            System.out.println("1.Adaugare cos.");
            System.out.println("2.Verificare stock.");
            System.out.println("3.Stergere element din cos.");
            System.out.println("4.Verificare suma.");
            System.out.println("5.Finalizare comanda.");
            System.out.println("Introduceti optiunea si numele produsului:");
            opt1 = sc.nextInt();
            numetemp = sc.next();
            for(int i=0;i<n1;i++){
                if(Objects.equals(mag[i].name, numetemp)){
                    magtemp = mag[i];
                }
            }
            if(magtemp == null){
                System.out.println("Produs inexistent");
                continue;
            }
            switch(opt1){
                case 1 :
                    System.out.println("Doriti sa adaugati produsul in cos?(Se optiunele sunt 0/1)");
                    opt2 = sc.nextInt();
                    System.out.println("Cate bucati doriti sa adaugati?");
                    cant = sc.nextInt();
                    System.out.println("Introduceti codul produsului");
                    code2 = sc.nextInt();
                    if(code2 == magtemp.getCode()){
                        magtemp.adaugcos(opt2,code2,cant);
                    }
                    break;
                case 2 :
                    System.out.println("Introduceti codul Produsului");
                    code2 = sc.nextInt();
                    magtemp.verifstock(code2);
                    break;
                case 3 :
                    System.out.println("Ce element doriti sa stergeti?(Introduceti codul produsului)");
                    code2 = sc.nextInt();
                    System.out.println("Ce cantitate ati adaugat?");
                    cant = sc.nextInt();
                    magtemp.cs.DeleteElemcos(code2,magtemp.getCode(),magtemp.getPrice(),cant);
                    break;
                case 4 :
                    System.out.println("Doriti sa verificati suma?");
                    opt2 = sc.nextInt();
                    if(opt2 == 1){
                        System.out.println(magtemp.cs.getSold());
                    }
                    else{
                        System.out.println("Erroare accesare suma");
                    }
                    break;
                case 5 :
                    System.out.println("Doriti sa finalizati comanda?");
                    opt2 = sc.nextInt();
                    magtemp.cs.confact(opt2);
                    break;
            }
            System.out.println("Doriti sa iesiti?(0/1)");
            imput = sc.next();
            magtemp = null;
        }

    }
}
