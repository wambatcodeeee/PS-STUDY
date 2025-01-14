package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

func Mean(nums []int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	mean := float64(sum) / float64(len(nums))
	return int(math.Round(mean))
}

func Median(nums []int) int {
	sort.Ints(nums)
	return nums[len(nums)/2]
}

func Mode(nums []int) int {
	frequency := make(map[int]int)
	for _, num := range nums {
		frequency[num]++
	}

	maxFre := 0
	modes := []int{}
	for num, fre := range frequency {
		if fre > maxFre {
			maxFre = fre
			modes = []int{num}
		} else if fre == maxFre {
			modes = append(modes, num)
		}
	}

	sort.Ints(modes)
	if len(modes) > 1 {
		return modes[1]
	}
	return modes[0]
}

func Range(nums []int) int {
	sort.Ints(nums)
	return nums[len(nums)-1] - nums[0]
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n)
	nums := make([]int, n)
	
	for i := 0; i < n; i++ {
		fmt.Fscanln(reader, &nums[i])
	}

	fmt.Fprintln(writer, Mean(nums))
	fmt.Fprintln(writer, Median(nums))
	fmt.Fprintln(writer, Mode(nums))
	fmt.Fprintln(writer, Range(nums))
}