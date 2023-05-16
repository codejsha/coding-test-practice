#include "travel_route.cpp"

#include <gtest/gtest.h>

GTEST_TEST(travel_route, case1)
{
    vector<vector<string>> tickets = {
        {"ICN", "JFK"},
        {"HND", "IAD"},
        {"JFK", "HND"}};
    const vector<string> expected = {"ICN", "JFK", "HND", "IAD"};
    const auto actual = FindEulerianPath(tickets, "ICN");
    EXPECT_EQ(expected, actual);
}

GTEST_TEST(travel_route, case2)
{
    vector<vector<string>> tickets = {
        {"ICN", "SFO"},
        {"ICN", "ATL"},
        {"SFO", "ATL"},
        {"ATL", "ICN"},
        {"ATL", "SFO"}};
    const vector<string> expected = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
    const auto actual = FindEulerianPath(tickets, "ICN");
    EXPECT_EQ(expected, actual);
}
