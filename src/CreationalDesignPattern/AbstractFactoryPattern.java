package CreationalDesignPattern;

interface PaymentGateway{
    void processPayment(double amount);
}
class RazorpayGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Razorpay: " + amount);
    }
}
class PayUGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("CreationalDesignPattern.PayUGateway: " + amount);
    }
}

class PayPalGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via PayPal: " + amount);
    }
}
class StripeGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}

interface Invoice{
    void generateInvoice();
}
class GSTInvoice implements Invoice{
    public void generateInvoice(){
        System.out.println("GST CreationalDesignPattern.Invoice");
    }
}
class USInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating CreationalDesignPattern.Invoice as per US norms.");
    }
}

interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}
class IndiaFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorpayGateway();
        } else if (gatewayType.equalsIgnoreCase("payu")) {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for India: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}
class USFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        } else if (gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for US: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new USInvoice();
    }
}
class CheckoutService {
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory factory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // Using Razorpay in India
        CheckoutService indiaCheckout = new CheckoutService(new IndiaFactory(), "razorpay");
        indiaCheckout.completeOrder(1999.0);

        System.out.println("---");

        // Using PayPal in US
        CheckoutService usCheckout = new CheckoutService(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);
    }
}
