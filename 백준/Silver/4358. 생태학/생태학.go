package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

func main() {
	reader := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	trees := make(map[string]float64)
	var total float64

	for reader.Scan() {
		tree := reader.Text()
		trees[tree]++
		total++
	}

	keys := make([]string, 0, len(trees))
	for k := range trees {
		keys = append(keys, k)
	}
	sort.Strings(keys)

	for _, k := range keys {
		percentage := math.Round((trees[k]/total)*100*10000) / 10000
		fmt.Fprintf(writer, "%s %.4f\n", k, percentage)
	}
}