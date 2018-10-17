package com.cicada.chapt01;

/**
 * interrupted() : 会改变 isInterrupted ->false
 * isInterrupted() static function  不会改变 isInterrupted()
 */h
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number: %d is Prime\n", number);
            }
//            if (isInterrupted()) {
//                System.out.println("isInterrupted");
//                return;3
//            }
            if (interrupted()) {
                System.out.println("isInterrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
