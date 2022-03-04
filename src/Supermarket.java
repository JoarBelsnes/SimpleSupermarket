import java.util.*;
import java.util.PriorityQueue;
import java.util.Random;

public class Supermarket {
    public static void main(String[] args){
        //create queue
        int queueCapacity = 20;
        int queueFlow = 2;
        PriorityQueue<Customer> pq0 = new PriorityQueue<Customer>(queueCapacity, new CustomerComparator());
        LinkedList<Customer> q1 = new LinkedList<>();
        LinkedList<Customer> q2 = new LinkedList<>();


        //create customers and adds them to a sorter
        int customerAmount = 20;
        Random rand = new Random();

        for (int i = 0; i < customerAmount; i++ ) {
            Customer customer = new Customer("customer" + i, rand.nextInt(60), rand.nextInt(30));
           pq0.add(customer);
        }

        //After the customers are prioritized they get put into the queues
        while (!pq0.isEmpty()){
            Customer customer = pq0.poll();
            if (q1.size() <= q2.size()) {
                q1.add(customer);
                customer.timeQueueing = q1.size() * queueFlow;

            }
            else {
                q2.add(customer);
                customer.timeQueueing = q2.size() * queueFlow;

            }
        }

        System.out.println("Customers served in their priority order");
    while (!q1.isEmpty()) {
            Customer customer1 = q1.poll();


            System.out.println("==================q1==============================");
            System.out.println(customer1.getName() + ", time arrived to queue after shopping: " + customer1.getTimeArrived());
            System.out.println("Time used queueing: " + customer1.getTimeQueueing());
            System.out.println("Time used scanning: " + customer1.getTimeUsedScanning());
            System.out.println("Total time used in store: " + customer1.getTotalTime());
            System.out.println("=================q1============================");

        }
        while (!q2.isEmpty()) {
                Customer customer2 = q2.poll();

                System.out.println("=================q2============================");
                System.out.println(customer2.getName() + ", time arrived to queue after shopping: " + customer2.getTimeArrived());
                System.out.println("Time used queueing: " + customer2.getTimeQueueing());
                System.out.println("Time used scanning: " + customer2.getTimeUsedScanning());
                System.out.println("Total time used in store: " + customer2.getTotalTime());
                System.out.println("==================q2==============================");
            }
    }
} 