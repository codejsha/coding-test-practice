#include "travel_route.h"

#include <gtest/gtest.h>

GTEST_TEST(FindEulerianPath, Successful1)
{
    std::vector<std::vector<std::string>> tickets = {
        {"ICN", "JFK"},
        {"HND", "IAD"},
        {"JFK", "HND"}};
    const std::vector<std::string> expected = {"ICN", "JFK", "HND", "IAD"};
    const auto actual = FindEulerianPath(tickets, "ICN");
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(FindEulerianPath, Successful2)
{
    std::vector<std::vector<std::string>> tickets = {
        {"ICN", "SFO"},
        {"ICN", "ATL"},
        {"SFO", "ATL"},
        {"ATL", "ICN"},
        {"ATL", "SFO"}};
    const std::vector<std::string> expected = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
    const auto actual = FindEulerianPath(tickets, "ICN");
    EXPECT_EQ(expected, actual);
}
