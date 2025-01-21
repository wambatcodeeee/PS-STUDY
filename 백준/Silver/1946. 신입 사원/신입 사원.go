package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func readInt(r *bufio.Reader) int {
	l, _ := r.ReadString('\n')
	v, _ := strconv.Atoi(strings.TrimSpace(l))
	return v
}

func readLine(r *bufio.Reader) string {
	l, _ := r.ReadString('\n')
	return strings.TrimSpace(l)
}

func readEmployee(r *bufio.Reader, n int) [][2]int {
	Employees := make([][2]int, n)

	for i := 0; i < n; i++ {
		parts := strings.Fields(readLine(r))
		a, _ := strconv.Atoi(parts[0])
		b, _ := strconv.Atoi(parts[1])
		Employees[i] = [2]int{a, b}
	}
	return Employees
}

func countMax(employees [][2]int) int {
	sort.Slice(employees, func(i, j int) bool {
		return employees[i][0] < employees[j][0]
	})

	count := 1
	minRank := employees[0][1]
	for i := 1; i < len(employees); i++ {
		if employees[i][1] < minRank {
			count++
			minRank = employees[i][1]
		}
	}
	return count
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	T := readInt(reader)
	
	for i := 0; i < T; i++ {
		n := readInt(reader)
		employees := readEmployee(reader, n)
		result := countMax(employees)
		fmt.Fprintln(writer, result)
	}
}