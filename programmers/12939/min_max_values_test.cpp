#include "min_max_values.cpp"

#include <gtest/gtest.h>

GTEST_TEST(min_max_values, min_max_case1)
{
    const auto s = std::string{"1 2 3 4"};
    const auto expected = std::string{"1 4"};
    const auto actual = FindMinAndMax(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(min_max_values, min_max_case2)
{
    const auto s = std::string{"-1 -2 -3 -4"};
    const auto expected = std::string{"-4 -1"};
    const auto actual = FindMinAndMax(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(min_max_values, min_max_case3)
{
    const auto s = std::string{"-1 -1"};
    const auto expected = std::string{"-1 -1"};
    const auto actual = FindMinAndMax(s);
    EXPECT_EQ(expected, actual);
}
