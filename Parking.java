 class Semaphore {
    protected int value = 0;

    protected Semaphore() {
        value = 0;
    }

    protected Semaphore(int initial) {
        value = initial;
    }

    protected synchronized void P() {
        value--;
        if (value < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    protected synchronized void V() {
        value++;
        if (value <= 0)
            notify();
    }

}

class car implements Runnable {

    ParkingLot parkingLot = new ParkingLot();

    car(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void run() {

        
        parkingLot.enter();
        System.out.println(Thread.currentThread().getName()
                + " entered the parking lot");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
                + " left the parking lot");

        parkingLot.exit();
    }
}

class ParkingLot {

    Semaphore parkingSemaphore;

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
        parkingSemaphore = new Semaphore(capacity);
    }

    public void enter() {
        parkingSemaphore.P();
    }

    public void exit() {
        parkingSemaphore.V();
    }
}

class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(1);
       
        Thread c1 = new Thread(new car(parkingLot), "Car 1");
        Thread c2 = new Thread(new car(parkingLot), "Car 2");
        Thread c3 = new Thread(new car(parkingLot), "Car 3");
        Thread c4 = new Thread(new car(parkingLot), "Car 4");
        Thread c5 = new Thread(new car(parkingLot), "Car 5");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
