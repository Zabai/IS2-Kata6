package kata6;

public class Mail {
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    
    public String getDomain () {
        return this.mail.substring(this.mail.indexOf("@")+1);
    }
}
