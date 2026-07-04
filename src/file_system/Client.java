package file_system;

public class Client {

    public static void main(String[] args) {
        FileSystemManager fsm = new FileSystemManager();

        fsm.addDirectory("home/user/documents");
        fsm.addFile("home/user/documents", new File("file1.txt","txt", "Hello World",5.0));

        File file = fsm.getFile("home/user/documents", "file1.txt");
        if(file != null){
            System.out.println("File content: " + file.getContent());
        } else {
            System.out.println("File not found.");
        }
    }
}
