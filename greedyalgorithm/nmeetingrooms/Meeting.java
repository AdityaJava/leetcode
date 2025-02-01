package leetcode.greedyalgorithm.nmeetingrooms;

public class Meeting {
  int startTiming;
  int endTiming;
  int duration;
  int position;

  public Meeting(int startTiming, int endTiming, int position) {
    this.startTiming = startTiming;
    this.endTiming = endTiming;
    this.position = position;
    this.duration = this.endTiming - this.startTiming;
  }
}
