package file_system;

public class FileSystemManager {
    private Directory root;

    public FileSystemManager() {
        root = new Directory();
    }

    public void addDirectory(String path) {
        root.addDirectory(path);
    }

    public void addFile(String path, File file) {
        root.addFile(path, file);
    }

    public File getFile(String path, String fileName) {
        return root.getFile(path, fileName);
    }

    public Directory getDirectory(String path) {
        return root.getDirectory(path);
    }
}
