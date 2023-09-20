#pragma once

#include <vector>

/**
 * @brief find set of room number
 * @param u room number
 * @return parent room number
 */
long long FindSet(const long long u);

/**
 * @brief allocate room number in hotel
 * @param room_number room number array that clients want
 * @return assigned room number array
 */
std::vector<long long> AllocationRoomNumber(const std::vector<long long>& room_number);
