package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	var builder strings.Builder

	var site int
	var need int
	m := make(map[string]string)

	fmt.Fscanln(reader, &site, &need)

	for i := 0; i < site; i++ {
		var key string
		var val string

		fmt.Fscanln(reader, &key, &val)
		m[key] = val
	}

	for i := 0; i < need; i++ {
		var find string
		fmt.Fscanln(reader, &find)
		builder.WriteString(m[find] + "\n")
	}

	fmt.Fprintln(writer, builder.String())
}