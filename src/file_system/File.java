package file_system;

public class File {
    private String name;
    private String format;
    private String content;
    private double size;

    public File(String name, String format, String content, double size) {
        this.name = name;
        this.format = format;
        this.content = content;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getSize() {
        return size;
    }

    public String getContent() {
        return content;
    }
}
