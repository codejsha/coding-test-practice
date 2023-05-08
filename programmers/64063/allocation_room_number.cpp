#include <map>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

unordered_map<long long, long long> room_parent;

/**
 * \brief find set of room number
 * \param u room number
 * \return parent room number
 */
long long find_set(long long u)
{
    if (room_parent[u] == 0)
    {
        return u;
    }
    return room_parent[u] = find_set(room_parent[u]);
}

/**
 * \brief allocate room number in hotel
 * \param room_number room number array that clients want
 * \return assigned room number array
 */
vector<long long> allocation_room_number(const vector<long long>& room_number)
{
    vector<long long> answer;
    for (long long wanted : room_number)
    {
        long long empty_room = find_set(wanted);
        answer.push_back(empty_room);
        room_parent[empty_room] = empty_room + 1;
    }
    return answer;
}

/**
 * \brief wrapper method for allocation_room_number
 * \param k total room number
 * \param room_number room number array that clients want
 * \return assigned room number array
 */
vector<long long> solution(long long k, vector<long long> room_number)
{
    vector<long long> answer = allocation_room_number(room_number);
    return answer;
}
