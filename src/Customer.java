class Customer {
    public String name;
    public int timeArrived;
    public int timeQueueing;
    public int timeQueueing1;
    public int itemsPicked;
    public int timeUsedScanning;
    public int timeUsedToScanEachItem = 1;
    public int totalTime;


    // A parameterized Customer constructor
    public Customer(String name, int timeArrived, int itemsPicked) {

        this.name = name;
        this.timeArrived = timeArrived;
        this.itemsPicked = itemsPicked;
        this.timeQueueing1 =
        getTimeUsedScanning();

    }

    public String getName() {
        return name;
    }

    public int getTimeArrived() {
        return timeArrived;
    }

    public int getTimeQueueing() {
        return  timeQueueing;
    }

    public int getTimeUsedScanning(){
        timeUsedScanning = this.itemsPicked * timeUsedToScanEachItem;
        return timeUsedScanning;
    }

    public int getTotalTime(){
        totalTime = timeUsedScanning + timeQueueing + timeArrived;
        return totalTime;
    }
}