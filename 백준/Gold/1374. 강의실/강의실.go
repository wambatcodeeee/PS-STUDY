package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"os"
	"sort"
)

type Lecture struct {
	start, end int
}

type MinHeap []int

func (mh MinHeap) Len() int           { return len(mh) }
func (mh MinHeap) Less(i, j int) bool { return mh[i] < mh[j] }
func (mh MinHeap) Swap(i, j int)      { mh[i], mh[j] = mh[j], mh[i] }

func (mh *MinHeap) Push(x interface{}) {
	*mh = append(*mh, x.(int))
}

func (mh *MinHeap) Pop() interface{} {
	o := *mh
	n := len(o)
	x := o[n-1]
	*mh = o[:n-1]
	return x
}

func input() []Lecture {
	reader := bufio.NewReader(os.Stdin)
	var n int
	fmt.Fscan(reader, &n)

	lectures := make([]Lecture, n)

	for i := 0; i < n; i++ {
		var num, start, end int
		fmt.Fscan(reader, &num, &start, &end)
		lectures[i] = Lecture{start, end}
	}
	return lectures
}

func min(lectures []Lecture) int {
	sort.Slice(lectures, func(i, j int) bool {
		return lectures[i].start < lectures[j].start
	})

	minHeap := &MinHeap{}
	heap.Init(minHeap)
	heap.Push(minHeap, lectures[0].end)

	for i := 1; i < len(lectures); i++ {
		if (*minHeap)[0] <= lectures[i].start {
			heap.Pop(minHeap)
		}
		heap.Push(minHeap, lectures[i].end)
	}

	return len(*minHeap)
}

func main() {
	lectures := input()
	fmt.Println(min(lectures))
}