#include "menu_renewal.h"

#include <gtest/gtest.h>

GTEST_TEST(MenuRenewal, Successful1)
{
    std::vector<std::string> orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    std::vector<int> course = {2, 3, 4};
    std::vector<std::string> expected = {"AC", "ACDE", "BCFG", "CDE"};
    const auto actual = MenuRenewal(orders, course);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(MenuRenewal, Successful2)
{
    std::vector<std::string> orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
    std::vector<int> course = {2, 3, 5};
    std::vector<std::string> expected = {"ACD", "AD", "ADE", "CD", "XYZ"};
    const auto actual = MenuRenewal(orders, course);
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(MenuRenewal, Successful3)
{
    std::vector<std::string> orders = {"XYZ", "XWY", "WXA"};
    std::vector<int> course = {2, 3, 4};
    std::vector<std::string> expected = {"WX", "XY"};
    const auto actual = MenuRenewal(orders, course);
    EXPECT_EQ(expected, actual);
}
