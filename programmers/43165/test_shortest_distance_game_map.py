import pytest

from shortest_distance_game_map import search_shortest_path


@pytest.mark.benchmark(group="shortest_distance_game_map")
@pytest.mark.parametrize("maze, expected", [
    (
            [
                [1, 0, 1, 1, 1],
                [1, 0, 1, 0, 1],
                [1, 0, 1, 1, 1],
                [1, 1, 1, 0, 1],
                [0, 0, 0, 0, 1]
            ],
            11
    ),
    (
            [
                [1, 0, 1, 1, 1],
                [1, 0, 1, 0, 1],
                [1, 0, 1, 1, 1],
                [1, 1, 1, 0, 0],
                [0, 0, 0, 0, 1]
            ],
            -1
    )
])
def test_search_shortest_path(maze, expected):
    result = search_shortest_path(maze)
    assert expected == result
