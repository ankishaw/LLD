package CreationalDesignPattern;

import java.util.HashMap;
import java.util.Map;

interface EmailTemplate extends Cloneable{
    EmailTemplate clone(); //Deep copy Recommended
    void setContent(String content);
    void send(String to);
    String getContent();
}
class WelcomeEmail implements EmailTemplate{
    private String subject;
    private String content;

    public WelcomeEmail(){
        this.subject = "Welcome to TUF+!";
        this.content = "Hi there!, Thanks for Joining us";
    }
    @Override
    public WelcomeEmail clone(){
        try{
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone Failed", e);
        }
    }

    @Override
    public String getContent(){
        return content;
    }
    @Override
    public void setContent(String content){
        this.content = content;
    }
    @Override
    public void send(String to){
        System.out.println("Sending to " + to + ": [" + subject + "] "  + content);
    }
}

class EmailTemplateRegistry{
    private static final Map<String, EmailTemplate> templates = new HashMap<>();

    static {
        templates.put("welcome", new WelcomeEmail());
        //Add more templates like "discount", "feature-update"
    }

    public static EmailTemplate getTemplate(String type){
        return templates.get(type).clone();
    }
}
public class PrototypePattern {
    public static void main(String[] args){
        EmailTemplate welcomeEmail1 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail1.setContent("Hi Alice, welcome to TUF Premium!");
        welcomeEmail1.send("alice@example.com");
        //System.out.println(welcomeEmail1.getContent());

        EmailTemplate welcomeEmail2 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail2.setContent("Hi Bob, thanks for joining!");
        welcomeEmail2.send("bob@example.com");
        //System.out.println(welcomeEmail1.getContent());
        //System.out.println(welcomeEmail2.getContent());
    }
}

// Bad Code: Incomplete Use of Design Principles
/*interface CreationalDesignPattern.EmailTemplate {
    void setContent(String content);
    void send(String to);
}

// A concrete email class, hardcoded
class CreationalDesignPattern.WelcomeEmail implements CreationalDesignPattern.EmailTemplate {
    private String subject;
    private String content;

    public CreationalDesignPattern.WelcomeEmail() {
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us.";
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}

class Main {
    public static void main(String[] args) {
        // Create a welcome email
        CreationalDesignPattern.WelcomeEmail email1 = new CreationalDesignPattern.WelcomeEmail();
        email1.send("user1@example.com");

        // Suppose we want a similar email with slightly different content
        CreationalDesignPattern.WelcomeEmail email2 = new CreationalDesignPattern.WelcomeEmail();
        email2.setContent("Hi there! Welcome to TUF Premium.");
        email2.send("user2@example.com");

        // Yet another variation
        CreationalDesignPattern.WelcomeEmail email3 = new CreationalDesignPattern.WelcomeEmail();
        email3.setContent("Thanks for signing up. Let's get started!");
        email3.send("user3@example.com");
    }
}*/

