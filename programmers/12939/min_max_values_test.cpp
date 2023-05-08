#include "min_max_values.cpp"
#include <gtest/gtest.h>

GTEST_TEST(min_max_values, min_max_case1)
{
    auto s = std::string{"1 2 3 4"};
    auto expected = std::string{"1 4"};
    auto actual = find_min_and_max(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(min_max_values, min_max_case2)
{
    auto s = std::string{"-1 -2 -3 -4"};
    auto expected = std::string{"-4 -1"};
    auto actual = find_min_and_max(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(min_max_values, min_max_case3)
{
    auto s = std::string{"-1 -1"};
    auto expected = std::string{"-1 -1"};
    auto actual = find_min_and_max(s);
    EXPECT_EQ(expected, actual);
}
