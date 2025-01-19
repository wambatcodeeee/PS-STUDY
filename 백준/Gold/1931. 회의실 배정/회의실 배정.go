package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

type Meeting struct {
	start int
	end int
}

func readInteger(reader *bufio.Reader) int {
	line, _ := reader.ReadString('\n')
	n, _ := strconv.Atoi(strings.TrimSpace(line))
	return n
}

func readMeetings(reader *bufio.Reader, n int) []Meeting {
	meetings := make([]Meeting, n)
	for i := 0; i < n; i++ {
		l, _ := reader.ReadString('\n')
		time := strings.Fields(l)
		start, _ := strconv.Atoi(time[0])
		end, _ := strconv.Atoi(time[1])
		meetings[i] = Meeting{start, end}
	}
	return meetings
}

func sorting(meetingArray []Meeting) []Meeting {
	sort.Slice(meetingArray, func(i, j int) bool {
		if meetingArray[i].end == meetingArray[j].end {
			return meetingArray[i].start < meetingArray[j].start
		}
		return meetingArray[i].end < meetingArray[j].end
	})
	return meetingArray
}

func getMax(meetingArray []Meeting) int {
	count, lastEnd := 0, 0
	for _, meeting := range meetingArray {
		if meeting.start >= lastEnd {
			count++
			lastEnd = meeting.end
		}
	}
	return count
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	n := readInteger(reader)
	meetings := readMeetings(reader, n)
	meetings = sorting(meetings)
	result := getMax(meetings)
	fmt.Fprintln(writer, result)
}