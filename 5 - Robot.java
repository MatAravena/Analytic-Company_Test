// I am not sure if this is random enough ... but is what at least in the console may look as random


class HorizontalThread extends Thread {

    public void run() {
        String[] movements = {"left", "right"};

        while (true) {
            for (String move : movements) {
                System.out.println(move + "...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class VerticalThread extends Thread {

    public void run() {
        String[] movements = {"forward", "backward"};

        while (true) {
            for (String move : movements) {
                System.out.println(move + "...");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Robot {
    public static void main(String[] args) {
        HorizontalThread horizontal = new HorizontalThread();
        VerticalThread vertical = new VerticalThread();

        horizontal.start();
        vertical.start();
    }
}
