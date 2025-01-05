package main

import (
	"fmt"
	"slices"
)

func main() {
	var num int
	var result float64
	fmt.Scan(&num)

	var slice []float64
	for i := 0; i < num; i++ {
		var num1 float64
		fmt.Scan(&num1)
		slice = append(slice, num1)
	}

	slices.Sort(slice)
	maxNum := slice[len(slice)-1]
	
	for i := 0; i < len(slice); i++ {
		result += (slice[i] / maxNum) * 100
	}

	fmt.Println(result / float64(num))
}
