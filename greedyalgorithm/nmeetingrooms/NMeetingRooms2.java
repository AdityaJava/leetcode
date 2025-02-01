package leetcode.greedyalgorithm.nmeetingrooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NMeetingRooms2
 */

public class NMeetingRooms2 {

  public int maxMeetings(int start[], int end[]) {
    List<Meeting> meetingList = new ArrayList<>();
    for (int i = 0; i < start.length; i++) {
      Meeting meeting = new Meeting(start[i], end[i], i);
      meetingList.add(meeting);
    }
    Collections.sort(meetingList, (m1, m2) -> Integer.compare(m1.endTiming, m2.endTiming));

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
