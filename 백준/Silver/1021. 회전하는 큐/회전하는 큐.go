package main

import (
	"container/list"
	"fmt"
)

func findMin(queue *list.List, positions []int) int {
	total := 0
	
	for _, target := range positions {
		i := findIndex(queue, target)
		if i <= queue.Len()/2 {
			total += i
			moveLeft(queue, i)
		} else {
			moves := queue.Len() - i
			total += moves
			moveRight(queue, moves)
		}
		
		queue.Remove(queue.Front())
	}
	return total
}

func findIndex(queue *list.List, target int) int {
	i := 0
	
	for e := queue.Front(); e != nil; e = e.Next() {
		if e.Value.(int) == target {
			break
		}
		i++
	}
	
	return i
}

func moveLeft(queue *list.List, count int) {
	for i := 0; i < count; i++ {
		queue.PushBack(queue.Remove(queue.Front()))
	}
}

func moveRight(queue *list.List, count int) {
	for i := 0; i < count; i++ {
		queue.PushFront(queue.Remove(queue.Back()))
	}
}

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	queue := list.New()
	
	for i := 1; i <= n; i++ {
		queue.PushBack(i)
	}

	positions := make([]int, m)
	
	for i := 0; i < m; i++ {
		fmt.Scan(&positions[i])
	}

	fmt.Println(findMin(queue, positions))
}