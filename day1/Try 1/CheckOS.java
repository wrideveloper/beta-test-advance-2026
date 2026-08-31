public class CheckOS {
    public static void main(String[] args) {
        System.out.println("Raw OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));

        kataRaditFunctionnyaJadiSatuAjaBiarGkApaGitu()
    }

    public static void kataRaditFunctionnyaJadiSatuAjaBiarGkApaGitu() {
        String OS = System.getProperty("os.name").toLowerCase();

         if (OS.contains("win")) {
            System.out.println("Detected: Windows");
        } else if (OS.contains("mac")) {
            System.out.println("Detected: macOS");
        } else if (OS.contains("nix") || OS.contains("nux") || OS.contains("aix")) {
            System.out.println("Detected: Linux or Unix-like");
        } else if (OS.contains("sunos")) {
            System.out.println("Detected: Solaris");
        } else {
            System.out.println("Unknown Operating System");
        }
    }
}
