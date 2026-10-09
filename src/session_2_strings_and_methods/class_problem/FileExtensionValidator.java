public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        int lastDot = filename.lastIndexOf('.');
        String ext = filename.substring(lastDot + 1);

        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void checkFile(String filename) {
        String result = validateFileExtension(filename);
        System.out.printf("File: \"%s\" -> %s%n", filename, result);
    }

    public static void main(String[] args) {
        checkFile("Assignment1.PDF");
        checkFile("notes.txt");
        checkFile("project.zip");
        checkFile("report.DOCX");
        checkFile("script.sh");
    }
}
