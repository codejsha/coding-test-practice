#include "longest_palindromic_substring.h"

#include <gtest/gtest.h>

GTEST_TEST(FindLongestPalindromicSubstring, Successful)
{
    const auto s = std::string{"babad"};
    const auto expected = std::string{"bab"};

    const auto actual = LongestPalindromicSubstring::FindLongestPalindromicSubstring(s);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(FindLongestPalindromicSubstringLength, Successful)
{
    const auto s = std::string{"babad"};
    const auto expected = 3;

    const auto actual = LongestPalindromicSubstring::FindLongestPalindromicSubstringLength(s);
    EXPECT_EQ(expected, actual);
}
