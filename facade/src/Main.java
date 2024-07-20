import java.util.Scanner;
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on");
    }

    public void play() {
        System.out.println("DVD Player is playing");
    }

    public void off() {
        System.out.println("DVD Player is off");
    }
}


 class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}


 class LightSystem {
    public void off() {
        System.out.println("Lights are Turned Off");
    }

    public void on() {
        System.out.println("Lights are Turned On");
    }
}


 class Screen {
    public void down() {
        System.out.println("Screen is down");
    }

    public void up() {
        System.out.println("Screen is up");
    }
}


 class SoundSystem {
    public void on() {
        System.out.println("Sound System is on");
    }

    public void off() {
        System.out.println("Sound System is off");
    }
}


 class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer;
    private final Projector projector;
    private final LightSystem lightSystem;
    private final Screen screen;
    private final SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, LightSystem lightSystem, Screen screen, SoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.lightSystem = lightSystem;
        this.screen = screen;
        this.soundSystem = soundSystem;
    }

    public void watchMovie() {
        System.out.println("Get ready to watch a movie :");
        lightSystem.off();
        screen.down();
        projector.on();
        soundSystem.on();
        dvdPlayer.on();
        dvdPlayer.play();
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down :");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        screen.up();
        lightSystem.on();
    }
}



class HomeTheater {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        LightSystem lightSystem = new LightSystem();
        Screen screen = new Screen();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, lightSystem, screen, soundSystem);
/*
        homeTheater.watchMovie();
        System.out.println("--------------------------------");
        homeTheater.endMovie();
        System.out.println();
*/


        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Watch Movie");
            System.out.println("2. End Movie");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    homeTheater.watchMovie();
                    break;
                case 2:
                    homeTheater.endMovie();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();






    }
}
