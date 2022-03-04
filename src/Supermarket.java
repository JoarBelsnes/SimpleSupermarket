import java.util.*;
import java.util.PriorityQueue;
import java.util.Random;

public class Supermarket {
    public static void main(String[] args){
        //creatue queue
        int queueCapacity = 3;
        int queueFlow = 2;
        PriorityQueue<Customer> pq0 = new PriorityQueue<Customer>(queueCapacity, new CustomerComparator());
        PriorityQueue<Customer> pq1 = new PriorityQueue<Customer>(queueCapacity, new CustomerComparator());
        PriorityQueue<Customer> pq2 = new PriorityQueue<Customer>(queueCapacity, new CustomerComparator());


        //create customers
        int customerAmount = 4;
        Random rand = new Random();

        for (int i = 0; i < customerAmount; i++ ) {
            Customer customer = new Customer("customer" + i, rand.nextInt(60), rand.nextInt(30));
           pq0.add(customer);
        }
        while (!pq0.isEmpty()){
            Customer customer = pq0.poll();
            if (pq1.size() <= pq2.size()) {
                pq1.add(customer);
                customer.timeQueueing = pq1.size() * queueFlow;

            }
            else {
                pq2.add(customer);
                customer.timeQueueing = pq2.size() * queueFlow;

            }
        }

        System.out.println("Customers served in their priority order");
    while (!pq1.isEmpty()) {
            Customer customer1 = pq1.poll();


            System.out.println("==================q1==============================");
            System.out.println(customer1.getName() + ", time arrived to queue after shopping: " + customer1.getTimeArrived());
            System.out.println(pq1.size());
            System.out.println("Time used queueing: " + customer1.getTimeQueueing());
            System.out.println("Time used scanning: " + customer1.getTimeUsedScanning());
            System.out.println("Total time used in store: " + customer1.getTotalTime());
            System.out.println("=================q1============================");

        }
        while (!pq2.isEmpty()) {
                Customer customer2 = pq2.poll();

                System.out.println("=================q2============================");
                System.out.println(customer2.getName() + ", time arrived to queue after shopping: " + customer2.getTimeArrived());
                System.out.println(pq2.size());
                System.out.println("Time used queueing: " + customer2.getTimeQueueing());
                System.out.println("Time used scanning: " + customer2.getTimeUsedScanning());
                System.out.println("Total time used in store: " + customer2.getTotalTime());
                System.out.println("==================q2==============================");
            }
    }
} 