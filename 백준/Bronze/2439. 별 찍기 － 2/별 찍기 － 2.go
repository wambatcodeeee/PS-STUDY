package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var stdin = bufio.NewReader(os.Stdin)
	var num int
	_, err := fmt.Scanln(&num)
	if err != nil {
		stdin.ReadString('\n')
	}

	for i := 1; i <= num; i++ {
		for j := num - i; j > 0; j-- {
			fmt.Print(" ")
		}

		for n := 1; n <= i; n++ {
			fmt.Print("*")
		}
		fmt.Print("\n")
	}
}