#include "min_max_values.h"

#include <gtest/gtest.h>

GTEST_TEST(FindMinAndMax, PositiveIntegerArray)
{
    const auto s = std::string{"1 2 3 4"};
    const auto expected = std::string{"1 4"};
    const auto actual = FindMinAndMax(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(FindMinAndMax, NegativeIntegerArray)
{
    const auto s = std::string{"-1 -2 -3 -4"};
    const auto expected = std::string{"-4 -1"};
    const auto actual = FindMinAndMax(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(FindMinAndMax, DuplicateElements)
{
    const auto s = std::string{"-1 -1"};
    const auto expected = std::string{"-1 -1"};
    const auto actual = FindMinAndMax(s);
    EXPECT_EQ(expected, actual);
}
