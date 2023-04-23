import pytest

from target_number import target_number


@pytest.mark.benchmark(group="target_number")
@pytest.mark.parametrize("numbers, target, expected", [
    ([1, 1, 1, 1, 1], 3, 5),
    ([4, 1, 2, 1], 4, 2)
])
def test_target_number(benchmark, numbers, target, expected):
    result = benchmark(target_number, numbers, target, 0, 0)
    assert expected == result
