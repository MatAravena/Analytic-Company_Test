// Should have been extends instead implements
public class carThread extends Thread {
    final String brand;
    final String model;
    final double price;

    //missing attribute price within the class constructor
    public carThread(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    //Should be override?
    //this would be call as a normal method and not part as a new Thread object to start it with after will run
    @Override
    public void run() {
        while (true) {
            // previosly wrong string concatination 
            System.out.println("hello my name is" + this.brand);

            // Java error: Unhandled exception type InterruptedExceptionJava
            // preffer to control the error wrapping the code within a trycatch scope
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public static void main(String[] args) {

        //If I leave the code like this
        //new carThread("Audi").run();
        //the object wont work as a Thread will execute the method run, which is not the method Thread.run()
        //and will get trap this scope of code within the first object.

        carThread _carA = new carThread("Audi", "RS 5", 25000);
        carThread _carB = new carThread("BMW", "X1 SUV", 40000);

        //Starting the thread in this way will run both objects/threads as it should
        _carA.start();
        _carB.start();

        System.out.println("carThreads are running...");
    }

//Closing the  class with a curve parentesis was missing
}
