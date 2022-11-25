public class Status {
    boolean isOnline;

    public void  onlineOrOffline(){
        System.out.println("Hello!" + '\n');
        System.out.println("Do you want to watch online or offline? ");
        System.out.println("Press 1 for online ");
        System.out.println("Press 2 for offline ");
    }

    public void statusConnection(int option){
        if (1 == option){
            System.out.println('\n' + "You are now watching online ");
            isOnline = true;
        } else if (2 == option){
            System.out.println('\n' + "You are now watching offline ");
            isOnline = false;
        } else {
            System.out.println("eow giv et ordentligt input");
        }
    }
}