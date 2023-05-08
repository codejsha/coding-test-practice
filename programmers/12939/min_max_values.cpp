#include <limits>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

/**
 * @brief Find min and max values from given string
 * @param str string of numbers separated by space
 * @return string of min and max values separated by space
 */
string find_min_and_max(string str)
{
    stringstream ss(str);
    int min = numeric_limits<int>::max();
    int max = numeric_limits<int>::min();
    while (ss.good())
    {
        string substr;
        getline(ss, substr, ' ');
        if (min > stoi(substr))
        {
            min = stoi(substr);
        }
        if (max < stoi(substr))
        {
            max = stoi(substr);
        }
    }
    return to_string(min) + " " + to_string(max);
}

/**
 * @brief Wrapper function for find_min_and_max
 * @param s string of numbers separated by space
 * @return string of min and max values separated by space
 */
string solution(string s)
{
    string answer = find_min_and_max(s);
    return answer;
}
