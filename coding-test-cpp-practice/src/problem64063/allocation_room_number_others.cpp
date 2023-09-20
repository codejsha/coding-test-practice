#include <map>
#include <string>
#include <unordered_map>
#include <vector>

/**
 * @brief allocate room number in hotel
 * @details
 * Submission result
 * Accuracy: 78.8
 * Efficiency: 6.1
 * Total score: 84.8 / 100.0
 *
 * @param k total room number
 * @param room_number room number array that clients want
 * @return assigned room number array
 */
std::vector<long long> AllocationRoomNumberSlotIter(long long k, const std::vector<long long>& room_number)
{
    std::vector<long long> allocated(k, 0);
    std::vector<long long> result;
    long long iter = 1;

    for (long long i = 0; i < static_cast<int>(room_number.size()); ++i)
    {
        long long room = room_number[i];
        if (room <= iter)
        {
            allocated[iter] = iter;
            result.push_back(iter);
            while (iter <= k)
            {
                if (allocated[iter] == 0)
                {
                    break;
                }
                iter++;
            }
        }
        else
        {
            while (room <= k)
            {
                if (allocated[room] == 0)
                {
                    allocated[room] = room;
                    result.push_back(room);
                    break;
                }
                room++;
            }
        }
    }
    return result;
}

/**
 * @brief allocate room number in hotel
 * @details
 * Submission result
 * Accuracy: 78.8
 * Efficiency: 3.0
 * Total score: 81.8 / 100.0
 *
 * @param k total room number
 * @param room_number room number array that clients want
 * @return assigned room number array
 */
std::vector<long long> AllocationRoomNumberSlotIterMap(long long k, const std::vector<long long>& room_number)
{
    std::unordered_map<long long, long long> allocated;
    std::vector<long long> result;
    long long iter = 1;

    for (long long i = 0; i < static_cast<int>(room_number.size()); ++i)
    {
        long long room = room_number[i];
        if (room <= iter)
        {
            while (allocated.find(iter) != allocated.end())
            {
                iter++;
            }
            allocated[iter] = iter;
            result.push_back(iter);
            iter++;
        }
        else
        {
            while (allocated.find(room) != allocated.end())
            {
                room++;
            }
            allocated[room] = room;
            result.push_back(room);
        }
    }
    return result;
}

/**
 * @brief allocate room number in hotel
 * @details
 * Submission result
 * Accuracy: 78.8
 * Efficiency: 3.0
 * Total score: 81.8 / 100.0
 *
 * @param k total room number
 * @param room_number room number array that clients want
 * @return assigned room number array
 */
std::vector<long long> AllocationRoomNumberInnerLoop(long long k, const std::vector<long long>& room_number)
{
    std::vector<long long> allocated(k, 0);
    std::vector<long long> result;

    for (long long room : room_number)
    {
        if (allocated[room] == 0)
        {
            allocated[room] = 1;
            result.push_back(room);
        }
        else
        {
            for (long long j = room + 1; j < k; ++j)
            {
                if (allocated[j] == 0)
                {
                    allocated[j] = 1;
                    result.push_back(j);
                    break;
                }
            }
        }
    }
    return result;
}
