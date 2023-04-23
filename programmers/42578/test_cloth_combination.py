import pytest

from cloth_combination import find_cloth_combination


@pytest.mark.benchmark(group="cloth_combination")
@pytest.mark.parametrize("clothes, expected", [
    ([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]], 5),
    ([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]], 3)
])
def test_find_cloth_combination(benchmark, clothes, expected):
    result = benchmark(find_cloth_combination, clothes)
    assert expected == result
