package leetcode.greedyalgorithm.jobsequencing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Process {
  int id;
  int deadline;
  int profit;

  public Process(int id, int deadline, int profit) {
    this.id = id;
    this.deadline = deadline;
    this.profit = profit;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDeadline() {
    return deadline;
  }

  public void setDeadline(int deadline) {
    this.deadline = deadline;
  }

  public int getProfit() {
    return profit;
  }

  public void setProfit(int profit) {
    this.profit = profit;
  }

  @Override
  public String toString() {
    return "Process{" + "profit=" + profit + '}';
  }
}

/**
 * JobSequencing
 */
public class JobSequencing {
  public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
    List<Integer> jobScheduler = new ArrayList<>();
    List<Process> processList = createProcessList(id, deadline, profit);
    int maxDeadline = processList.stream().mapToInt(Process::getDeadline).max().getAsInt();
    Map<Integer, Integer> deadLineToJobId = getDeadLineToJobId(maxDeadline);
    int totalProfit = 0;
    int totalProcesses = 0;
    for (Process process : processList) {
      for (int eachDeadline = process.deadline; eachDeadline >= 1; eachDeadline--) {
        if (deadLineToJobId.get(eachDeadline) == -1) {
          deadLineToJobId.put(eachDeadline, process.id);
          totalProfit = totalProfit + process.profit;
          totalProcesses++;
          break;
        }
      }
    }
    return new ArrayList<>(Arrays.asList(totalProcesses, totalProfit));
  }

  private List<Process> createProcessList(int[] id, int[] deadline, int[] profit) {
    List<Process> processList = new ArrayList<>();
    for (int i = 0; i < id.length; i++) {
      processList.add(new Process(id[i], deadline[i], profit[i]));
    }
    Collections.sort(processList, Comparator.comparing(Process::getProfit).reversed());
    return processList;
  }

  private Map<Integer, Integer> getDeadLineToJobId(int maxDeadline) {
    Map<Integer, Integer> deadLineToJobId = new HashMap<>();
    for (int i = 1; i <= maxDeadline; i++) {
      deadLineToJobId.put(i, -1);
    }
    return deadLineToJobId;
  }

  public static void main(String[] args) {
//    int[] id = { 1, 2, 3, 4 };
//    int[] deadline = { 4, 1, 1, 1 };
//    int[] profit = { 20, 1, 40, 30 };

    int[] id = {1, 2, 3, 4};
    int[] deadline = {3, 1, 2, 2};
    int[] profit = {50, 10, 20, 30};

    JobSequencing jobSequencing = new JobSequencing();
    System.out.println(jobSequencing.JobSequencing(id, deadline, profit));
  }
}
