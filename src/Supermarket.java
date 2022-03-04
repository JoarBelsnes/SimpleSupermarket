import java.util.*;
import java.util.PriorityQueue;
import java.util.Random;

public class Supermarket {
    public static void main(String[] args){
        //creatue queue
        int queueCapacity = 20;
        int queueFlow = 2;
        PriorityQueue<Customer> pq1 = new PriorityQueue<Customer>(queueCapacity, new CustomerComparator());
        PriorityQueue<Customer> pq2 = new PriorityQueue<Customer>(queueCapacity, new CustomerComparator());


        //create customers
        int customerAmount = 20;
        Random rand = new Random();

        for (int i = 0; i < customerAmount; i++ ) {
            Customer customer = new Customer("customer" + i, rand.nextInt(60), rand.nextInt(30));
           if (pq1.size() <= pq2.size()) {
               pq1.add(customer);

           }
           else {
               pq2.add(customer);


           }
        }

        System.out.println("Customers served in their priority order");
    for (int i = 0; i <= pq1.size(); i++){
            Customer customer1 = pq1.poll();
            customer1.timeQueueing = i * queueFlow;


            System.out.println("==================q1==============================");
            System.out.println(customer1.getName() + ", time arrived to queue after shopping: " + customer1.getTimeArrived());
            System.out.println(pq1.size());
            System.out.println("Time used queueing: " + customer1.getTimeQueueing());
            System.out.println("Time used scanning: " + customer1.getTimeUsedScanning());
            System.out.println("Total time used in store: " + customer1.getTotalTime());
            System.out.println("=================q1============================");

        }
        for (int i = 0; i <= pq2.size(); i++){
                Customer customer2 = pq2.poll();
                customer2.timeQueueing = i * queueFlow;

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