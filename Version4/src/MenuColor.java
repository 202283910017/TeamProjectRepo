public class MenuColor {

    // Define different colors
    public static String RESET = "\u001B[0m";    // Reset to default color
    public static String RED = "\u001B[31m";      // Red color
    public static String GREEN = "\u001B[32m";    // Green color
    public static String YELLOW = "\u001B[33m";   // Yellow color
    public static String BLUE = "\u001B[34m";     // Blue color
    public static String MAGENTA = "\u001B[35m";   // Magenta color
    public static String CYAN = "\u001B[36m";      // Cyan color
    public static String WHITE = "\u001B[37m";     // White color

    // Return color based on the user's choice
    public static String getColorByChoice(int choice) {
        switch (choice) {
            case 1: return RED;       // Return Red color for choice 1
            case 2: return GREEN;     // Return Green color for choice 2
            case 3: return YELLOW;    // Return Yellow color for choice 3
            case 4: return BLUE;      // Return Blue color for choice 4
            case 5: return MAGENTA;   // Return Magenta color for choice 5
            case 6: return CYAN;      // Return Cyan color for choice 6
            case 7: return WHITE;     // Return White color for choice 7
            default: return RESET;    // Default case, return reset color
        }
    }
}
