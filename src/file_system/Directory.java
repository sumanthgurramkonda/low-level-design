package file_system;

import java.util.HashMap;
import java.util.Map;

public class Directory {

    private final Map<String, Directory> directories = new HashMap<>();
    private final Map<String, File> files = new HashMap<>();

    public Directory() {}

    /**
     * Navigates to a directory based on path.
     * Creates directories if they don't exist.
     */
    public void addDirectory(String path) {
        Directory current = this;
        for (String part : path.split("/")) {
            if (part.isEmpty()) continue;
            current.directories.putIfAbsent(part, new Directory());
            current = current.directories.get(part);
        }
    }

    /**
     * Adds a file to a specific path.
     * Note: This assumes the path already exists.
     */
    public void addFile(String path, File file) {
        Directory target = getDirectory(path);
        if (target == null) {
            throw new IllegalArgumentException("Path not found: " + path);
        }
        target.files.put(file.getName(), file);
    }

    public File getFile(String path, String fileName) {
        Directory target = getDirectory(path);
        return (target != null) ? target.files.get(fileName) : null;
    }

    public Directory getDirectory(String path) {
        Directory current = this;
        for (String part : path.split("/")) {
            if (part.isEmpty()) continue;
            current = current.directories.get(part);
            if (current == null) return null;
        }
        return current;
    }
}