#include "integer_triangle.cpp"

#include <gtest/gtest.h>

GTEST_TEST(integer_triangle_sum, case1)
{
    const vector<vector<int>> triangle = {
        {7},
        {3, 8},
        {8, 1, 0},
        {2, 7, 4, 4},
        {4, 5, 2, 6, 5}
    };
    constexpr auto expected = 30;
    const auto actual = solution(triangle);
    EXPECT_EQ(expected, actual);
}
