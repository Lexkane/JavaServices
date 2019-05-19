package shop.payment;

public class Cash implements PayMethod{
    @Override
    public void pay() {
        System.out.println("Payed with cash");
    }
}
