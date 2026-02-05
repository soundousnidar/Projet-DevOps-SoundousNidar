public class App {
    public static void main(String[] args) {
        System.out.println("=== APPLICATION DEVOPS SOUNDOUS NIDAR ===");
        System.out.println("Bonjour Monsieur c'est SOUNDOUS - Branche DEV :)");
        System.out.println("Cette application fait partie du mini-projet DevOps");
        System.out.println("Date: " + new java.util.Date());
        
        // Reste active pendant 2 minutes pour les démonstrations
        try {
            for (int i = 1; i <= 12; i++) {
                Thread.sleep(10000); // 10 secondes
                System.out.println("En cours d'exécution... " + i + "/12");
            }
            System.out.println("=== FIN DE L'EXÉCUTION ===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}