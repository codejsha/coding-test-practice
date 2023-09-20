#include "min_max_values.h"

#include <limits>
#include <sstream>

std::string FindMinAndMax(const std::string& str)
{
    std::stringstream ss(str);
    auto min = std::numeric_limits<int>::max();
    auto max = std::numeric_limits<int>::min();
    while (ss.good())
    {
        std::string substr;
        getline(ss, substr, ' ');
        if (min > stoi(substr))
        {
            min = stoi(substr);
        }
        if (max < stoi(substr))
        {
            max = stoi(substr);
        }
    }
    return std::to_string(min) + " " + std::to_string(max);
}

// using namespace std;
//
// string solution(string s)
// {
//     auto answer = FindMinAndMax(s);
//     return answer;
// }
