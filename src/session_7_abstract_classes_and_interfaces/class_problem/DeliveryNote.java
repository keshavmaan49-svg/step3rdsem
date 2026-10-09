public class DeliveryNote implements Printable {
    private String noteId;
    private String recipient;
    private String address;

    public DeliveryNote(String noteId, String recipient, String address) {
        this.noteId = noteId;
        this.recipient = recipient;
        this.address = address;
    }

    @Override
    public String getDocumentType() {
        return "COMMERCIAL_DELIVERY_NOTE";
    }

    @Override
    public void printDetails() {
        System.out.printf("[%s] Note ID: %s | Recipient: %s | Delivery Address: %s%n",
                getDocumentType(), noteId, recipient, address);
    }

    public static void main(String[] args) {
        DeliveryNote note = new DeliveryNote("DN-9941", "Keshav Maan", "SRM Campus, Chennai");
        note.printDetails();
    }
}
