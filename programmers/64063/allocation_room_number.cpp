#include "allocation_room_number.h"

#include <map>
#include <string>
#include <unordered_map>

std::unordered_map<long long, long long> room_parent;

long long FindSet(const long long u)
{
    if (room_parent[u] == 0)
    {
        return u;
    }
    return room_parent[u] = FindSet(room_parent[u]);
}

std::vector<long long> AllocationRoomNumber(const std::vector<long long>& room_number)
{
    std::vector<long long> answer;
    for (const auto wanted : room_number)
    {
        auto empty_room = FindSet(wanted);
        answer.push_back(empty_room);
        room_parent[empty_room] = empty_room + 1;
    }
    return answer;
}

// using namespace std;
//
// vector<long long> solution(long long k, vector<long long> room_number)
// {
//     vector<long long> answer = AllocationRoomNumber(room_number);
//     return answer;
// }
