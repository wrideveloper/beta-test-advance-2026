public class CheckOS {
    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static void main(String[] args) {
        System.out.println("Raw OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));

        if (isWindows()) {
            System.out.println("Detected: Windows");
        } else if (isMac()) {
            System.out.println("Detected: macOS");
        } else if (isUnix()) {
            System.out.println("Detected: Linux or Unix-like");
        } else if (isSolaris()) {
            System.out.println("Detected: Solaris");
        } else {
            System.out.println("Unknown Operating System");
        }
    }

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isUnix() {
        return OS.contains("nix") || OS.contains("nux") || OS.contains("aix");
    }

    public static boolean isSolaris() {
        return OS.contains("sunos");
    }
}
