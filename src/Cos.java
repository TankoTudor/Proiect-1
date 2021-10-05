public class Cos {
    private double sold = 0.0;

    double price;
    int code;
    int amount;

    public Cos(double sold){
        this.sold = sold;
    }

    public double getSold() {
        return sold;
    }

    public void Totalsum(double sum, int cant){
        this.sold += sum*cant;
    }

    public boolean DeleteElemcos(int code,int codep,double pret,int cant){
        if (code == codep){
            this.sold -= pret*cant;
            return true;
        }
        else{
            System.out.println("Produsul nu este in stock");
            return false;
        }
    }

    public boolean confact(int ok){
        if(ok == 1){
            System.out.println("Comanda a fost achitata contra sumei de:" + sold);
            return true;
        }
        else{
            System.out.println("Eroare la achitarea comenzii!");
            return false;
        }
    }

}
