package main

import "fmt"

func main() {
	var num int
	_, _ = fmt.Scanln(&num)

	for i := 1; i <= num; i++ {
		for j := num - i; j > 0; j-- {
			fmt.Print(" ")
		}

		for n := 1; n <= i; n++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
}