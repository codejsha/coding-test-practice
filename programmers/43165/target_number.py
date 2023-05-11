def solution(numbers, target):
    answer = target_number(numbers, target, 0, 0)
    return answer


def target_number(numbers, target, idx, subset_sum):
    if idx == len(numbers):
        return 1 if subset_sum == target else 0
    return target_number(numbers, target, idx + 1, subset_sum + numbers[idx]) \
        + target_number(numbers, target, idx + 1, subset_sum - numbers[idx])
