package shop.payment;

public class CreditCard implements PayMethod{
    @Override
    public void pay() {
        System.out.println("Payed with credit card");
    }
}
