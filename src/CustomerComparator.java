import java.util.Comparator;

class CustomerComparator implements Comparator<Customer> {

    // Overriding compare()method of Comparator 
    // for descending order of timeArrived
    public int compare(Customer s1, Customer s2) {
        if (s1.timeArrived < s2.timeArrived)
            return -1;
        else if (s1.timeArrived > s2.timeArrived)
            return 1;
        return 0;
    }
}