#include "cutting_roll_cake.h"

#include <gtest/gtest.h>

GTEST_TEST(CuttingRollCake, Successful1)
{
    auto topping = std::vector<int>{1, 2, 1, 3, 1, 4, 1, 2};
    const auto expected = 2;
    const auto actual = CuttingRollCake::CuttingRollCake(topping);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(CuttingRollCake, Successful2)
{
    auto topping = std::vector<int>{1, 2, 3, 1, 4};
    const auto expected = 0;
    const auto actual = CuttingRollCake::CuttingRollCake(topping);
    EXPECT_EQ(expected, actual);
}
