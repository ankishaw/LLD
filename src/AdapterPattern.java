package StructuralDesignPattern;
interface PaymentGateway{
    void pay(String orderId, double amount);
}
class PayUGateway implements PaymentGateway{
    @Override
    public void pay(String orderId, double amount){
        System.out.println("Paid Rs. " + amount + " using PayU for order: " + orderId);
    }
}

class RazorpayAPI {
    public void makePayment(String invoiceId, double amountInRupees) {
        System.out.println("Paid Rs." + amountInRupees + " using Razorpay for invoice: " + invoiceId);
    }
}
class RazorpayAdapter implements PaymentGateway {
    private RazorpayAPI razorpayAPI;

    public RazorpayAdapter() {
        this.razorpayAPI = new RazorpayAPI();
    }

    // Translates the pay() call to RazorpayAPI's makePayment() method
    @Override
    public void pay(String orderId, double amount) {
        razorpayAPI.makePayment(orderId, amount);
    }
}
class CheckoutService{
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public void checkout(String orderId, double amount){
        paymentGateway.pay(orderId, amount);
    }
}
public class AdapterPattern {
    public static void main(String[] args){
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.checkout("123", 1780);

        CheckoutService checkoutService1 = new CheckoutService(new RazorpayAdapter());

        checkoutService1.checkout("321", 1780);
    }
}

//Problem - Cannot add another payment method if it is using some other methods
/*package StructuralDesignPattern;
interface PaymentGateway{
    void pay(String orderId, double amount);
}
class PayUGateway implements PaymentGateway{
    @Override
    public void pay(String orderId, double amount){
        System.out.println("Paid Rs. " + amount + " using PayU for order: " + orderId);
    }
}
class CheckoutService{
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public void checkout(String orderId, double amount){
        paymentGateway.pay(orderId, amount);
    }
}
public class AdapterPattern {
    public static void main(String[] args){
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.checkout("123", 1780);
    }
}*/
