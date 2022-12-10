import java.util.Scanner;
public class Main {

    // הגדרת מערך לוח המשחק
    public static String[][] game = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};


    //פונקציה שמאפסת את הלוח בתחילת משחק
    public static void startAgain(){
        game[0][0] = "_";
        game[0][1] = "_";
        game[0][2] = "_";
        game[1][0] = "_";
        game[1][1] = "_";
        game[1][2] = "_";
        game[2][0] = "_";
        game[2][1] = "_";
        game[2][2] = "_";
    }

    // פונקציה שמדפיסה את הלוח
    public static void showTheGame() {
        for (int i = 0; i < game.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j]);
            }
        }
        System.out.println();
        System.out.println();
    }


    // פונקציה שמאפשרת לשחקן X להקליט בחירת משבצת
    public static String turnX() {
        Scanner scanner = new Scanner(System.in);
        int userInput1 = 0;
        int userInput2 = 0;
        System.out.println("שחקן x הזן מספר שורה מאפס עד שתיים");
        userInput1 = scanner.nextInt();
        System.out.println("שחקן X הזן מספר עמודה מאפס עד שתיים");
        userInput2 = scanner.nextInt();


        // פונקצינ שמוודא כי הקלט הוא בין 0 ל2
        while (userInput2 > 2 || userInput2 < 0 || userInput1 > 2 || userInput1 < 0) {
            System.out.println("הזן מחדש");
            System.out.println("שחקן x הזן מספר שורה מאפס עד שתיים");
            userInput1 = scanner.nextInt();
            System.out.println("שחקן x הזן מספר עמודה מאפס עד שתיים");
            userInput2 = scanner.nextInt();
        }


        // פונקציה שמוודא שנבחרה משבצת פנויה
        while (game[userInput1][userInput2] != "_") {
            System.out.println("משבצת תפוסה הזן מחדש");
            System.out.println("שחקן x הזן מספר שורה מאפס עד שתיים");
            userInput1 = scanner.nextInt();
            System.out.println("שחקן x הזן מספר עמודה מאפס עד שתיים");
            userInput2 = scanner.nextInt();
        }


        game[userInput1][userInput2] = "x";      // קליטת הבחירה

        return game[userInput1][userInput2];      // החזרת בחירת X ללוח המשחק
    }


    // פונקציה שמאפשרת לשחקן 0 להקליט בחירת משבצת
    public static String turn0() {
        Scanner scanner = new Scanner(System.in);
        int userInput1 = 0;
        int userInput2 = 0;
        System.out.println("שחקן 0 הזן מספר שורה מאפס עד שתיים");
        userInput1 = scanner.nextInt();
        System.out.println("שחקן 0 הזן מספר עמודה מאפס עד שתיים");
        userInput2 = scanner.nextInt();


        // פונקציה שמוודא שהקלט הוא בין 0 ל2
        while (userInput2 > 2 || userInput2 < 0 || userInput1 > 2 || userInput1 < 0) {
            System.out.println("הזן מחדש");
            System.out.println("שחקן 0 הזן מספר שורה מאפס עד שתיים");
            userInput1 = scanner.nextInt();
            System.out.println("שחקן 0 הזן מספר עמודה מאפס עד שתיים");
            userInput2 = scanner.nextInt();
        }


        // פונקציה שמוודא שהשחקן בחר משבצת פנויה
        while (game[userInput1][userInput2] != "_") {
            System.out.println();
            System.out.println("משבצת תפוסה הזן מחדש");
            System.out.println("שחקן 0 הזן מספר שורה מאפס עד שתיים");
            userInput1 = scanner.nextInt();
            System.out.println("שחקן 0 הזן מספר עמודה מאפס עד שתיים");
            userInput2 = scanner.nextInt();
        }


        // קליטת הבחירה
        game[userInput1][userInput2] = "0";

        // החזרהת בחירת שחקן 0 ללוח המשחק
        return game[userInput1][userInput2];
    }


    public static void main(String[] args) {

        for (; ;) {     // לולאה שמחזירה לתחילת משחק כאשר יש תיקו או ניצחון

            startAgain();   //זימון פונקציה שמאפסת את הלוח

            for (; ;) {    // לולאה אינסופית שמאפשרת שרשרת של תורים עד לניצחון או תיקו

                turnX();    // זימון תור שחקן X

                // פונקציה שמוודא שיש עדיין משבצות פנויות
                if (    game[0][0] != "_" && game[0][1] != "_" && game[0][2] != "_" &&
                        game[1][0] != "_" && game[1][1] != "_" && game[1][2] != "_" &&
                        game[2][0] != "_" && game[2][1] != "_" && game[2][2] != "_"){
                    System.out.println("draw! try again");
                    break;
                }

                showTheGame();     //זימון פונקציה שמאפסת את הלוח

                // פונקציה שבודקת האם יש ניצחון לשחקן X
                if (
                                game[0][0] == game[0][1] && game[0][1] == game[0][2] && game[0][2] == "x" ||
                                game[1][0] == game[1][1] && game[1][1] == game[1][2] && game[1][2] == "x" ||
                                game[2][0] == game[2][1] && game[2][1] == game[2][2] && game[2][2] == "x" ||
                                game[0][0] == game[1][0] && game[1][0] == game[2][0] && game[2][0] == "x" ||
                                game[0][1] == game[1][1] && game[1][1] == game[2][1] && game[2][1] == "x" ||
                                game[0][2] == game[1][2] && game[1][2] == game[2][2] && game[2][2] == "x" ||
                                game[0][2] == game[1][1] && game[1][1] == game[2][0] && game[2][0] == "x" ||
                                game[0][0] == game[1][1] && game[1][1] == game[2][2] && game[2][2] == "x"
                )
                {
                    System.out.println("-x- winner!!!");
                    System.out.println();
                    break;     // במידה ויש ניצחון משחקן X הלולאה תעצר ויתחיל משחק מחדש
                }

                turn0();    // זימון תור שחקן 0

                showTheGame();     //זימון פונקציה שמדפיסה את לוח המשחק ארי הבחירה של שחקן 0


                // פונקציה שבודקת האם יש ניצחון לשחקן 0
                if (
                                game[0][0] == game[0][1] && game[0][1] == game[0][2] && game[0][2] == "0" ||
                                game[1][0] == game[1][1] && game[1][1] == game[1][2] && game[1][2] == "0" ||
                                game[2][0] == game[2][1] && game[2][1] == game[2][2] && game[2][2] == "0" ||
                                game[0][0] == game[1][0] && game[1][0] == game[2][0] && game[2][0] == "0" ||
                                game[0][1] == game[1][1] && game[1][1] == game[2][1] && game[2][1] == "0" ||
                                game[0][2] == game[1][2] && game[1][2] == game[2][2] && game[2][2] == "0" ||
                                game[0][2] == game[1][1] && game[1][1] == game[2][0] && game[2][0] == "0" ||
                                game[0][0] == game[1][1] && game[1][1] == game[2][2] && game[2][2] == "0"
                ){
                    System.out.println("-0- winner!!!");
                    System.out.println();
                    break;    // יציאה מהלולאה במידה ושחקן 0 ניצח
                }
            }
        }
    }
}