#include "make_big_number.h"

std::string MakeBigNumber(std::string number, const int k)
{
    auto number_size = static_cast<int>(number.length());

    for (auto i = 0; i < k; ++i)
    {
        for (auto j = 0; j < number_size - 1; ++j)
        {
            const auto current = number[j] - '0';
            const auto next = number[j + 1] - '0';

            if (current < next)
            {
                number.erase(j, 1);
                number_size--;
                break;
            }
            if (j == number_size - 2)
            {
                number.erase(number_size - 1, 1);
                number_size--;
            }
        }
    }
    return number;
}

// using namespace std;

// string solution(string number, int k) {
//     string answer = MakeBigNumber(number, k);
//     return answer;
// }
