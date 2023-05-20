#include "integer_triangle.h"

#include <gtest/gtest.h>

GTEST_TEST(IntegerTriangleSum, Successful)
{
    std::vector<std::vector<int>> triangle = {
        {7},
        {3, 8},
        {8, 1, 0},
        {2, 7, 4, 4},
        {4, 5, 2, 6, 5}};
    constexpr auto expected = 30;
    const auto actual = IntegerTriangleSum(triangle);
    EXPECT_EQ(expected, actual);
}
