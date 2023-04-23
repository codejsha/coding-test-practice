from collections import deque


def solution(maps):
    answer = search_shortest_path(maps)
    return answer


def search_shortest_path(maps):
    m = len(maps)
    n = len(maps[0])
    queue = deque()
    start = Coordinate(0, 0, 1)
    queue.append(start)
    while queue:
        point = queue.popleft()
        if point.x == m - 1 and point.y == n - 1:
            return point.distance
        if point.x - 1 >= 0 and maps[point.x - 1][point.y] == 1:
            maps[point.x - 1][point.y] = 0
            queue.append(Coordinate(point.x - 1, point.y, point.distance + 1))
        if point.x + 1 < m and maps[point.x + 1][point.y] == 1:
            maps[point.x + 1][point.y] = 0
            queue.append(Coordinate(point.x + 1, point.y, point.distance + 1))
        if point.y - 1 >= 0 and maps[point.x][point.y - 1] == 1:
            maps[point.x][point.y - 1] = 0
            queue.append(Coordinate(point.x, point.y - 1, point.distance + 1))
        if point.y + 1 < n and maps[point.x][point.y + 1] == 1:
            maps[point.x][point.y + 1] = 0
            queue.append(Coordinate(point.x, point.y + 1, point.distance + 1))
    return -1


class Coordinate:
    def __init__(self, x: int, y: int, distance: int):
        self.x = x
        self.y = y
        self.visited = False
        self.distance = distance
