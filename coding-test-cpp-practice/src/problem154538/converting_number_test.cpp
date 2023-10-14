#include "converting_number.h"

#include <gtest/gtest.h>

GTEST_TEST(ConvertingNumberMinStep, Successful1)
{
    const auto x = 10;
    const auto y = 40;
    const auto n = 5;
    const auto expected = 2;

    const auto actual = ConvertingNumber::ConvertingNumberMinStep(x, y, n);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(ConvertingNumberMinStep, Successful2)
{
    const auto x = 10;
    const auto y = 40;
    const auto n = 30;
    const auto expected = 1;

    const auto actual = ConvertingNumber::ConvertingNumberMinStep(x, y, n);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(ConvertingNumberMinStep, Failed1)
{
    const auto x = 2;
    const auto y = 5;
    const auto n = 4;
    const auto expected = -1;

    const auto actual = ConvertingNumber::ConvertingNumberMinStep(x, y, n);
    EXPECT_EQ(expected, actual);
}
