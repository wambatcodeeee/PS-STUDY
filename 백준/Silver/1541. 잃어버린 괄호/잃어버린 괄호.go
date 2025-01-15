package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func minimize(str string) int {
	parts := strings.Split(str, "-")
	total := sum(parts[0])

	for i := 1; i < len(parts); i++ {
		total -= sum(parts[i])
	}

	return total
}

func sum(part string) int {
	ele := strings.Split(part, "+")
	sum := 0

	for _, num := range ele {
		value, _ := strconv.Atoi(num)
		sum += value
	}

	return sum
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var str string
	fmt.Fscanln(reader, &str)

	result := minimize(str)
	fmt.Fprintln(writer, result)
}