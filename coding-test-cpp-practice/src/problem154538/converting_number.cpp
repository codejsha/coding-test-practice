#include "converting_number.h"

#include <queue>
#include <unordered_set>
#include <vector>

int bfs(int input, int target, const std::vector<std::function<int(int)>>& operations)
{
    struct State
    {
        int value;
        int steps;
    };

    std::queue<State> q;
    std::unordered_set<int> visited;

    q.push({input, 0});
    visited.insert(input);

    while (!q.empty())
    {
        auto current = q.front();
        q.pop();

        if (current.value == target)
        {
            return current.steps;
        }

        for (const auto& op : operations)
        {
            int next_value = op(current.value);
            if (next_value <= target && visited.find(next_value) == visited.end())
            {
                visited.insert(next_value);
                q.push({next_value, current.steps + 1});
            }
        }
    }

    return -1;
}

int ConvertingNumber::ConvertingNumberMinStep(int x, int y, const int n)
{
    std::function<int(int, int)> multiply = [](int x, int k) { return x * k; };
    std::function<int(int, int)> add = [](int x, int k) { return x + k; };

    auto multiply_three = [multiply](auto&& number) {
        return multiply(std::forward<decltype(number)>(number), 3);
    };
    auto multiply_two = [multiply](auto&& number) {
        return multiply(std::forward<decltype(number)>(number), 2);
    };
    auto add_n = [add, n](auto&& number) {
        return add(std::forward<decltype(number)>(number), n);
    };

    std::vector<std::function<int(int)>> functions = {multiply_three, multiply_two, add_n};
    auto result = bfs(x, y, functions);
    return (result == 0) ? -1 : result;
}
