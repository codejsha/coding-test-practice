#include "allocation_room_number.cpp"

#include <gtest/gtest.h>

GTEST_TEST(allocation_room_number, allocation_room_number)
{
    auto k = 10;
    const auto room_number = std::vector<long long>{ 1, 3, 4, 1, 3, 1 };
    const auto expected = std::vector<long long>{ 1, 3, 4, 2, 5, 6 };

    const auto actual = AllocationRoomNumber(room_number);
    EXPECT_EQ(expected, actual);
}
