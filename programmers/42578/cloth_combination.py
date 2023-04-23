from collections import defaultdict


def solution(clothes):
    return find_cloth_combination(clothes)


def find_cloth_combination(clothes):
    clothes_dict = defaultdict(list)
    for cloth, cloth_type in clothes:
        clothes_dict[cloth_type].append(cloth)
    result = 1
    for cloth_type in clothes_dict:
        result *= (len(clothes_dict[cloth_type]) + 1)
    return result - 1
