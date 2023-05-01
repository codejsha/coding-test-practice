#include "allocation_room_number.cpp"
#include <gtest/gtest.h>

TEST(allocation_room_number, allocation_room_number)
{
    auto k = 10;
    auto room_number = std::vector<long long>{ 1, 3, 4, 1, 3, 1 };
    auto expected = std::vector<long long>{ 1, 3, 4, 2, 5, 6 };

    auto actual = allocation_room_number(room_number);
    EXPECT_EQ(expected, actual);
}
