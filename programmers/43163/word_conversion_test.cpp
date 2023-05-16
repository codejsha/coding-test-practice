#include "word_conversion.cpp"

#include <gtest/gtest.h>

GTEST_TEST(word_conversion, case1)
{
    const string begin = "hit";
    const string target = "cog";
    const vector<string> words = {"hot", "dot", "dog", "lot", "log", "cog"};
    constexpr auto expected = 4;
    const auto actual = solution(begin, target, words);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(word_conversion, case2)
{
    const string begin = "hit";
    const string target = "cog";
    const vector<string> words = {"hot", "dot", "dog", "lot", "log"};
    constexpr auto expected = 0;
    const auto actual = solution(begin, target, words);
    EXPECT_EQ(expected, actual);
}
