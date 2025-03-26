//! wap in java to perform job scheduling



import java.util.Arrays;

class Job {
    int id, deadline, profit;
    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobScheduling {
    void scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().orElse(0);
        int[] result = new int[maxDeadline + 1];
        boolean[] slot = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        System.out.println("Scheduled Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i]) System.out.print("Job " + result[i] + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = { new Job(1, 2, 100), new Job(2, 1, 50), new Job(3, 2, 10), new Job(4, 1, 20), new Job(5, 3, 30) };
        JobScheduling scheduler = new JobScheduling();
        scheduler.scheduleJobs(jobs);
    }
}




// ? To perform enter the following command:
// ? javac Jobscheduling.java
//? java Jobscheduling