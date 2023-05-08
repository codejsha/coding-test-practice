#include <map>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

/**
 * \brief allocate room number in hotel
 * \details
 * Submission result
 * Accuracy: 78.8
 * Efficiency: 6.1
 * Total score: 84.8 / 100.0
 *
 * \param k total room number
 * \param room_number room number array that clients want
 * \return assigned room number array
 */
vector<long long> allocation_room_number_slot_iter(long long k, const vector<long long>& room_number)
{
    vector<long long> allocated(k, 0);
    vector<long long> result;
    long long iter = 1;

    for (long long i = 0; i < static_cast<int>(room_number.size()); i++)
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
 * \brief allocate room number in hotel
 * \details
 * Submission result
 * Accuracy: 78.8
 * Efficiency: 3.0
 * Total score: 81.8 / 100.0
 *
 * \param k total room number
 * \param room_number room number array that clients want
 * \return assigned room number array
 */
vector<long long> allocation_room_number_slot_iter_map(long long k, const vector<long long>& room_number)
{
    unordered_map<long long, long long> allocated;
    vector<long long> result;
    long long iter = 1;

    for (long long i = 0; i < static_cast<int>(room_number.size()); i++)
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
 * \brief allocate room number in hotel
 * \details
 * Submission result
 * Accuracy: 78.8
 * Efficiency: 3.0
 * Total score: 81.8 / 100.0
 *
 * \param k total room number
 * \param room_number room number array that clients want
 * \return assigned room number array
 */
vector<long long> allocation_room_number_inner_loop(long long k, const vector<long long>& room_number)
{
    vector<long long> allocated(k, 0);
    vector<long long> result;

    for (long long room : room_number)
    {
        if (allocated[room] == 0)
        {
            allocated[room] = 1;
            result.push_back(room);
        }
        else
        {
            for (long long j = room + 1; j < k; j++)
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
