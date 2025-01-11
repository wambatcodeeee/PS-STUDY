package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func menuCount(reader *bufio.Reader) (int, int, int) {
	line, _ := reader.ReadString('\n')
	parts := strings.Fields(line)
	A, _ := strconv.Atoi(parts[0])
	B, _ := strconv.Atoi(parts[1])
	C, _ := strconv.Atoi(parts[2])
	
	return A, B, C
}

func inputNormalMenu(reader *bufio.Reader, count int) map[string]int {
	generalMenu := make(map[string]int)
	
	for i := 0; i < count; i++ {
		line, _ := reader.ReadString('\n')
		parts := strings.Fields(line)
		price, _ := strconv.Atoi(parts[1])
		generalMenu[parts[0]] = price
	}
	
	return generalMenu
}

func inputSpecialMenu(reader *bufio.Reader, count int) map[string]int {
	specialMenu := make(map[string]int)
	
	for i := 0; i < count; i++ {
		line, _ := reader.ReadString('\n')
		parts := strings.Fields(line)
		price, _ := strconv.Atoi(parts[1])
		specialMenu[parts[0]] = price
	}
	
	return specialMenu
}

func inputServiceMenu(reader *bufio.Reader, count int) map[string]bool {
	serviceMenu := make(map[string]bool)
	
	for i := 0; i < count; i++ {
		line, _ := reader.ReadString('\n')
		serviceMenu[strings.TrimSpace(line)] = true
	}
	
	return serviceMenu
}

func orderCount(reader *bufio.Reader) int {
	line, _ := reader.ReadString('\n')
	count, _ := strconv.Atoi(strings.TrimSpace(line))
	return count
}

func readOrders(reader *bufio.Reader, count int) []string {
	orders := make([]string, count)
	
	for i := 0; i < count; i++ {
		line, _ := reader.ReadString('\n')
		orders[i] = strings.TrimSpace(line)
	}
	
	return orders
}

func orderCheck(normalMenu map[string]int, specialMenu map[string]int, serviceMenu map[string]bool, orders []string) bool {
	var normalSum, specialSum int
	var serviceCount int

	for _, order := range orders {
		if price, exist := normalMenu[order]; exist {
			normalSum += price
		} else if price, exist := specialMenu[order]; exist {
			specialSum += price
		} else if _, exist := serviceMenu[order]; exist {
			serviceCount++
		}
	}

	if specialSum > 0 && normalSum < 20000 {
		return false
	}
	
	if serviceCount > 0 && (normalSum+specialSum < 50000 || serviceCount > 1) {
		return false
	}
	
	return true
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	normal, special, service := menuCount(reader)
	normalMenuMap := inputNormalMenu(reader, normal)
	specialMenuMap := inputSpecialMenu(reader, special)
	serviceMenuMap := inputServiceMenu(reader, service)

	order := orderCount(reader)
	orders := readOrders(reader, order)

	if orderCheck(normalMenuMap, specialMenuMap, serviceMenuMap, orders) {
		fmt.Fprintln(writer, "Okay")
	} else {
		fmt.Fprintln(writer, "No")
	}
}