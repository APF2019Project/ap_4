package view.chatController;

public class Payam {
    private String text ;
    private String sender ;
    private String receiver ;
    private String imageName ;
    private byte[] image ;
    private boolean isSeen=false ;

    public Payam(String text, String sender, String receiver,String imageName,byte[] image ){
        this.text = text ;
        this.sender = sender ;
        this.receiver = receiver ;
        this.imageName = imageName ;
        this.image = image ;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
