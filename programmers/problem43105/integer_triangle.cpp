#include "integer_triangle.h"

int IntegerTriangleSum(std::vector<std::vector<int>>& triangle)
{
    auto n = static_cast<int>(triangle.size());

    for (auto i = n - 2; i >= 0; --i)
    {
        for (auto j = 0; j < static_cast<int>(triangle[i].size()); ++j)
        {
            triangle[i][j] += std::max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
    }

    return triangle[0][0];
}

// using namespace std;
//
// int solution(vector<vector<int>> triangle)
// {
//     int answer = IntegerTriangleSum(triangle);
//     return answer;
// }
