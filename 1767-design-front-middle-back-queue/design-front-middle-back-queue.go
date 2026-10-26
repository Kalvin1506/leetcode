const N = 1000

var queue [2][2 * N]int32

type FrontMiddleBackQueue struct{ idx [2][2]int16 }

func Constructor() FrontMiddleBackQueue {
	return FrontMiddleBackQueue{[2][2]int16{{N, N + 1}, {N, N + 1}}}
}

func (q *FrontMiddleBackQueue) size(i int16) int16 {
	return q.idx[i][1] - q.idx[i][0] - 1
}

func (q *FrontMiddleBackQueue) push(i, j int16, val int32) {
	queue[i][q.idx[i][j]] = val
	q.idx[i][j] += 2*j - 1
}

func (q *FrontMiddleBackQueue) pop(i, j int16) int32 {
	if q.size(i) == 0 {
		return -1
	}
	q.idx[i][j] -= 2*j - 1
	v := queue[i][q.idx[i][j]]
	q.balance()
	return v
}

func (q *FrontMiddleBackQueue) balance() {
	if q.size(0) > q.size(1)+1 {
		q.push(1, 0, q.pop(0, 1))
	} else if q.size(0) < q.size(1) {
		q.push(0, 1, q.pop(1, 0))
	}
}

func (q *FrontMiddleBackQueue) PushFront(val int) {
	q.push(0, 0, int32(val))
	q.balance()
}

func (q *FrontMiddleBackQueue) PushMiddle(val int) {
	if q.size(0) > q.size(1) {
		q.push(1, 0, q.pop(0, 1))
	}
	q.push(0, 1, int32(val))
}

func (q *FrontMiddleBackQueue) PushBack(val int) {
	q.push(1, 1, int32(val))
	q.balance()
}

func (q *FrontMiddleBackQueue) PopFront() int {
	return int(q.pop(0, 0))
}

func (q *FrontMiddleBackQueue) PopMiddle() int {
	return int(q.pop(0, 1))
}

func (q *FrontMiddleBackQueue) PopBack() int {
	return int(q.pop(min(1, q.size(1)), 1))
}