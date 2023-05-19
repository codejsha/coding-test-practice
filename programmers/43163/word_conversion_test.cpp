#include "word_conversion.h"

#include <gtest/gtest.h>

GTEST_TEST(WordConversionStep, case1)
{
    const std::string begin = "hit";
    const std::string target = "cog";
    std::vector<std::string> words = {"hot", "dot", "dog", "lot", "log", "cog"};
    constexpr auto expected = 4;
    const auto actual = WordConversionStep(begin, target, words);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(WordConversionStep, case2)
{
    const std::string begin = "hit";
    const std::string target = "cog";
    std::vector<std::string> words = {"hot", "dot", "dog", "lot", "log"};
    constexpr auto expected = 0;
    const auto actual = WordConversionStep(begin, target, words);
    EXPECT_EQ(expected, actual);
}
