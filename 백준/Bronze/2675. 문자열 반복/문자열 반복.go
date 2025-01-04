package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	stdin := bufio.NewReader(os.Stdin)
	var num int
	_, _ = fmt.Scanln(&num)

	for i := 0; i < num; i++ {
		var (
			nums   int
			str    string
			newStr string
		)

		_, err := fmt.Scanln(&nums, &str)
		if err != nil {
			stdin.ReadString('\n')
		}

		for _, c := range str {
			for n := 0; n < nums; n++ {
				newStr += string(c)
			}
		}
		fmt.Println(newStr)
	}
}
