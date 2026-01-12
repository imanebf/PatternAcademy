import java.util.*;
import java.util.concurrent.*;
import java.io.*;
interface GameUI {
    void showTitle();
    void showMainMenu(String playerName);
    void showPatternLibrary();
    void showPatternDetails(String patternName);
    void showLearningSession(String patternName);
    void showQuizSession(String patternName);
    void showProgressDashboard();
    void showStrategySelector();
    void showPatternComparison();
    void showAchievements();
    void showHelp();
    String getInput(String prompt);
    void clearScreen();
    void waitForKey();
    void displayMessage(String message, String type);
    void displayBanner(String title);
    void displaySection(String title);
    void displayCard(String title, String content);
    void displayPatternCard(String name, String category, String description, String[] examples);
    void displayQuiz(String question, String[] options);
    void waitForKey(String message);
}
class ConsoleUI implements GameUI {
    private Scanner scanner = new Scanner(System.in);
    private final String RESET = "\u001B[0m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";
    private final String PURPLE = "\u001B[35m";
    private final String CYAN = "\u001B[36m";
    private final String WHITE = "\u001B[37m";
    private final String BOLD = "\u001B[1m";
    @Override
    public void showTitle() {
        clearScreen();
        System.out.println(CYAN + BOLD);
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                              ║");
        System.out.println("║  ███╗   ███╗ █████╗ ███████╗████████╗███████╗██████╗ ████████╗████████╗      ║");
        System.out.println("║  ████╗ ████║██╔══██╗██╔════╝╚══██╔══╝██╔════╝██╔══██╗╚══██╔══╝╚══██╔══╝      ║");
        System.out.println("║  ██╔████╔██║███████║███████╗   ██║   █████╗  ██████╔╝   ██║      ██║         ║");
        System.out.println("║  ██║╚██╔╝██║██╔══██║╚════██║   ██║   ███╔══╝ ██╔══██╗   ██║      ██║         ║");
        System.out.println("║  ██║ ╚═╝ ██║██║  ██║███████╗   ██║   ███████╗██║  ██║   ██║      ██║         ║");
        System.out.println("║  ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚═╝      ╚═╝         ║");
        System.out.println("║                                                                              ║");
        System.out.println("║                     P A T T E R N   A C A D E M Y                           ║");
        System.out.println("║                                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(YELLOW + "\n" + "─".repeat(80) + RESET);
        System.out.println(CYAN + "   🎓 Le jeu ultime pour maîtriser les Design Patterns de A à Z! " + RESET);
        System.out.println(YELLOW + "─".repeat(80) + RESET);
        displayCard("Bienvenue dans votre voyage d'apprentissage!", """
            Explorez 23 design patterns organisés en 3 catégories:
             CRÉATIONNELS (5 patterns) - Création d'objets
              STRUCTURELS (7 patterns) - Composition d'objets
             COMPORTEMENTAUX (11 patterns) - Communication entre objets
            Choisissez votre stratégie d'apprentissage et devenez un expert!
            """);
        waitForKey();
    }
    @Override
    public void showMainMenu(String playerName) {
        clearScreen();
        displayBanner(" Menu Principal - " + playerName);
        System.out.println(PURPLE + "\n" + "═".repeat(60) + RESET);
        System.out.println(CYAN + "   QUE SOUHAITEZ-VOUS FAIRE ?" + RESET);
        System.out.println(PURPLE + "═".repeat(60) + RESET);
        String[] options = {
            " Bibliothèque des Patterns (23 patterns)",
            " Session d'apprentissage guidée",
            " Quiz interactif par catégorie",
            " Stratégies d'apprentissage avancées",
            " Tableau de progression & Statistiques",
            " Comparateur de Patterns",
            " Hall de la renommée",
            " Guide & Aide",
            " Quitter le jeu"
        };
        for (int i = 0; i < options.length; i++) {
            System.out.printf("  " + GREEN + "%2d. " + RESET + "%s\n", i + 1, options[i]);
        }
        System.out.println(PURPLE + "═".repeat(60) + RESET);
        System.out.print(YELLOW + "\n Votre choix : " + RESET);
    }
    @Override
    public void showPatternLibrary() {
        clearScreen();
        displayBanner(" BIBLIOTHÈQUE DES PATTERNS");
        System.out.println("\n" + CYAN + "┌────────────────────────────────────────────────────────────────────┐" + RESET);
        System.out.println(CYAN + "│                    " + BOLD + "CATÉGORIES DE PATTERNS" + RESET + CYAN + "                    │" + RESET);
        System.out.println(CYAN + "└────────────────────────────────────────────────────────────────────┘" + RESET);
        displaySection(" PATTERNS CRÉATIONNELS (5)");
        System.out.println("   Conception optimisée de la création d'objets");
        String[] creationnels = {"Singleton", "Factory Method", "Abstract Factory", "Builder", "Prototype"};
        for (int i = 0; i < creationnels.length; i++) {
            System.out.printf("   %d. %-20s", i + 1, creationnels[i]);
            if (i % 2 == 1 || i == creationnels.length - 1) System.out.println();
        }
        displaySection("\n  PATTERNS STRUCTURELS (7)");
        System.out.println("   Composition efficace des classes et objets");
        String[] structurels = {"Adapter", "Bridge", "Composite", "Decorator", "Facade", "Flyweight", "Proxy"};
        for (int i = 0; i < structurels.length; i++) {
            System.out.printf("   %d. %-20s", i + 1, structurels[i]);
            if (i % 2 == 1 || i == structurels.length - 1) System.out.println();
        }
        displaySection("\n PATTERNS COMPORTEMENTAUX (11)");
        System.out.println("   Communication flexible entre objets");
        String[] comportementaux = {"Strategy", "Observer", "Command", "Iterator", "Template Method", 
                                   "Visitor", "Mediator", "Memento", "State", "Chain of Responsibility", "Interpreter"};
        for (int i = 0; i < comportementaux.length; i++) {
            System.out.printf("   %d. %-25s", i + 1, comportementaux[i]);
            if (i % 2 == 1 || i == comportementaux.length - 1) System.out.println();
        }
        System.out.println(YELLOW + "\n" + "─".repeat(80) + RESET);
        System.out.print(CYAN + " Entrez le nom d'un pattern (ex: 'Singleton') ou 'menu' : " + RESET);
    }
    @Override
    public void showPatternDetails(String patternName) {
        clearScreen();
        PatternInfo pattern = PatternDatabase.getPattern(patternName);
        if (pattern == null) {
            displayMessage("Pattern non trouvé : " + patternName, "error");
            waitForKey();
            return;
        }
        displayBanner(" " + pattern.getName().toUpperCase());
        System.out.println(GREEN + "┌────────────────────────────────────────────────────────────────────┐" + RESET);
        System.out.printf(GREEN + "│ " + RESET + "%-58s " + GREEN + "│\n" + RESET, 
                         "Catégorie : " + pattern.getCategory());
        System.out.printf(GREEN + "│ " + RESET + "%-58s " + GREEN + "│\n" + RESET,
                         "Difficulté : " + "★".repeat(pattern.getDifficulty()));
        System.out.printf(GREEN + "│ " + RESET + "%-58s " + GREEN + "│\n" + RESET,
                         "Fréquence d'utilisation : " + pattern.getFrequency());
        System.out.println(GREEN + "└────────────────────────────────────────────────────────────────────┘" + RESET);
        displaySection(" DESCRIPTION");
        System.out.println("   " + pattern.getDescription());
        displaySection(" PROBLÈME & SOLUTION");
        System.out.println("   " + BOLD + "Problème : " + RESET + pattern.getProblem());
        System.out.println("   " + BOLD + "Solution : " + RESET + pattern.getSolution());
        displaySection("  STRUCTURE UML");
        System.out.println(pattern.getUmlDiagram());
        displaySection(" AVANTAGES");
        for (String advantage : pattern.getAdvantages()) {
            System.out.println("   ✓ " + advantage);
        }
        displaySection(" INCONVÉNIENTS");
        for (String disadvantage : pattern.getDisadvantages()) {
            System.out.println("   ✗ " + disadvantage);
        }
        displaySection(" EXEMPLES D'UTILISATION");
        String[] examples = pattern.getExamples();
        for (int i = 0; i < examples.length; i++) {
            System.out.println("   " + (i + 1) + ". " + examples[i]);
        }
        displaySection(" EXEMPLE DE CODE");
        System.out.println(pattern.getCodeExample());
        System.out.println(YELLOW + "\n" + "─".repeat(80) + RESET);
        System.out.println(CYAN + "   QUE VOULEZ-VOUS FAIRE ?" + RESET);
        System.out.println(YELLOW + "─".repeat(80) + RESET);
        String[] actions = {
            " Lancer une session d'apprentissage",
            " Passer un quiz sur ce pattern",
            " Appliquer une stratégie d'apprentissage",
            " Comparer avec d'autres patterns",
            " Retour au menu principal"
        };
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("   " + GREEN + "%d. " + RESET + "%s\n", i + 1, actions[i]);
        }
        System.out.print(YELLOW + "\n Votre choix : " + RESET);
    }
    @Override
    public void showLearningSession(String patternName) {
        clearScreen();
        displayBanner(" SESSION D'APPRENTISSAGE - " + patternName.toUpperCase());
        PatternInfo pattern = PatternDatabase.getPattern(patternName);
        if (pattern == null) return;
        System.out.println(PURPLE + "\n" + "═".repeat(60) + RESET);
        System.out.println(CYAN + "   PARCOURS PÉDAGOGIQUE EN 4 ÉTAPES" + RESET);
        System.out.println(PURPLE + "═".repeat(60) + RESET);
        System.out.println("\n" + GREEN + BOLD + " ÉTAPE 1 : INTRODUCTION" + RESET);
        System.out.println("   " + pattern.getIntroduction());
        waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
        clearScreen();
        System.out.println("\n" + GREEN + BOLD + " ÉTAPE 2 : CONCEPTS CLÉS" + RESET);
        System.out.println("   Voici les concepts fondamentaux à maîtriser :");
        for (String concept : pattern.getKeyConcepts()) {
            System.out.println("   • " + concept);
            try { Thread.sleep(800); } catch (InterruptedException e) {}
        }
        waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
        clearScreen();
        System.out.println("\n" + GREEN + BOLD + " ÉTAPE 3 : CAS PRATIQUE" + RESET);
        System.out.println("   " + pattern.getUseCase());
        System.out.println(YELLOW + "\n" + "─".repeat(60) + RESET);
        System.out.println(CYAN + "    MINI QUIZ : TESTEZ VOTRE COMPRÉHENSION" + RESET);
        System.out.println(YELLOW + "─".repeat(60) + RESET);
        displayQuiz(pattern.getQuizQuestion(), pattern.getQuizOptions());
        String answer = getInput("\nVotre réponse (A/B/C/D) : ").toUpperCase();
        if (answer.equals(pattern.getQuizAnswer())) {
            displayMessage(" Excellent ! Vous avez bien compris le concept !", "success");
        } else {
            displayMessage(" Presque ! La bonne réponse était : " + pattern.getQuizAnswer(), "warning");
        }
        waitForKey("\n⏎ Appuyez sur Entrée pour le résumé...");
        clearScreen();
        System.out.println("\n" + GREEN + BOLD + " ÉTAPE 4 : RÉSUMÉ & POINTS CLÉS" + RESET);
        System.out.println("\n" + CYAN + "   POINTS CLÉS À RETENIR :" + RESET);
        for (String point : pattern.getKeyPoints()) {
            System.out.println("   • " + point);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
        displayMessage("\n FÉLICITATIONS ! Vous avez complété la session sur " + patternName + " !", "success");
        System.out.println("\n" + GREEN + "    Réalisation débloquée : Apprenti " + patternName + RESET);
        System.out.println(YELLOW + "    XP gagné : +100 points" + RESET);
        waitForKey("\n⏎ Appuyez sur Entrée pour retourner au menu...");
    }
    @Override
    public void showQuizSession(String patternName) {
        clearScreen();
        displayBanner(" QUIZ - " + patternName.toUpperCase());
        PatternInfo pattern = PatternDatabase.getPattern(patternName);
        if (pattern == null) return;
        System.out.println("\n" + CYAN + "   Testez vos connaissances avec 5 questions chronométrées !" + RESET);
        System.out.println(YELLOW + "   Chaque bonne réponse rapporte 20 points." + RESET);
        System.out.println(RED + "   Vous avez 60 secondes pour terminer le quiz." + RESET);
        waitForKey("\n⏎ Appuyez sur Entrée pour commencer...");
        QuizSession quiz = new QuizSession(pattern);
        quiz.start();
        waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
    }
    @Override
    public void showProgressDashboard() {
        clearScreen();
        displayBanner(" TABLEAU DE PROGRESSION");
        PlayerProgress progress = GameManager.getInstance().getPlayerProgress();
        System.out.println("\n" + CYAN + "┌────────────────────────────────────────────────────────────────────┐" + RESET);
        System.out.printf(CYAN + "│ " + RESET + "%-30s : %-25s " + CYAN + "│\n" + RESET, 
                         " Joueur", progress.getPlayerName());
        System.out.printf(CYAN + "│ " + RESET + "%-30s : %-25s " + CYAN + "│\n" + RESET,
                         " Niveau", "Niveau " + progress.getLevel());
        System.out.printf(CYAN + "│ " + RESET + "%-30s : %-25s " + CYAN + "│\n" + RESET,
                         " XP Total", progress.getTotalXP() + " XP");
        System.out.println(CYAN + "└────────────────────────────────────────────────────────────────────┘" + RESET);
        int progressPercent = progress.getProgressPercentage();
        System.out.println("\n" + GREEN + "   PROGRESSION GLOBALE" + RESET);
        System.out.print("   [");
        for (int i = 0; i < 40; i++) {
            System.out.print(i < progressPercent * 40 / 100 ? "█" : "░");
        }
        System.out.printf("] %d%%\n", progressPercent);
        System.out.println("\n" + CYAN + "   PATTERNS MAÎTRISÉS PAR CATÉGORIE" + RESET);
        System.out.println("    Créationnels : " + progress.getPatternsByCategory("Créationnel").size() + "/5");
        System.out.println("     Structurels : " + progress.getPatternsByCategory("Structurel").size() + "/7");
        System.out.println("    Comportementaux : " + progress.getPatternsByCategory("Comportemental").size() + "/11");
        List<String> recentAchievements = progress.getRecentAchievements(3);
        if (!recentAchievements.isEmpty()) {
            System.out.println("\n" + YELLOW + "    DERNIÈRES RÉALISATIONS" + RESET);
            for (String achievement : recentAchievements) {
                System.out.println("   • " + achievement);
            }
        }
        waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
    }
    @Override
    public void showStrategySelector() {
        clearScreen();
        displayBanner(" STRATÉGIES D'APPRENTISSAGE");
        System.out.println("\n" + CYAN + "   Choisissez votre approche d'apprentissage préférée :" + RESET);
        LearningStrategy[] strategies = LearningStrategyFactory.getAllStrategies();
        for (int i = 0; i < strategies.length; i++) {
            System.out.println("\n" + GREEN + BOLD + "   " + (i + 1) + ". " + strategies[i].getName() + RESET);
            System.out.println("      " + strategies[i].getDescription());
            System.out.println("      ⏱  Durée : " + strategies[i].getDuration() + " min |  Style : " + strategies[i].getStyle());
            System.out.println("       Difficulté : " + "★".repeat(strategies[i].getDifficulty()));
        }
        System.out.print(YELLOW + "\n Sélectionnez une stratégie (1-" + strategies.length + ") : " + RESET);
    }
    @Override
    public void showPatternComparison() {
        clearScreen();
        displayBanner(" COMPARATEUR DE PATTERNS");
        List<String> patterns = PatternDatabase.getAllPatternNames();
        int half = (patterns.size() + 1) / 2;
        System.out.println("\n" + CYAN + "   Sélectionnez deux patterns à comparer :" + RESET);
        System.out.println("\n" + GREEN + "   ┌──────────────────────────┬──────────────────────────┐" + RESET);
        System.out.println(GREEN + "   │        COLONNE A         │        COLONNE B         │" + RESET);
        System.out.println(GREEN + "   ├──────────────────────────┼──────────────────────────┤" + RESET);
        for (int i = 0; i < half; i++) {
            String patternA = i < patterns.size() ? patterns.get(i) : "";
            String patternB = (i + half) < patterns.size() ? patterns.get(i + half) : "";
            System.out.printf(GREEN + "   │ " + RESET + "%2d. %-20s " + GREEN + "│ " + RESET + "%2d. %-20s " + GREEN + "│\n" + RESET,
                            i + 1, patternA, i + half + 1, patternB);
        }
        System.out.println(GREEN + "   └──────────────────────────┴──────────────────────────┘" + RESET);
        System.out.print(YELLOW + "\n Premier pattern (numéro) : " + RESET);
        String input1 = getInput("");
        System.out.print(YELLOW + " Deuxième pattern (numéro) : " + RESET);
        String input2 = getInput("");
        try {
            int idx1 = Integer.parseInt(input1) - 1;
            int idx2 = Integer.parseInt(input2) - 1;
            if (idx1 >= 0 && idx1 < patterns.size() && idx2 >= 0 && idx2 < patterns.size()) {
                PatternComparator.compare(patterns.get(idx1), patterns.get(idx2), this);
            }
        } catch (NumberFormatException e) {
            displayMessage(" Entrée invalide !", "error");
        }
        waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
    }
    @Override
    public void showAchievements() {
        clearScreen();
        displayBanner(" HALL DE LA RENOMMÉE");
        PlayerProgress progress = GameManager.getInstance().getPlayerProgress();
        AchievementSystem achievements = AchievementSystem.getInstance();
        System.out.println("\n" + CYAN + "   VOS RÉCOMPENSES ET ACCOMPLISSEMENTS" + RESET);
        int total = achievements.getTotalAchievements();
        int unlocked = achievements.getUnlockedCount(progress);
        System.out.println("\n" + YELLOW + "    PROGRESSION : " + unlocked + "/" + total + " réalisations" + RESET);
        System.out.print("   [");
        for (int i = 0; i < 40; i++) {
            System.out.print(i < (unlocked * 40 / total) ? "▓" : "░");
        }
        System.out.printf("] %d%%\n", (unlocked * 100 / total));
        List<Achievement> allAchievements = achievements.getAllAchievements();
        for (Achievement achievement : allAchievements) {
            boolean isUnlocked = achievements.isUnlocked(achievement.getId(), progress);
            System.out.printf("\n   %s %s\n", isUnlocked ? "🏅" : "🔒", achievement.getName());
            System.out.println("      " + achievement.getDescription());
            if (isUnlocked) {
                System.out.println("       " + achievement.getPoints() + " points");
            }
        }
        waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
    }
    @Override
    public void showHelp() {
        clearScreen();
        displayBanner(" GUIDE & AIDE");
        displayCard(" COMMENT JOUER", """
            • Parcourez la bibliothèque pour découvrir les 23 patterns
            • Choisissez un pattern pour voir ses détails complets
            • Suivez les sessions d'apprentissage étape par étape
            • Testez vos connaissances avec les quiz interactifs
            • Utilisez différentes stratégies d'apprentissage
            • Suivez votre progression dans le tableau de bord
            • Débloquez des réalisations en apprenant
            """);
        displayCard(" SYSTÈME DE POINTS", """
            • Session d'apprentissage : +100 XP
            • Quiz parfait : +200 XP
            • Pattern maîtrisé : +300 XP
            • Réalisation débloquée : +500 XP
            • Niveau atteint : +1000 XP
            """);
        displayCard(" CONSEILS D'APPRENTISSAGE", """
            • Commencez par les patterns créationnels
            • Pratiquez avec les exemples de code
            • Comparez les patterns similaires
            • Utilisez différentes stratégies
            • Revisez régulièrement
            • Codez vos propres exemples
            """);
        waitForKey("\n⏎ Appuyez sur Entrée pour retourner au menu...");
    }
    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    @Override
    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(50));
        }
    }
    @Override
    public void waitForKey() {
        System.out.print(YELLOW + "\n⏎ Appuyez sur Entrée pour continuer..." + RESET);
        scanner.nextLine();
    }
    @Override
    public void waitForKey(String message) {
        System.out.print(YELLOW + message + RESET);
        scanner.nextLine();
    }
    @Override
    public void displayMessage(String message, String type) {
        String color = WHITE;
        String icon = "";
        switch (type.toLowerCase()) {
            case "success": color = GREEN; icon = ""; break;
            case "error": color = RED; icon = ""; break;
            case "warning": color = YELLOW; icon = ""; break;
            case "info": color = CYAN; icon = "ℹ"; break;
        }
        System.out.println("\n" + color + icon + " " + message + RESET);
    }
    @Override
    public void displayBanner(String title) {
        System.out.println(PURPLE + "\n" + "╔══════════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + "║" + CYAN + BOLD + centerText(title, 78) + RESET + PURPLE + "║" + RESET);
        System.out.println(PURPLE + "╚══════════════════════════════════════════════════════════════════════════════╝" + RESET);
    }
    @Override
    public void displaySection(String title) {
        System.out.println("\n" + GREEN + BOLD + "   " + title + RESET);
        System.out.println(GREEN + "   " + "─".repeat(title.length() + 2) + RESET);
    }
    @Override
    public void displayCard(String title, String content) {
        System.out.println("\n" + CYAN + "   ┌─ " + title + " " + "─".repeat(68 - title.length()) + "┐" + RESET);
        String[] lines = content.split("\n");
        for (String line : lines) {
            System.out.println(CYAN + "   │ " + RESET + line + " ".repeat(70 - line.length()) + CYAN + " │" + RESET);
        }
        System.out.println(CYAN + "   └" + "─".repeat(70) + "┘" + RESET);
    }
    @Override
    public void displayPatternCard(String name, String category, String description, String[] examples) {
        System.out.println("\n" + GREEN + "   ┌────────────────────────────────────────────────────────────────────┐" + RESET);
        System.out.printf(GREEN + "   │ " + BOLD + "%-58s " + GREEN + "│\n" + RESET, name);
        System.out.println(GREEN + "   ├────────────────────────────────────────────────────────────────────┤" + RESET);
        System.out.printf(GREEN + "   │ " + RESET + "%-58s " + GREEN + "│\n" + RESET, "📁 Catégorie : " + category);
        System.out.printf(GREEN + "   │ " + RESET + "%-58s " + GREEN + "│\n" + RESET, "📖 " + description);
        System.out.println(GREEN + "   ├────────────────────────────────────────────────────────────────────┤" + RESET);
        System.out.println(GREEN + "   │ " + RESET + "💡 Exemples d'utilisation :" + " ".repeat(38) + GREEN + "│" + RESET);
        for (String example : examples) {
            System.out.printf(GREEN + "   │ " + RESET + "   • %-54s " + GREEN + "│\n" + RESET, example);
        }
        System.out.println(GREEN + "   └────────────────────────────────────────────────────────────────────┘" + RESET);
    }
    @Override
    public void displayQuiz(String question, String[] options) {
        System.out.println("\n" + CYAN + "    " + question + RESET);
        System.out.println();
        for (int i = 0; i < options.length; i++) {
            System.out.printf("      " + GREEN + "%c. " + RESET + "%s\n", (char)('A' + i), options[i]);
        }
    }
    private String centerText(String text, int width) {
        if (text.length() >= width) return text;
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }
}
class GameManager {
    private static GameManager instance;
    private PlayerProgress playerProgress;
    private GameManager() {
        this.playerProgress = new PlayerProgress("Joueur");
    }
    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    public PlayerProgress getPlayerProgress() {
        return playerProgress;
    }
    public void setPlayerName(String name) {
        playerProgress.setPlayerName(name);
    }
    public void addXP(int xp) {
        playerProgress.addXP(xp);
    }
    public void completePattern(String patternName) {
        playerProgress.completePattern(patternName);
        AchievementSystem.getInstance().checkAchievements(playerProgress);
    }
}
interface LearningStrategy {
    String getName();
    String getDescription();
    int getDuration();
    String getStyle();
    int getDifficulty();
    void execute(GameUI ui, String patternName);
}
class VisualStrategy implements LearningStrategy {
    @Override public String getName() { return "Stratégie Visuelle"; }
    @Override public String getDescription() { return "Apprenez avec des diagrammes UML et des schémas interactifs"; }
    @Override public int getDuration() { return 45; }
    @Override public String getStyle() { return "Visuel/Spatial"; }
    @Override public int getDifficulty() { return 2; }
    @Override
    public void execute(GameUI ui, String patternName) {
        ui.displayMessage(" Démarrage de la stratégie visuelle...", "info");
        PatternInfo pattern = PatternDatabase.getPattern(patternName);
        if (pattern != null) {
            ui.displaySection(" DIAGRAMME UML DÉTAILLÉ");
            System.out.println("\n" + pattern.getUmlDiagram());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour voir la structure...");
            ui.displaySection("  STRUCTURE DES CLASSES");
            System.out.println(pattern.getStructure());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour continuer...");
            ui.displaySection(" RELATIONS ENTRE CLASSES");
            System.out.println(pattern.getRelations());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour terminer...");
        }
    }
}
class PracticalStrategy implements LearningStrategy {
    @Override public String getName() { return "Stratégie Pratique"; }
    @Override public String getDescription() { return "Codez des exemples concrets et résolvez des exercices"; }
    @Override public int getDuration() { return 60; }
    @Override public String getStyle() { return "Kinesthésique"; }
    @Override public int getDifficulty() { return 3; }
    @Override
    public void execute(GameUI ui, String patternName) {
        ui.displayMessage(" Démarrage de la stratégie pratique...", "info");
        PatternInfo pattern = PatternDatabase.getPattern(patternName);
        if (pattern != null) {
            ui.displaySection(" EXEMPLE DE CODE COMPLET");
            System.out.println(pattern.getFullCodeExample());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour l'exercice...");
            ui.displaySection(" EXERCICE PRATIQUE");
            System.out.println(pattern.getExercise());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour la solution...");
            ui.displaySection(" SOLUTION GUIDÉE");
            System.out.println(pattern.getExerciseSolution());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour terminer...");
        }
    }
}
class TheoreticalStrategy implements LearningStrategy {
    @Override public String getName() { return "Stratégie Théorique"; }
    @Override public String getDescription() { return "Approfondissez les concepts théoriques et principes"; }
    @Override public int getDuration() { return 30; }
    @Override public String getStyle() { return "Linguistique/Logique"; }
    @Override public int getDifficulty() { return 1; }
    @Override
    public void execute(GameUI ui, String patternName) {
        ui.displayMessage(" Démarrage de la stratégie théorique...", "info");
        PatternInfo pattern = PatternDatabase.getPattern(patternName);
        if (pattern != null) {
            ui.displaySection(" DÉFINITIONS ET CONCEPTS");
            System.out.println(pattern.getTheory());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour les principes...");
            ui.displaySection(" PRINCIPES SOLID ASSOCIÉS");
            System.out.println(pattern.getSolidPrinciples());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour les bonnes pratiques...");
            ui.displaySection(" BONNES PRATIQUES");
            System.out.println(pattern.getBestPractices());
            ui.waitForKey("\n⏎ Appuyez sur Entrée pour terminer...");
        }
    }
}
class MixedStrategy implements LearningStrategy {
    @Override public String getName() { return "Stratégie Mixte"; }
    @Override public String getDescription() { return "Combine visuel, pratique et théorique pour un apprentissage complet"; }
    @Override public int getDuration() { return 90; }
    @Override public String getStyle() { return "Multimodale"; }
    @Override public int getDifficulty() { return 2; }
    @Override
    public void execute(GameUI ui, String patternName) {
        ui.displayMessage(" Démarrage de la stratégie mixte...", "info");
        LearningStrategy[] strategies = {
            new TheoreticalStrategy(),
            new VisualStrategy(),
            new PracticalStrategy()
        };
        for (LearningStrategy strategy : strategies) {
            ui.clearScreen();
            ui.displaySection("⚡ " + strategy.getName().toUpperCase());
            strategy.execute(ui, patternName);
        }
        ui.displayMessage(" Stratégie mixte complétée avec succès !", "success");
    }
}
class LearningStrategyFactory {
    public static LearningStrategy[] getAllStrategies() {
        return new LearningStrategy[] {
            new VisualStrategy(),
            new PracticalStrategy(),
            new TheoreticalStrategy(),
            new MixedStrategy()
        };
    }
    public static LearningStrategy getStrategy(int index) {
        LearningStrategy[] strategies = getAllStrategies();
        return index >= 0 && index < strategies.length ? strategies[index] : new MixedStrategy();
    }
}
class PlayerProgress {
    private String playerName;
    private int level;
    private int xp;
    private List<String> masteredPatterns;
    private List<String> achievements;
    private Map<String, Integer> quizScores;
    public PlayerProgress(String playerName) {
        this.playerName = playerName;
        this.level = 1;
        this.xp = 0;
        this.masteredPatterns = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.quizScores = new HashMap<>();
    }
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    public void addXP(int amount) {
        this.xp += amount;
        checkLevelUp();
    }
    public void completePattern(String patternName) {
        if (!masteredPatterns.contains(patternName)) {
            masteredPatterns.add(patternName);
            addXP(300);
        }
    }
    public void addAchievement(String achievementId) {
        if (!achievements.contains(achievementId)) {
            achievements.add(achievementId);
            addXP(500);
        }
    }
    public void addQuizScore(String patternName, int score) {
        quizScores.put(patternName, score);
        if (score >= 80) {
            completePattern(patternName);
        }
    }
    private void checkLevelUp() {
        int newLevel = xp / 1000 + 1;
        if (newLevel > level) {
            level = newLevel;
        }
    }
    public String getPlayerName() { return playerName; }
    public int getLevel() { return level; }
    public int getTotalXP() { return xp; }
    public List<String> getMasteredPatterns() { return masteredPatterns; }
    public List<String> getAchievements() { return achievements; }
    public int getProgressPercentage() {
        int totalPatterns = PatternDatabase.getAllPatternNames().size();
        return totalPatterns > 0 ? (masteredPatterns.size() * 100) / totalPatterns : 0;
    }
    public List<String> getPatternsByCategory(String category) {
        List<String> patterns = new ArrayList<>();
        for (String patternName : masteredPatterns) {
            PatternInfo pattern = PatternDatabase.getPattern(patternName);
            if (pattern != null && pattern.getCategory().equals(category)) {
                patterns.add(patternName);
            }
        }
        return patterns;
    }
    public List<String> getRecentAchievements(int count) {
        int start = Math.max(0, achievements.size() - count);
        return new ArrayList<>(achievements.subList(start, achievements.size()));
    }
}
class AchievementSystem {
    private static AchievementSystem instance;
    private Map<String, Achievement> achievements;
    private AchievementSystem() {
        achievements = new HashMap<>();
        initializeAchievements();
    }
    public static synchronized AchievementSystem getInstance() {
        if (instance == null) {
            instance = new AchievementSystem();
        }
        return instance;
    }
    private void initializeAchievements() {
        addAchievement("first_pattern", "Premier Pas", "Apprenez votre premier design pattern", 100);
        addAchievement("pattern_collector", "Collectionneur", "Maîtrisez 5 patterns différents", 200);
        addAchievement("pattern_master", "Maître des Patterns", "Maîtrisez 10 patterns différents", 500);
        addAchievement("creational_expert", "Expert Créationnel", "Maîtrisez tous les patterns créationnels", 300);
        addAchievement("structural_expert", "Expert Structurel", "Maîtrisez tous les patterns structurels", 300);
        addAchievement("behavioral_expert", "Expert Comportemental", "Maîtrisez tous les patterns comportementaux", 300);
        addAchievement("quiz_champion", "Champion des Quiz", "Obtenez 100% à 3 quiz différents", 250);
        addAchievement("speed_learner", "Apprenant Rapide", "Complétez 5 sessions en moins de 30 minutes", 150);
        addAchievement("strategy_master", "Maître des Stratégies", "Utilisez les 4 stratégies d'apprentissage", 200);
        addAchievement("pattern_guru", "Guru des Patterns", "Maîtrisez tous les 23 design patterns", 1000);
    }
    private void addAchievement(String id, String name, String description, int points) {
        achievements.put(id, new Achievement(id, name, description, points));
    }
    public void checkAchievements(PlayerProgress progress) {
        List<String> mastered = progress.getMasteredPatterns();
        if (mastered.size() >= 1 && !progress.getAchievements().contains("first_pattern")) {
            unlockAchievement("first_pattern", progress);
        }
        if (mastered.size() >= 5 && !progress.getAchievements().contains("pattern_collector")) {
            unlockAchievement("pattern_collector", progress);
        }
        if (mastered.size() >= 10 && !progress.getAchievements().contains("pattern_master")) {
            unlockAchievement("pattern_master", progress);
        }
        if (mastered.size() == PatternDatabase.getAllPatternNames().size() && 
            !progress.getAchievements().contains("pattern_guru")) {
            unlockAchievement("pattern_guru", progress);
        }
        checkCategoryAchievements(progress, mastered);
    }
    private void checkCategoryAchievements(PlayerProgress progress, List<String> mastered) {
        int creationnelCount = 0;
        int structurelCount = 0;
        int comportementalCount = 0;
        for (String patternName : mastered) {
            PatternInfo pattern = PatternDatabase.getPattern(patternName);
            if (pattern != null) {
                switch (pattern.getCategory()) {
                    case "Créationnel": creationnelCount++; break;
                    case "Structurel": structurelCount++; break;
                    case "Comportemental": comportementalCount++; break;
                }
            }
        }
        if (creationnelCount == 5 && !progress.getAchievements().contains("creational_expert")) {
            unlockAchievement("creational_expert", progress);
        }
        if (structurelCount == 7 && !progress.getAchievements().contains("structural_expert")) {
            unlockAchievement("structural_expert", progress);
        }
        if (comportementalCount == 11 && !progress.getAchievements().contains("behavioral_expert")) {
            unlockAchievement("behavioral_expert", progress);
        }
    }
    private void unlockAchievement(String achievementId, PlayerProgress progress) {
        progress.addAchievement(achievementId);
    }
    public List<Achievement> getAllAchievements() {
        return new ArrayList<>(achievements.values());
    }
    public int getTotalAchievements() {
        return achievements.size();
    }
    public int getUnlockedCount(PlayerProgress progress) {
        int count = 0;
        for (String achievementId : progress.getAchievements()) {
            if (achievements.containsKey(achievementId)) {
                count++;
            }
        }
        return count;
    }
    public boolean isUnlocked(String achievementId, PlayerProgress progress) {
        return progress.getAchievements().contains(achievementId);
    }
}
class Achievement {
    private String id;
    private String name;
    private String description;
    private int points;
    public Achievement(String id, String name, String description, int points) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.points = points;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPoints() { return points; }
}
class QuizSession {
    private PatternInfo pattern;
    private int score;
    private int totalQuestions;
    private List<QuizQuestion> questions;
    public QuizSession(PatternInfo pattern) {
        this.pattern = pattern;
        this.score = 0;
        this.totalQuestions = 5;
        this.questions = generateQuestions();
    }
    private List<QuizQuestion> generateQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion(
            "Quelle est la caractéristique principale du pattern " + pattern.getName() + "?",
            pattern.getQuizOptions(),
            pattern.getQuizAnswer()
        ));
        questions.add(new QuizQuestion(
            "À quelle catégorie appartient le pattern " + pattern.getName() + "?",
            new String[]{"Créationnel", "Structurel", "Comportemental", "Architectural"},
            getCategoryAnswer(pattern.getCategory())
        ));
        questions.add(new QuizQuestion(
            "Quel problème résout principalement ce pattern?",
            new String[]{
                pattern.getProblem(),
                "Optimisation des performances",
                "Sécurité des données", 
                "Interface utilisateur"
            },
            "A"
        ));
        String[] advantages = pattern.getAdvantages();
        questions.add(new QuizQuestion(
            "Quel est un avantage du pattern " + pattern.getName() + "?",
            advantages.length > 0 ? 
                new String[]{advantages[0], "Rapidité d'exécution", "Faible mémoire", "Simplicité"} :
                new String[]{"Flexibilité", "Performance", "Sécurité", "Simplicité"},
            "A"
        ));
        String[] examples = pattern.getExamples();
        questions.add(new QuizQuestion(
            "Dans quel contexte utiliseriez-vous ce pattern?",
            examples.length > 0 ? 
                new String[]{examples[0], "Calcul scientifique", "Réseau neuronal", "Jeu vidéo"} :
                new String[]{"Architecture logicielle", "Base de données", "Interface graphique", "Réseau"},
            "A"
        ));
        return questions;
    }
    private String getCategoryAnswer(String category) {
        switch (category) {
            case "Créationnel": return "A";
            case "Structurel": return "B";
            case "Comportemental": return "C";
            default: return "A";
        }
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < Math.min(totalQuestions, questions.size()); i++) {
            QuizQuestion question = questions.get(i);
            System.out.println("\n" + "?".repeat(60));
            System.out.println("   Question " + (i + 1) + "/" + Math.min(totalQuestions, questions.size()));
            System.out.println("?".repeat(60));
            System.out.println("\n " + question.getQuestion());
            System.out.println();
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.printf("   %c. %s\n", (char)('A' + j), options[j]);
            }
            System.out.print("\n👉 Votre réponse (A/B/C/D) : ");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals(question.getCorrectAnswer())) {
                System.out.println("\n Correct ! +20 points");
                score += 20;
            } else {
                System.out.println("\n Faux ! La bonne réponse était : " + question.getCorrectAnswer());
            }
            if (i < Math.min(totalQuestions, questions.size()) - 1) {
                System.out.print("\n⏎ Appuyez sur Entrée pour la question suivante...");
                scanner.nextLine();
            }
        }
        System.out.println("\n" + "⭐".repeat(60));
        System.out.println("   RÉSULTATS DU QUIZ");
        System.out.println("⭐".repeat(60));
        System.out.printf("\n Score final : %d/%d\n", score, totalQuestions * 20);
        System.out.printf(" Pourcentage : %d%%\n", (score * 100) / (totalQuestions * 20));
        if (score >= 80) {
            System.out.println("\n Excellent ! Vous maîtrisez bien ce pattern !");
        } else if (score >= 60) {
            System.out.println("\n Bien ! Quelques révisions seraient bénéfiques.");
        } else {
            System.out.println("\n À revoir ! Consultez à nouveau la session d'apprentissage.");
        }
        GameManager.getInstance().getPlayerProgress().addQuizScore(pattern.getName(), 
            (score * 100) / (totalQuestions * 20));
        GameManager.getInstance().addXP(score);
    }
}
class QuizQuestion {
    private String question;
    private String[] options;
    private String correctAnswer;
    public QuizQuestion(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
}
class PatternComparator {
    public static void compare(String pattern1Name, String pattern2Name, GameUI ui) {
        PatternInfo pattern1 = PatternDatabase.getPattern(pattern1Name);
        PatternInfo pattern2 = PatternDatabase.getPattern(pattern2Name);
        if (pattern1 == null || pattern2 == null) {
            ui.displayMessage(" Impossible de comparer les patterns", "error");
            return;
        }
        ui.clearScreen();
        ui.displayBanner(" COMPARAISON : " + pattern1Name.toUpperCase() + " vs " + pattern2Name.toUpperCase());
        System.out.println("\n" + "╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-40s │ %-37s ║\n", pattern1Name, pattern2Name);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ 📁 Catégorie : %-30s │ 📁 Catégorie : %-27s ║\n", 
                         pattern1.getCategory(), pattern2.getCategory());
        System.out.printf("║  Difficulté : %-30s │  Difficulté : %-27s ║\n",
                         "★".repeat(pattern1.getDifficulty()), "★".repeat(pattern2.getDifficulty()));
        System.out.printf("║  Fréquence : %-31s │  Fréquence : %-28s ║\n",
                         pattern1.getFrequency(), pattern2.getFrequency());
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║  QUAND UTILISER :" + " ".repeat(61) + "║");
        String when1 = pattern1.getWhenToUse();
        String when2 = pattern2.getWhenToUse();
        String[] lines1 = splitText(when1, 38);
        String[] lines2 = splitText(when2, 38);
        int maxLines = Math.max(lines1.length, lines2.length);
        for (int i = 0; i < maxLines; i++) {
            String line1 = i < lines1.length ? lines1[i] : "";
            String line2 = i < lines2.length ? lines2[i] : "";
            System.out.printf("║ • %-36s │ • %-35s ║\n", line1, line2);
        }
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║  PATTERNS CONNEXES :" + " ".repeat(57) + "║");
        String[] related1 = pattern1.getRelatedPatterns();
        String[] related2 = pattern2.getRelatedPatterns();
        maxLines = Math.max(related1.length, related2.length);
        for (int i = 0; i < maxLines; i++) {
            String rel1 = i < related1.length ? related1[i] : "";
            String rel2 = i < related2.length ? related2[i] : "";
            System.out.printf("║ • %-36s │ • %-35s ║\n", rel1, rel2);
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("\n" + " " + getComparisonRecommendation(pattern1, pattern2));
    }
    private static String[] splitText(String text, int maxLength) {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();
        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= maxLength) {
                if (currentLine.length() > 0) currentLine.append(" ");
                currentLine.append(word);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
        }
        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }
        return lines.toArray(new String[0]);
    }
    private static String getComparisonRecommendation(PatternInfo p1, PatternInfo p2) {
        if (p1.getCategory().equals(p2.getCategory())) {
            return "Ces deux patterns sont de la même catégorie. " +
                   "Choisissez " + p1.getName() + " pour " + p1.getWhenToUse().toLowerCase() + 
                   " et " + p2.getName() + " pour " + p2.getWhenToUse().toLowerCase();
        } else {
            return p1.getName() + " est un pattern " + p1.getCategory().toLowerCase() + 
                   " tandis que " + p2.getName() + " est un pattern " + p2.getCategory().toLowerCase() +
                   ". Ils résolvent des problèmes différents dans le cycle de développement.";
        }
    }
}
class GameSystem {
    private GameUI ui;
    private boolean running;
    public GameSystem(GameUI ui) {
        this.ui = ui;
        this.running = true;
    }
    public void start() {
        ui.clearScreen();
        System.out.print("\n Entrez votre nom : ");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Apprenti Pattern";
        }
        GameManager.getInstance().setPlayerName(playerName);
        ui.showTitle();
        mainGameLoop();
    }
    private void mainGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            ui.showMainMenu(GameManager.getInstance().getPlayerProgress().getPlayerName());
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit") || input.equals("9")) {
                running = false;
                ui.displayMessage(" Merci d'avoir joué ! À bientôt !", "success");
                continue;
            }
            if (input.equalsIgnoreCase("menu")) {
                continue;
            }
            try {
                int choice = Integer.parseInt(input);
                handleMenuChoice(choice);
            } catch (NumberFormatException e) {
                ui.displayMessage(" Veuillez entrer un nombre valide.", "error");
                ui.waitForKey();
            }
        }
    }
    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                handlePatternLibrary();
                break;
            case 2:
                handleLearningSession();
                break;
            case 3:
                handleQuiz();
                break;
            case 4:
                handleStrategySelection();
                break;
            case 5:
                ui.showProgressDashboard();
                break;
            case 6:
                ui.showPatternComparison();
                break;
            case 7:
                ui.showAchievements();
                break;
            case 8:
                ui.showHelp();
                break;
            default:
                ui.displayMessage(" Choix invalide !", "error");
                ui.waitForKey();
        }
    }
    private void handlePatternLibrary() {
        ui.showPatternLibrary();
        String input = ui.getInput("");
        if (input.equalsIgnoreCase("menu")) {
            return;
        }
        if (PatternDatabase.getPattern(input) != null) {
            ui.showPatternDetails(input);
            handlePatternDetails(input);
        } else {
            ui.displayMessage(" Pattern non trouvé. Essayez 'Singleton', 'Factory', etc.", "error");
            ui.waitForKey();
        }
    }
    private void handlePatternDetails(String patternName) {
        String input = ui.getInput("");
        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    ui.showLearningSession(patternName);
                    GameManager.getInstance().completePattern(patternName);
                    GameManager.getInstance().addXP(100);
                    break;
                case 2:
                    ui.showQuizSession(patternName);
                    break;
                case 3:
                    handlePatternStrategy(patternName);
                    break;
                case 4:
                    handlePatternComparisonSelection(patternName);
                    break;
                case 5:
                    break;
                default:
                    ui.displayMessage(" Choix invalide !", "error");
            }
        } catch (NumberFormatException e) {
        }
    }
    private void handleLearningSession() {
        ui.clearScreen();
        ui.displayBanner(" SÉLECTION DU PATTERN À APPRENDRE");
        List<String> patterns = PatternDatabase.getAllPatternNames();
        for (int i = 0; i < patterns.size(); i++) {
            System.out.printf("   %2d. %s\n", i + 1, patterns.get(i));
        }
        System.out.print("\n Votre choix : ");
        String input = ui.getInput("");
        try {
            int choice = Integer.parseInt(input) - 1;
            if (choice >= 0 && choice < patterns.size()) {
                ui.showLearningSession(patterns.get(choice));
                GameManager.getInstance().completePattern(patterns.get(choice));
                GameManager.getInstance().addXP(100);
            } else {
                ui.displayMessage(" Choix invalide !", "error");
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
    }
    private void handleQuiz() {
        ui.clearScreen();
        ui.displayBanner(" SÉLECTION DU QUIZ");
        System.out.println("\n   Choisissez un type de quiz :");
        System.out.println("   1. Quiz par pattern spécifique");
        System.out.println("   2. Quiz par catégorie");
        System.out.println("   3. Quiz mixte (tous les patterns)");
        System.out.println("   4. Retour au menu");
        System.out.print("\n Votre choix : ");
        String input = ui.getInput("");
        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    handleSpecificPatternQuiz();
                    break;
                case 2:
                    handleCategoryQuiz();
                    break;
                case 3:
                    handleMixedQuiz();
                    break;
                case 4:
                    break;
                default:
                    ui.displayMessage(" Choix invalide !", "error");
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
    }
    private void handleSpecificPatternQuiz() {
        System.out.println("\n   Sélectionnez un pattern :\n");
        List<String> patterns = PatternDatabase.getAllPatternNames();
        for (int i = 0; i < patterns.size(); i++) {
            System.out.printf("   %2d. %s\n", i + 1, patterns.get(i));
        }
        System.out.print("\n Votre choix : ");
        String input = ui.getInput("");
        try {
            int choice = Integer.parseInt(input) - 1;
            if (choice >= 0 && choice < patterns.size()) {
                ui.showQuizSession(patterns.get(choice));
            } else {
                ui.displayMessage(" Choix invalide !", "error");
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
    }
    private void handleCategoryQuiz() {
        System.out.println("\n   Sélectionnez une catégorie :");
        System.out.println("   1. Patterns Créationnels");
        System.out.println("   2.  Patterns Structurels");
        System.out.println("   3. Patterns Comportementaux");
        System.out.print("\n Votre choix : ");
        String input = ui.getInput("");
        try {
            int choice = Integer.parseInt(input);
            String category = "";
            switch (choice) {
                case 1: category = "Créationnel"; break;
                case 2: category = "Structurel"; break;
                case 3: category = "Comportemental"; break;
                default:
                    ui.displayMessage(" Choix invalide !", "error");
                    return;
            }
            List<String> patterns = PatternDatabase.getPatternsByCategory(category);
            if (!patterns.isEmpty()) {
                Random random = new Random();
                String randomPattern = patterns.get(random.nextInt(patterns.size()));
                ui.showQuizSession(randomPattern);
            } else {
                ui.displayMessage(" Aucun pattern dans cette catégorie !", "error");
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
    }
    private void handleMixedQuiz() {
        ui.clearScreen();
        ui.displayBanner("🧠 QUIZ MIXTE - TOUS LES PATTERNS");
        List<String> patterns = PatternDatabase.getAllPatternNames();
        Random random = new Random();
        int score = 0;
        int totalQuestions = 5;
        ui.displayMessage("Préparez-vous pour un quiz de 5 questions sur différents patterns !", "info");
        ui.waitForKey("\n⏎ Appuyez sur Entrée pour commencer...");
        for (int i = 0; i < totalQuestions; i++) {
            String pattern = patterns.get(random.nextInt(patterns.size()));
            PatternInfo info = PatternDatabase.getPattern(pattern);
            if (info != null) {
                ui.clearScreen();
                System.out.println("\n" + "?".repeat(60));
                System.out.println("   Question " + (i + 1) + "/" + totalQuestions);
                System.out.println("   Pattern : " + pattern);
                System.out.println("?".repeat(60));
                ui.displayQuiz(info.getQuizQuestion(), info.getQuizOptions());
                String answer = ui.getInput("\n Votre réponse (A/B/C/D) : ").toUpperCase();
                if (answer.equals(info.getQuizAnswer())) {
                    ui.displayMessage(" Correct ! +20 points", "success");
                    score += 20;
                } else {
                    ui.displayMessage(" Faux ! La bonne réponse était : " + info.getQuizAnswer(), "error");
                }
                if (i < totalQuestions - 1) {
                    ui.waitForKey("\n⏎ Appuyez sur Entrée pour la question suivante...");
                }
            }
        }
        ui.displayMessage("\n🎉 Quiz terminé ! Score final : " + score + "/100", "success");
        GameManager.getInstance().addXP(score);
        ui.waitForKey();
    }
    private void handleStrategySelection() {
        ui.showStrategySelector();
        String input = ui.getInput("");
        try {
            int strategyChoice = Integer.parseInt(input) - 1;
            LearningStrategy strategy = LearningStrategyFactory.getStrategy(strategyChoice);
            if (strategy != null) {
                ui.displayMessage(" Stratégie sélectionnée : " + strategy.getName(), "success");
                System.out.println("\n   Sélectionnez un pattern :\n");
                List<String> patterns = PatternDatabase.getAllPatternNames();
                for (int i = 0; i < patterns.size(); i++) {
                    System.out.printf("   %2d. %s\n", i + 1, patterns.get(i));
                }
                System.out.print("\n Votre choix : ");
                String patternInput = ui.getInput("");
                try {
                    int patternChoice = Integer.parseInt(patternInput) - 1;
                    if (patternChoice >= 0 && patternChoice < patterns.size()) {
                        strategy.execute(ui, patterns.get(patternChoice));
                        GameManager.getInstance().addXP(75);
                        GameManager.getInstance().completePattern(patterns.get(patternChoice));
                    } else {
                        ui.displayMessage(" Choix invalide !", "error");
                    }
                } catch (NumberFormatException e) {
                    ui.displayMessage(" Entrée invalide !", "error");
                }
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
        ui.waitForKey();
    }
    private void handlePatternStrategy(String patternName) {
        ui.showStrategySelector();
        String input = ui.getInput("");
        try {
            int strategyChoice = Integer.parseInt(input) - 1;
            LearningStrategy strategy = LearningStrategyFactory.getStrategy(strategyChoice);
            if (strategy != null) {
                strategy.execute(ui, patternName);
                GameManager.getInstance().addXP(75);
                GameManager.getInstance().completePattern(patternName);
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
        ui.waitForKey();
    }
    private void handlePatternComparisonSelection(String firstPattern) {
        ui.clearScreen();
        ui.displayBanner(" COMPARAISON AVEC " + firstPattern.toUpperCase());
        System.out.println("\n   Sélectionnez un pattern à comparer :\n");
        List<String> patterns = PatternDatabase.getAllPatternNames();
        patterns.remove(firstPattern);
        for (int i = 0; i < patterns.size(); i++) {
            System.out.printf("   %2d. %s\n", i + 1, patterns.get(i));
        }
        System.out.print("\n Votre choix : ");
        String input = ui.getInput("");
        try {
            int choice = Integer.parseInt(input) - 1;
            if (choice >= 0 && choice < patterns.size()) {
                PatternComparator.compare(firstPattern, patterns.get(choice), ui);
            } else {
                ui.displayMessage(" Choix invalide !", "error");
            }
        } catch (NumberFormatException e) {
            ui.displayMessage(" Entrée invalide !", "error");
        }
        ui.waitForKey();
    }
}
class PatternDatabase {
    private static Map<String, PatternInfo> patterns = new HashMap<>();
    static {
        initializePatterns();
    }
    private static void initializePatterns() {
        patterns.put("Singleton", new PatternInfo(
            "Singleton",
            "Créationnel",
            "Garantit qu'une classe n'a qu'une seule instance et fournit un point d'accès global à cette instance.",
            "Besoin d'une instance unique d'une classe dans toute l'application.",
            "Utiliser un constructeur privé et une méthode statique pour contrôler l'instanciation.",
            2,
            "Très élevée",
            new String[]{"Contrôle d'accès unique", "Économie de ressources", "Accès global simplifié"},
            new String[]{"Peut cacher les dépendances", "Difficile à tester", "Violation SRP"},
            new String[]{"GameManager dans les jeux", "Logger d'application", "Pool de connexions DB"},
            """
            public class Singleton {
                private static Singleton instance;
                private Singleton() {}
                public static Singleton getInstance() {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                    return instance;
                }
            }
            """,
            "Quelle est la caractéristique principale?",
            new String[]{"Une seule instance", "Création rapide", "Faible mémoire", "Thread-safe"},
            "A",
            new String[]{"Factory Method", "Builder", "Prototype"}
        ));
        patterns.put("Factory Method", new PatternInfo(
            "Factory Method",
            "Créationnel",
            "Définit une interface pour créer un objet mais laisse les sous-classes décider quelle classe instancier.",
            "Besoin de créer des objets sans spécifier leurs classes concrètes.",
            "Déléguer la création à des sous-classes via une méthode factory.",
            3,
            "Élevée",
            new String[]{"Découplage client/produit", "Extensibilité facile", "Code maintenable"},
            new String[]{"Trop de sous-classes", "Complexité accrue"},
            new String[]{"UI multiplateforme", "Génération documents", "Objets complexes"},
            """
            interface Product { void use(); }
            class ConcreteProduct implements Product {
                public void use() { System.out.println("Using product"); }
            }
            abstract class Creator {
                abstract Product factoryMethod();
                public void operation() {
                    Product p = factoryMethod();
                    p.use();
                }
            }
            """,
            "Quel problème résout-il?",
            new String[]{"Création flexible", "Performance", "Sécurité", "Mémoire"},
            "A",
            new String[]{"Abstract Factory", "Builder", "Prototype"}
        ));
        patterns.put("Abstract Factory",
            new PatternInfo(
                "Abstract Factory",
                "Créationnel",
                "Fournit une interface pour créer des familles d'objets liés sans spécifier leurs classes concrètes.",
                "Besoin de créer des familles d'objets cohérents.",
                "Définir des interfaces pour chaque produit et une fabrique abstraite pour les créer.",
                4,
                "Élevée",
                new String[]{"Familles cohérentes", "Découplage total", "Changement facile"},
                new String[]{"Complexe à implémenter", "Nombreuses classes"},
                new String[]{"UI multiplateforme", "Système de thèmes", "Bases de données"},
                """
                interface Button { void paint(); }
                interface Checkbox { void paint(); }
                interface GUIFactory {
                    Button createButton();
                    Checkbox createCheckbox();
                }
                class WinFactory implements GUIFactory {
                    public Button createButton() { return new WinButton(); }
                    public Checkbox createCheckbox() { return new WinCheckbox(); }
                }
                """,
                "Pourquoi utiliser Abstract Factory?",
                new String[]{"Familles d'objets", "Performance", "Simplicité", "Sécurité"},
                "A",
                new String[]{"Factory Method", "Builder", "Prototype"}
            ));
        patterns.put("Builder",
            new PatternInfo(
                "Builder",
                "Créationnel",
                "Sépare la construction d'un objet complexe de sa représentation, permettant la même construction pour différentes représentations.",
                "Construction d'objets complexes avec de nombreuses parties.",
                "Utiliser un builder séparé pour construire l'objet étape par étape.",
                3,
                "Élevée",
                new String[]{"Construction flexible", "Code lisible", "Même processus"},
                new String[]{"Complexité", "Nombreuses classes"},
                new String[]{"Requêtes SQL", "Rapports complexes", "Objets UI"},
                """
                class Computer {
                    private String cpu, ram, hdd;
                    private Computer(Builder builder) {
                        this.cpu = builder.cpu;
                        this.ram = builder.ram;
                        this.hdd = builder.hdd;
                    }
                    static class Builder {
                        private String cpu, ram, hdd;
                        public Builder setCPU(String cpu) { this.cpu = cpu; return this; }
                        public Builder setRAM(String ram) { this.ram = ram; return this; }
                        public Builder setHDD(String hdd) { this.hdd = hdd; return this; }
                        public Computer build() { return new Computer(this); }
                    }
                }
                """,
                "Quel est l'avantage principal?",
                new String[]{"Construction étape par étape", "Vitesse", "Mémoire", "Sécurité"},
                "A",
                new String[]{"Factory Method", "Prototype", "Composite"}
            ));
        patterns.put("Prototype",
            new PatternInfo(
                "Prototype",
                "Créationnel",
                "Crée de nouveaux objets en copiant un prototype existant plutôt qu'en créant de nouvelles instances.",
                "Coût élevé de création d'objets complexes.",
                "Implémenter une méthode clone() pour copier l'objet existant.",
                2,
                "Moyenne",
                new String[]{"Performance améliorée", "Flexibilité", "Réduction sous-classes"},
                new String[]{"Clonage complexe", "Gestion mémoire"},
                new String[]{"Éditeurs graphiques", "Jeux vidéo", "Cache d'objets"},
                """
                interface Prototype {
                    Prototype clone();
                }
                class ConcretePrototype implements Prototype {
                    private String field;
                    public ConcretePrototype(String field) {
                        this.field = field;
                    }
                    public Prototype clone() {
                        return new ConcretePrototype(this.field);
                    }
                }
                """,
                "Comment crée-t-on des objets?",
                new String[]{"Par clonage", "Par constructeur", "Par factory", "Par singleton"},
                "A",
                new String[]{"Singleton", "Factory", "Builder"}
            ));
        patterns.put("Adapter",
            new PatternInfo(
                "Adapter",
                "Structurel",
                "Convertit l'interface d'une classe en une autre interface attendue par les clients.",
                "Interface incompatible entre deux systèmes.",
                "Créer un adaptateur qui traduit entre les interfaces.",
                2,
                "Très élevée",
                new String[]{"Réutilisation code", "Intégration systèmes", "Flexibilité"},
                new String[]{"Complexité", "Performance réduite"},
                new String[]{"APIs legacy", "Compatibilité", "Wrappers"},
                """
                interface MediaPlayer {
                    void play(String audioType, String fileName);
                }
                class MediaAdapter implements MediaPlayer {
                    private AdvancedMediaPlayer advancedPlayer;
                    public MediaAdapter(String audioType) {
                        if(audioType.equalsIgnoreCase("vlc")) {
                            advancedPlayer = new VlcPlayer();
                        }
                    }
                    public void play(String audioType, String fileName) {
                        if(audioType.equalsIgnoreCase("vlc")) {
                            advancedPlayer.playVlc(fileName);
                        }
                    }
                }
                """,
                "Quel problème résout-il?",
                new String[]{"Incompatibilité interfaces", "Performance", "Mémoire", "Sécurité"},
                "A",
                new String[]{"Bridge", "Decorator", "Facade"}
            ));
        patterns.put("Bridge",
            new PatternInfo(
                "Bridge",
                "Structurel",
                "Découple une abstraction de son implémentation, permettant aux deux de varier indépendamment.",
                "Combinaison explosion de classes.",
                "Séparer l'abstraction et l'implémentation dans des hiérarchies différentes.",
                3,
                "Moyenne",
                new String[]{"Découplage", "Extensibilité", "Hiérarchies indépendantes"},
                new String[]{"Complexité", "Design complexe"},
                new String[]{"Rendu UI", "Drivers", "API multiplateforme"},
                """
                interface Renderer {
                    void renderCircle(float radius);
                }
                class VectorRenderer implements Renderer {
                    public void renderCircle(float radius) {
                        System.out.println("Drawing circle of radius " + radius);
                    }
                }
                abstract class Shape {
                    protected Renderer renderer;
                    public Shape(Renderer renderer) {
                        this.renderer = renderer;
                    }
                    public abstract void draw();
                }
                """,
                "Quel est l'avantage principal?",
                new String[]{"Découplage abstraction/implémentation", "Performance", "Simplicité", "Mémoire"},
                "A",
                new String[]{"Adapter", "Decorator", "Proxy"}
            ));
        patterns.put("Composite",
            new PatternInfo(
                "Composite",
                "Structurel",
                "Compose des objets dans des structures arborescentes pour représenter des hiérarchies partie-tout.",
                "Traitement uniforme d'objets individuels et composites.",
                "Définir une interface commune pour les feuilles et les composites.",
                3,
                "Élevée",
                new String[]{"Traitement uniforme", "Structure hiérarchique", "Extensibilité"},
                new String[]{"Généricité excessive", "Design complexe"},
                new String[]{"Systèmes de fichiers", "UI components", "Organigrammes"},
                """
                interface Component {
                    void operation();
                }
                class Leaf implements Component {
                    public void operation() {
                        System.out.println("Leaf operation");
                    }
                }
                class Composite implements Component {
                    private List<Component> children = new ArrayList<>();
                    public void add(Component component) {
                        children.add(component);
                    }
                    public void operation() {
                        for (Component child : children) {
                            child.operation();
                        }
                    }
                }
                """,
                "Quelle structure utilise-t-il?",
                new String[]{"Arborescente", "Linéaire", "Circulaire", "Réseau"},
                "A",
                new String[]{"Decorator", "Visitor", "Iterator"}
            ));
        patterns.put("Decorator",
            new PatternInfo(
                "Decorator",
                "Structurel",
                "Attache dynamiquement de nouvelles responsabilités à un objet.",
                "Ajout de fonctionnalités sans héritage.",
                "Créer des décorateurs qui enveloppent l'objet original.",
                3,
                "Élevée",
                new String[]{"Flexibilité", "Évite héritage", "Composition dynamique"},
                new String[]{"Multiples petits objets", "Complexité debugging"},
                new String[]{"Streams Java", "UI components", "Middleware"},
                """
                interface Coffee {
                    double getCost();
                    String getDescription();
                }
                class SimpleCoffee implements Coffee {
                    public double getCost() { return 1.0; }
                    public String getDescription() { return "Simple coffee"; }
                }
                abstract class CoffeeDecorator implements Coffee {
                    protected Coffee decoratedCoffee;
                    public CoffeeDecorator(Coffee coffee) {
                        this.decoratedCoffee = coffee;
                    }
                    public double getCost() { return decoratedCoffee.getCost(); }
                    public String getDescription() { return decoratedCoffee.getDescription(); }
                }
                """,
                "Comment ajoute-t-on des fonctionnalités?",
                new String[]{"Dynamiquement", "Par héritage", "Par composition", "Par agrégation"},
                "A",
                new String[]{"Adapter", "Composite", "Strategy"}
            ));
        patterns.put("Facade",
            new PatternInfo(
                "Facade",
                "Structurel",
                "Fournit une interface unifiée et simplifiée à un sous-système complexe.",
                "Interface complexe d'un sous-système.",
                "Créer une façade qui encapsule la complexité.",
                1,
                "Très élevée",
                new String[]{"Simplicité", "Découplage", "Interface unique"},
                new String[]{"God object potentiel", "Limite flexibilité"},
                new String[]{"APIs complexes", "Frameworks", "Bibliothèques"},
                """
                class CPU {
                    public void freeze() { /* ... */ }
                    public void jump(long position) { /* ... */ }
                    public void execute() { /* ... */ }
                }
                class ComputerFacade {
                    private CPU cpu;
                    public ComputerFacade() {
                        this.cpu = new CPU();
                    }
                    public void start() {
                        cpu.freeze();
                        cpu.jump(0);
                        cpu.execute();
                    }
                }
                """,
                "Quel est le but principal?",
                new String[]{"Simplifier interface", "Performance", "Sécurité", "Mémoire"},
                "A",
                new String[]{"Adapter", "Mediator", "Proxy"}
            ));
        patterns.put("Flyweight",
            new PatternInfo(
                "Flyweight",
                "Structurel",
                "Utilise le partage pour supporter efficacement un grand nombre d'objets à granularité fine.",
                "Grand nombre d'objets similaires.",
                "Partager les parties intrinsèques et externaliser les parties extrinsèques.",
                4,
                "Faible",
                new String[]{"Économie mémoire", "Performance", "Réduction objets"},
                new String[]{"Complexité", "Gestion état"},
                new String[]{"Éditeurs texte", "Jeux vidéo", "Cache"},
                """
                interface Flyweight {
                    void operation(String extrinsicState);
                }
                class ConcreteFlyweight implements Flyweight {
                    private String intrinsicState;
                    public ConcreteFlyweight(String intrinsicState) {
                        this.intrinsicState = intrinsicState;
                    }
                    public void operation(String extrinsicState) {
                        System.out.println("Intrinsic: " + intrinsicState + ", Extrinsic: " + extrinsicState);
                    }
                }
                class FlyweightFactory {
                    private Map<String, Flyweight> flyweights = new HashMap<>();
                    public Flyweight getFlyweight(String key) {
                        if (!flyweights.containsKey(key)) {
                            flyweights.put(key, new ConcreteFlyweight(key));
                        }
                        return flyweights.get(key);
                    }
                }
                """,
                "Quel est l'objectif principal?",
                new String[]{"Économie mémoire", "Performance CPU", "Sécurité", "Simplicité"},
                "A",
                new String[]{"Singleton", "Factory", "Composite"}
            ));
        patterns.put("Proxy",
            new PatternInfo(
                "Proxy",
                "Structurel",
                "Fournit un substitut ou un espace réservé pour un autre objet pour contrôler l'accès à celui-ci.",
                "Contrôle d'accès à un objet coûteux ou sensible.",
                "Créer un proxy qui implémente la même interface que l'objet réel.",
                2,
                "Élevée",
                new String[]{"Contrôle d'accès", "Optimisation", "Sécurité"},
                new String[]{"Latence", "Complexité"},
                new String[]{"Lazy loading", "Accès contrôle", "Logging"},
                """
                interface Image {
                    void display();
                }
                class RealImage implements Image {
                    private String filename;
                    public RealImage(String filename) {
                        this.filename = filename;
                        loadFromDisk();
                    }
                    private void loadFromDisk() {
                        System.out.println("Loading " + filename);
                    }
                    public void display() {
                        System.out.println("Displaying " + filename);
                    }
                }
                class ProxyImage implements Image {
                    private RealImage realImage;
                    private String filename;
                    public ProxyImage(String filename) {
                        this.filename = filename;
                    }
                    public void display() {
                        if (realImage == null) {
                            realImage = new RealImage(filename);
                        }
                        realImage.display();
                    }
                }
                """,
                "Quel est le rôle du proxy?",
                new String[]{"Contrôle d'accès", "Performance", "Mémoire", "Sécurité"},
                "A",
                new String[]{"Decorator", "Adapter", "Facade"}
            ));
        patterns.put("Strategy",
            new PatternInfo(
                "Strategy",
                "Comportemental",
                "Définit une famille d'algorithmes, encapsule chacun d'eux, et les rend interchangeables.",
                "Plusieurs algorithmes similaires.",
                "Extraire les algorithmes dans des classes avec interface commune.",
                3,
                "Très élevée",
                new String[]{"Algorithmes interchangeables", "Évite conditions", "Extensibilité"},
                new String[]{"Nombreuses classes", "Clients doivent connaître"},
                new String[]{"Algorithmes de tri", "Paiements", "Compression"},
                """
                interface PaymentStrategy {
                    void pay(int amount);
                }
                class CreditCardStrategy implements PaymentStrategy {
                    public void pay(int amount) {
                        System.out.println(amount + " paid with credit card");
                    }
                }
                class ShoppingCart {
                    private PaymentStrategy strategy;
                    public void setStrategy(PaymentStrategy strategy) {
                        this.strategy = strategy;
                    }
                    public void checkout(int amount) {
                        strategy.pay(amount);
                    }
                }
                """,
                "Quel est l'avantage principal?",
                new String[]{"Algorithmes interchangeables", "Performance", "Mémoire", "Simplicité"},
                "A",
                new String[]{"Template Method", "State", "Command"}
            ));
        patterns.put("Observer",
            new PatternInfo(
                "Observer",
                "Comportemental",
                "Définit une dépendance un-à-plusieurs entre objets pour qu'un objet change d'état, tous ses dépendants soient notifiés.",
                "Notification de changements d'état.",
                "Sujet maintient liste d'observateurs et les notifie des changements.",
                2,
                "Très élevée",
                new String[]{"Découplage", "Notification automatique", "Extensibilité"},
                new String[]{"Notifications inattendues", "Performance si nombreux"},
                new String[]{"Systèmes événementiels", "UI", "Pub/Sub"},
                """
                interface Observer {
                    void update(String message);
                }
                class Subject {
                    private List<Observer> observers = new ArrayList<>();
                    public void attach(Observer observer) {
                        observers.add(observer);
                    }
                    public void notifyObservers(String message) {
                        for (Observer observer : observers) {
                            observer.update(message);
                        }
                    }
                }
                """,
                "Quelle relation définit-il?",
                new String[]{"Un-à-plusieurs", "Plusieurs-à-plusieurs", "Un-à-un", "Aucune"},
                "A",
                new String[]{"Mediator", "Command", "Chain of Responsibility"}
            ));
        patterns.put("Command",
            new PatternInfo(
                "Command",
                "Comportemental",
                "Encapsule une requête en tant qu'objet, permettant de paramétrer les clients avec différentes requêtes.",
                "Découpler l'invocateur du récepteur.",
                "Créer des objets commande qui encapsulent l'action et ses paramètres.",
                3,
                "Élevée",
                new String[]{"Découplage", "Commandes paramétrables", "Undo/Redo"},
                new String[]{"Nombreuses classes", "Complexité"},
                new String[]{"Boutons UI", "Transactions", "Macro commands"},
                """
                interface Command {
                    void execute();
                }
                class LightOnCommand implements Command {
                    private Light light;
                    public LightOnCommand(Light light) {
                        this.light = light;
                    }
                    public void execute() {
                        light.turnOn();
                    }
                }
                class RemoteControl {
                    private Command command;
                    public void setCommand(Command command) {
                        this.command = command;
                    }
                    public void pressButton() {
                        command.execute();
                    }
                }
                """,
                "Que encapsule-t-il?",
                new String[]{"Une requête", "Une donnée", "Un état", "Une connexion"},
                "A",
                new String[]{"Strategy", "Observer", "Memento"}
            ));
        patterns.put("Iterator",
            new PatternInfo(
                "Iterator",
                "Comportemental",
                "Fournit un moyen d'accéder séquentiellement aux éléments d'une collection sans exposer sa représentation interne.",
                "Parcourir une collection de différentes manières.",
                "Définir une interface d'itérateur avec next() et hasNext().",
                1,
                "Très élevée",
                new String[]{"Parcours uniforme", "Découplage", "Multiples parcours"},
                new String[]{"Surcharge pour petites collections"},
                new String[]{"Collections Java", "Parcours arbres", "Streaming"},
                """
                interface Iterator<T> {
                    boolean hasNext();
                    T next();
                }
                interface Container<T> {
                    Iterator<T> getIterator();
                }
                class NameRepository implements Container<String> {
                    private String[] names = {"John", "Jane", "Jack"};
                    public Iterator<String> getIterator() {
                        return new NameIterator();
                    }
                    private class NameIterator implements Iterator<String> {
                        int index = 0;
                        public boolean hasNext() {
                            return index < names.length;
                        }
                        public String next() {
                            return hasNext() ? names[index++] : null;
                        }
                    }
                }
                """,
                "Quel problème résout-il?",
                new String[]{"Parcours collections", "Performance", "Mémoire", "Sécurité"},
                "A",
                new String[]{"Composite", "Visitor", "Factory"}
            ));
        patterns.put("Template Method",
            new PatternInfo(
                "Template Method",
                "Comportemental",
                "Définit le squelette d'un algorithme dans une méthode, reportant certaines étapes aux sous-classes.",
                "Algorithmes avec étapes communes.",
                "Créer une méthode template avec des méthodes abstraites pour les étapes variables.",
                2,
                "Élevée",
                new String[]{"Réutilisation code", "Structure commune", "Contrôle inversion"},
                new String[]{"Limite flexibilité", "Complexité héritage"},
                new String[]{"Frameworks", "Workflows", "Algorithmes"},
                """
                abstract class Game {
                    abstract void initialize();
                    abstract void startPlay();
                    abstract void endPlay();
                    public final void play() {
                        initialize();
                        startPlay();
                        endPlay();
                    }
                }
                class Cricket extends Game {
                    void initialize() { System.out.println("Cricket Initialized"); }
                    void startPlay() { System.out.println("Cricket Started"); }
                    void endPlay() { System.out.println("Cricket Finished"); }
                }
                """,
                "Quelle partie définit-il?",
                new String[]{"Squelette algorithme", "Implémentation", "Interface", "Structure"},
                "A",
                new String[]{"Strategy", "Factory Method", "Command"}
            ));
        patterns.put("Visitor",
            new PatternInfo(
                "Visitor",
                "Comportemental",
                "Représente une opération à effectuer sur les éléments d'une structure d'objets.",
                "Nouvelles opérations sur structure existante.",
                "Séparer l'algorithme des objets sur lesquels il opère.",
                5,
                "Moyenne",
                new String[]{"Nouvelles opérations", "Découplage", "SRP respecté"},
                new String[]{"Difficile ajout éléments", "Accès privé"},
                new String[]{"Compilateurs", "Interpréteurs", "Analyse syntaxique"},
                """
                interface ComputerPart {
                    void accept(ComputerPartVisitor visitor);
                }
                interface ComputerPartVisitor {
                    void visit(Computer computer);
                    void visit(Mouse mouse);
                }
                class Computer implements ComputerPart {
                    public void accept(ComputerPartVisitor visitor) {
                        visitor.visit(this);
                    }
                }
                """,
                "Quel est l'objectif principal?",
                new String[]{"Nouvelles opérations", "Performance", "Mémoire", "Sécurité"},
                "A",
                new String[]{"Iterator", "Composite", "Interpreter"}
            ));
        patterns.put("Mediator",
            new PatternInfo(
                "Mediator",
                "Comportemental",
                "Définit un objet qui encapsule la façon dont un ensemble d'objets interagissent.",
                "Communication complexe entre objets.",
                "Créer un médiateur qui contrôle la communication.",
                3,
                "Moyenne",
                new String[]{"Découplage objets", "Communication centralisée", "Réduction dépendances"},
                new String[]{"God object potentiel", "Complexité médiateur"},
                new String[]{"Systèmes de chat", "UI components", "Workflow"},
                """
                interface Mediator {
                    void sendMessage(String message, Colleague colleague);
                }
                abstract class Colleague {
                    protected Mediator mediator;
                    public Colleague(Mediator mediator) {
                        this.mediator = mediator;
                    }
                }
                class ConcreteMediator implements Mediator {
                    private Colleague colleague1, colleague2;
                    public void setColleague1(Colleague colleague) {
                        this.colleague1 = colleague;
                    }
                    public void sendMessage(String message, Colleague colleague) {
                        if (colleague == colleague1) {
                            // send to colleague2
                        }
                    }
                }
                """,
                "Quel rôle joue le médiateur?",
                new String[]{"Coordinateur communication", "Observateur", "Contrôleur", "Modèle"},
                "A",
                new String[]{"Observer", "Facade", "Command"}
            ));
        patterns.put("Memento",
            new PatternInfo(
                "Memento",
                "Comportemental",
                "Capture et externalise l'état interne d'un objet sans violer l'encapsulation.",
                "Sauvegarde et restauration d'état.",
                "Créer des mementos qui stockent l'état et un caretaker qui les gère.",
                3,
                "Moyenne",
                new String[]{"Encapsulation préservée", "Undo/Redo", "Sauvegarde état"},
                new String[]{"Coût mémoire", "Performance sauvegarde"},
                new String[]{"Éditeurs texte", "Jeux vidéo", "Transactions"},
                """
                class Memento {
                    private String state;
                    public Memento(String state) { this.state = state; }
                    public String getState() { return state; }
                }
                class Originator {
                    private String state;
                    public void setState(String state) { this.state = state; }
                    public Memento save() { return new Memento(state); }
                    public void restore(Memento memento) { state = memento.getState(); }
                }
                class Caretaker {
                    private List<Memento> mementos = new ArrayList<>();
                    public void add(Memento memento) { mementos.add(memento); }
                    public Memento get(int index) { return mementos.get(index); }
                }
                """,
                "Que capture-t-il?",
                new String[]{"État objet", "Comportement", "Interface", "Structure"},
                "A",
                new String[]{"Command", "Observer", "State"}
            ));
        patterns.put("State",
            new PatternInfo(
                "State",
                "Comportemental",
                "Permet à un objet de modifier son comportement lorsque son état interne change.",
                "Comportement dépendant de l'état.",
                "Créer des classes d'état qui implémentent le comportement pour chaque état.",
                3,
                "Élevée",
                new String[]{"Comportement état", "Évite conditions", "Transition claire"},
                new String[]{"Nombreuses classes", "Complexité transitions"},
                new String[]{"Machines à états", "Workflow", "UI states"},
                """
                interface State {
                    void handleRequest();
                }
                class Context {
                    private State state;
                    public void setState(State state) {
                        this.state = state;
                    }
                    public void request() {
                        state.handleRequest();
                    }
                }
                class ConcreteStateA implements State {
                    public void handleRequest() {
                        System.out.println("Handling request in State A");
                    }
                }
                """,
                "Quand changer de comportement?",
                new String[]{"Quand état change", "Toujours", "Jamais", "À l'initialisation"},
                "A",
                new String[]{"Strategy", "Command", "Memento"}
            ));
        patterns.put("Chain of Responsibility",
            new PatternInfo(
                "Chain of Responsibility",
                "Comportemental",
                "Évite de coupler l'expéditeur d'une requête à son récepteur en donnant à plus d'un objet la possibilité de traiter la requête.",
                "Plusieurs objets peuvent traiter une requête.",
                "Créer une chaîne d'objets traitants et passer la requête le long de la chaîne.",
                3,
                "Moyenne",
                new String[]{"Découplage", "Flexibilité chaîne", "Dynamique"},
                new String[]{"Non garantie traitement", "Performance"},
                new String[]{"Logging", "Exception handling", "Event processing"},
                """
                abstract class Handler {
                    protected Handler next;
                    public void setNext(Handler next) { this.next = next; }
                    public abstract void handleRequest(String request);
                }
                class ConcreteHandler1 extends Handler {
                    public void handleRequest(String request) {
                        if (request.equals("Type1")) {
                            System.out.println("Handler1 processing");
                        } else if (next != null) {
                            next.handleRequest(request);
                        }
                    }
                }
                """,
                "Comment passe la requête?",
                new String[]{"Le long d'une chaîne", "Directement", "En parallèle", "Aléatoirement"},
                "A",
                new String[]{"Command", "Composite", "Decorator"}
            ));
        patterns.put("Interpreter",
            new PatternInfo(
                "Interpreter",
                "Comportemental",
                "Définit une représentation pour la grammaire d'un langage avec un interpréteur utilisant cette représentation.",
                "Langages simples à interpréter.",
                "Définir une grammaire et créer un arbre syntaxique abstrait.",
                5,
                "Faible",
                new String[]{"Grammaire facile", "Extensibilité", "Implémentation simple"},
                new String[]{"Complexe pour grammaires complexes", "Performance"},
                new String[]{"Expressions régulières", "Langages de requête", "Calculatrices"},
                """
                interface Expression {
                    boolean interpret(String context);
                }
                class TerminalExpression implements Expression {
                    private String data;
                    public TerminalExpression(String data) { this.data = data; }
                    public boolean interpret(String context) {
                        return context.contains(data);
                    }
                }
                class OrExpression implements Expression {
                    private Expression expr1, expr2;
                    public OrExpression(Expression expr1, Expression expr2) {
                        this.expr1 = expr1;
                        this.expr2 = expr2;
                    }
                    public boolean interpret(String context) {
                        return expr1.interpret(context) || expr2.interpret(context);
                    }
                }
                """,
                "Quel langage interprète-t-il?",
                new String[]{"Langage défini", "Java", "C++", "Python"},
                "A",
                new String[]{"Visitor", "Composite", "Flyweight"}
            ));
    }
    public static PatternInfo getPattern(String name) {
        return patterns.get(name);
    }
    public static List<String> getAllPatternNames() {
        List<String> names = new ArrayList<>(patterns.keySet());
        Collections.sort(names);
        return names;
    }
    public static List<String> getPatternsByCategory(String category) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, PatternInfo> entry : patterns.entrySet()) {
            if (entry.getValue().getCategory().equals(category)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    public static int getPatternCount() {
        return patterns.size();
    }
}
class PatternInfo {
    private String name;
    private String category;
    private String description;
    private String problem;
    private String solution;
    private int difficulty;
    private String frequency;
    private String[] advantages;
    private String[] disadvantages;
    private String[] examples;
    private String codeExample;
    private String quizQuestion;
    private String[] quizOptions;
    private String quizAnswer;
    private String[] relatedPatterns;
    public PatternInfo(String name, String category, String description, String problem,
                      String solution, int difficulty, String frequency, String[] advantages,
                      String[] disadvantages, String[] examples, String codeExample,
                      String quizQuestion, String[] quizOptions, String quizAnswer, String[] relatedPatterns) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.problem = problem;
        this.solution = solution;
        this.difficulty = difficulty;
        this.frequency = frequency;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.examples = examples;
        this.codeExample = codeExample;
        this.quizQuestion = quizQuestion;
        this.quizOptions = quizOptions;
        this.quizAnswer = quizAnswer;
        this.relatedPatterns = relatedPatterns;
    }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getProblem() { return problem; }
    public String getSolution() { return solution; }
    public int getDifficulty() { return difficulty; }
    public String getFrequency() { return frequency; }
    public String[] getAdvantages() { return advantages; }
    public String[] getDisadvantages() { return disadvantages; }
    public String[] getExamples() { return examples; }
    public String getCodeExample() { return codeExample; }
    public String getQuizQuestion() { return quizQuestion; }
    public String[] getQuizOptions() { return quizOptions; }
    public String getQuizAnswer() { return quizAnswer; }
    public String[] getRelatedPatterns() { return relatedPatterns; }
    public String getIntroduction() {
        return "Le pattern " + name + " est un pattern " + category.toLowerCase() + 
               " qui " + description.toLowerCase();
    }
    public String[] getKeyConcepts() {
        return new String[]{
            "Concept principal : " + description.split("\\.")[0],
            "Solution apportée : " + solution,
            "Application typique : " + (examples.length > 0 ? examples[0] : "")
        };
    }
    public String getUseCase() {
        return "Scénario pratique : Vous devez " + problem.toLowerCase() + 
               ". Le pattern " + name + " propose comme solution : " + solution.toLowerCase();
    }
    public String[] getKeyPoints() {
        return new String[]{
            "À utiliser quand : " + problem,
            "Solution : " + solution,
            "Avantage principal : " + (advantages.length > 0 ? advantages[0] : ""),
            "Précautions : " + (disadvantages.length > 0 ? disadvantages[0] : "")
        };
    }
    public String getUmlDiagram() {
        switch(name) {
            case "Singleton":
                return """
                       +-------------------+
                       |    Singleton     |
                       +-------------------+
                       | - instance       |
                       +-------------------+
                       | + getInstance()  |
                       +-------------------+
                             
                       Une seule instance globale
                       """;
            case "Factory Method":
                return """
                       +-------------------+       +-------------------+
                       |     Creator       |       |     Product      |
                       +-------------------+       +-------------------+
                       | + factoryMethod() |------>| + operation()    |
                       +-------------------+       +-------------------+
                                ^
                                |
                       +-------------------+
                       | ConcreteCreator  |
                       +-------------------+
                       | + factoryMethod()|
                       +-------------------+
                       """;
            case "Adapter":
                return """
                       +-------------------+       +-------------------+
                       |    Client        |       |     Target       |
                       +-------------------+       +-------------------+
                       | + request()      |------>| + request()      |
                       +-------------------+       +-------------------+
                                ^
                                |
                       +-------------------+
                       |     Adapter      |
                       +-------------------+
                       | + request()      |
                       +-------------------+
                                |
                       +-------------------+
                       |    Adaptee       |
                       +-------------------+
                       | + specificRequest() |
                       +-------------------+
                       """;
            default:
                return """
                       +-------------------+
                       |     Pattern       |
                       +-------------------+
                       | + operation()     |
                       +-------------------+
                             
                       Diagramme UML standard
                       """;
        }
    }
    public String getStructure() {
        return "Structure type : Interface/Classe abstraite + Implémentations concrètes\n" +
               "Relations : Association, Héritage, Dépendance";
    }
    public String getRelations() {
        return "Relations principales :\n" +
               "- " + (relatedPatterns.length > 0 ? relatedPatterns[0] : "Aucune") + "\n" +
               "- " + (relatedPatterns.length > 1 ? relatedPatterns[1] : "") + "\n" +
               "- " + (relatedPatterns.length > 2 ? relatedPatterns[2] : "");
    }
    public String getFullCodeExample() {
        return "// Exemple complet du pattern " + name + "\n\n" + codeExample;
    }
    public String getExercise() {
        return "Exercice pratique :\n" +
               "Implémentez le pattern " + name + " pour résoudre le problème suivant :\n" +
               problem + "\n\n" +
               "Indices :\n" +
               "1. Identifiez les acteurs principaux\n" +
               "2. Définissez les interfaces nécessaires\n" +
               "3. Implémentez les classes concrètes";
    }
    public String getExerciseSolution() {
        return "Solution suggérée :\n" +
               solution + "\n\n" +
               "Code d'exemple :\n" +
               codeExample;
    }
    public String getTheory() {
        return "Théorie fondamentale :\n" +
               description + "\n\n" +
               "Concepts clés :\n" +
               "- Encapsulation\n" +
               "- Polymorphisme\n" +
               "- Découplage\n" +
               "- Réutilisabilité";
    }
    public String getSolidPrinciples() {
        return "Principes SOLID respectés :\n" +
               (name.equals("Singleton") ? "- Single Responsibility (partiellement)\n" : "") +
               (name.equals("Factory Method") ? "- Open/Closed Principle\n" : "") +
               (name.equals("Strategy") ? "- Liskov Substitution\n" : "") +
               (name.equals("Interface Segregation") ? "- Interface Segregation\n" : "") +
               (name.equals("Dependency Inversion") ? "- Dependency Inversion\n" : "") +
               "Tous les patterns visent à respecter ces principes.";
    }
    public String getBestPractices() {
        return "Bonnes pratiques d'implémentation :\n" +
               "1. " + (advantages.length > 0 ? advantages[0] : "Respecter l'interface") + "\n" +
               "2. " + (advantages.length > 1 ? advantages[1] : "Documenter le code") + "\n" +
               "3. Éviter : " + (disadvantages.length > 0 ? disadvantages[0] : "La sur-ingénierie") + "\n" +
               "4. Tester unitairement chaque composant";
    }
    public String getWhenToUse() {
        return "Utilisez ce pattern quand :\n" +
               problem + "\n" +
               "Exemples concrets : " + (examples.length > 0 ? examples[0] : "Variable selon contexte");
    }
}
public class PatternAcademy {
    public static void main(String[] args) {
        try {
            GameUI ui = new ConsoleUI();
            GameSystem gameSystem = new GameSystem(ui);
            gameSystem.start();
        } catch (Exception e) {
            System.err.println(" Une erreur est survenue : " + e.getMessage());
            e.printStackTrace();
            System.out.println("\n Essayez de redémarrer le jeu.");
        }
    }
}