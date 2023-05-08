#include <vector>

using namespace std;

/**
 * @brief Find max sum of integer triangle
 * @param triangle 2D vector of integer triangle
 * @return max sum of integer triangle
 */
int integer_triangle_sum(vector<vector<int>>& triangle)
{
    int n = static_cast<int>(triangle.size());

    for (int i = n - 2; i >= 0; i--)
    {
        for (int j = 0; j < triangle[i].size(); j++)
        {
            triangle[i][j] += max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
    }

    return triangle[0][0];
}

/**
 * @brief Wrapper method for integer_triangle_sum
 * @param triangle 2D vector of integer triangle
 * @return max sum of integer triangle
 */
int solution(vector<vector<int>> triangle)
{
    int answer = integer_triangle_sum(triangle);
    return answer;
}
