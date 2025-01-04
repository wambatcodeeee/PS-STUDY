package main

import (
	"fmt"
	"strconv"
)

func main() {
	var (
		a int
		b int
		c int
	)

	fmt.Scanln(&a)
	fmt.Scanln(&b)
	fmt.Scanln(&c)

	d := strconv.Itoa(a) + strconv.Itoa(b)
	e, _ := strconv.Atoi(d)

	fmt.Println(a + b - c)
	fmt.Println(e - c)
}