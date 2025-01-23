package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func printInput(input string) string {
	var builder strings.Builder
	word := strings.Builder{}
	tagFlag := false

	for _, char := range input {
		switch {
		case char == '<':
			if word.Len() > 0 {
				builder.WriteString(reverse(word.String()))
				word.Reset()
			}
			tagFlag = true
			builder.WriteRune(char)
		case char == '>':
			tagFlag = false
			builder.WriteRune(char)
		case char == ' ' && !tagFlag:
			builder.WriteString(reverse(word.String()))
			builder.WriteRune(' ')
			word.Reset()
		default:
			if tagFlag {
				builder.WriteRune(char)
			} else {
				word.WriteRune(char)
			}
		}
	}

	if word.Len() > 0 {
		builder.WriteString(reverse(word.String()))
	}

	return builder.String()
}

func reverse(str string) string {
	r := []rune(str)
	for i, j := 0, len(r)-1; i < j; i, j = i+1, j-1 {
		r[i], r[j] = r[j], r[i]
	}
	return string(r)
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	input = strings.TrimSpace(input)

	fmt.Println(printInput(input))
}