#include "menu_renewal.h"

#include <algorithm>
#include <unordered_map>

std::vector<std::string> GenerateCombination(const std::string& str, const int k)
{
    std::vector<std::string> combinations;
    const auto str_size = static_cast<int>(str.length());

    if (k == 0)
    {
        combinations.emplace_back("");
        return combinations;
    }

    for (auto i = 0; i < str_size; ++i)
    {
        auto suffix_combinations = GenerateCombination(str.substr(i + 1), k - 1);
        for (const auto& suffix : suffix_combinations)
        {
            auto combination = str[i] + suffix;
            combinations.push_back(combination);
        }
    }

    return combinations;
}

std::vector<std::string> MenuRenewal(std::vector<std::string> orders, const std::vector<int>& course)
{
    auto result = std::vector<std::string>{};

    for (const auto count : course)
    {
        std::unordered_map<std::string, int> map;
        auto popular = 1;

        for (auto& order : orders)
        {
            std::sort(order.begin(), order.end());
            auto combination = GenerateCombination(order, count);
            for (const auto& item : combination)
            {
                ++map[item];
                if (map[item] > popular)
                {
                    popular = map[item];
                }
            }
        }

        for (const auto& [key, value] : map)
        {
            if (popular > 1 && value == popular)
            {
                result.push_back(key);
            }
        }
    }

    std::sort(result.begin(), result.end());
    return result;
}
