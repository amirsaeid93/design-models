public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        User alice = new User("alice");
        User bob = new User("bob");


        library.addDocument("doc1", "This is an unprotected public document.");


        library.addProtectedDocument("doc2", "This is a protected document (Alice only).", "alice");

        try {
            System.out.println("Alice reads doc1: " + library.getDocument("doc1").getContent(alice));
            System.out.println("Bob reads doc1: " + library.getDocument("doc1").getContent(bob));


            System.out.println("Alice reads doc2: " + library.getDocument("doc2").getContent(alice));


            System.out.println("Bob reads doc2: " + library.getDocument("doc2").getContent(bob));

        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
    }
}
