#include "cutting_roll_cake.h"

#include <unordered_map>

int CuttingRollCake::CuttingRollCake(std::vector<int>& topping)
{
    auto total_map = std::unordered_map<int, int>{};
    for (const auto& item : topping)
    {
        ++total_map[item];
    }

    auto left_map = std::unordered_map<int, int>{};
    auto same_topping_case = 0;
    for (auto current : topping)
    {
        ++left_map[current];
        --total_map[current];

        if (total_map[current] == 0)
        {
            total_map.erase(current);
        }

        if (left_map.size() == total_map.size())
        {
            ++same_topping_case;
        }
    }

    return same_topping_case;
}
