package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	var A, B, V int
	fmt.Fscanf(reader, "%d %d %d", &A, &B, &V)

	todayUp := A - B
	remain := V - A

	days := int(math.Ceil(float64(remain)/float64(todayUp))) + 1
	fmt.Println(days)
}