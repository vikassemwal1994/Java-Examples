package dev.marcosfarias.pokedex.classes;

public class ThreadUse implements Runnable {

    @Override
    public void run() {

        for (int i=0; i<4; i++){
            System.out.println(i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        ThreadUse t1 = new ThreadUse();

        Thread t2 = new Thread(t1);

        t2.start();

    }
}
