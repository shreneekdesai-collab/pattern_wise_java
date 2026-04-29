package MergeIntervals;

import java.util.Arrays;

// Question:
// Given two arrays start[] and end[] such that start[i] is the starting
// time of ith meeting and end[i] is the ending time of ith meeting.
// Return the minimum number of rooms required to attend all meetings.
//
// Note:
// A person can also attend a meeting if its starting time is same as
// the previous meeting's ending time.
//
// Example:
// Input: start[] = [1, 10, 7], end[] = [4, 15, 10]
// Output: 1

public class meetingRooms {

    public static int minMeetingRooms(int[] start, int[] end) {

        int n = start.length;

        Arrays.sort(start);
        Arrays.sort(end);

        int room = 0;
        int maxRooms = 0;

        int i = 0, j = 0;

        while (i < n && j < n) {

            if (start[i] < end[j]) {
                room++;
                maxRooms = Math.max(maxRooms, room);
                i++;
            } else {
                room--;
                j++;
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {

        int[] start = { 1, 10, 7 };
        int[] end = { 4, 15, 10 };

        int result = minMeetingRooms(start, end);

        System.out.println("Start Times: " + Arrays.toString(start));
        System.out.println("End Times: " + Arrays.toString(end));
        System.out.println("Minimum Rooms Required: " + result);
    }
}
