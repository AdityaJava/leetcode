package leetcode.greedyalgorithm.nmeetingrooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NMeetingRooms
 */

public class NMeetingRooms {

  public int maxMeetings(int start[], int end[]) {
    List<Meeting> meetingList = new ArrayList<>();
    for (int i = 0; i < start.length; i++) {
      Meeting meeting = new Meeting(start[i], end[i], i);
      meetingList.add(meeting);
    }
    meetingList = meetingList.stream().sorted(Comparator.comparingInt((Meeting m) -> m.endTiming)).collect(Collectors.toList());

    int endTiming = -1;
    int meetingCount = 1;
    List<Integer> positions = new ArrayList<>();
    for (Meeting meeting : meetingList) {
      if (endTiming == -1) {
        endTiming = meeting.endTiming;
      }
      else if (endTiming < meeting.startTiming) {
        endTiming = meeting.endTiming;
        meetingCount++;
        positions.add(meeting.position);
      }
    }
    return meetingCount;
  }

  public static void main(String[] args) {
    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 6, 7, 9, 9 };

    NMeetingRooms nMeetingRooms = new NMeetingRooms();
    nMeetingRooms.maxMeetings(start, end);
  }
}
