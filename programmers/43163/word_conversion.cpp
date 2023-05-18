#include <queue>
#include <string>
#include <unordered_set>
#include <vector>

/**
 * \brief Check if two words differ by a single character.
 * \param current the current word 
 * \param word the word to compare with
 * \return true if the two words differ by a single character, false otherwise
 */
bool IsOneCharDiff(const std::string& current, const std::string& word)
{
    auto diff = 0;
    for (auto i = 0; i < current.length(); i++)
    {
        if (current[i] != word[i])
        {
            diff++;
        }
    }
    return diff == 1;
}

/**
 * \brief Calculates the minimum number of steps to convert one word into another
 * using a single character change.
 * \param begin starting word
 * \param target target word
 * \param words word list
 * \return minimum number of steps to convert begin to target
 */
int WordConversionStep(const std::string& begin, const std::string& target, std::vector<std::string>& words)
{
    // Convert the word list into a set for faster lookup
    const std::unordered_set<std::string> word_set(words.begin(), words.end());
    if (!word_set.count(target))
    {
        return 0;
    }

    // Queue to perform BFS
    std::queue<std::string> search_queue;
    // Keep track of visited words to avoid infinite loop
    std::unordered_set<std::string> visited;
    search_queue.push(begin);
    visited.insert(begin);
    auto step = 0;

    while (!search_queue.empty())
    {
        // Perform search on all words in the queue
        for (auto i = 0; i < static_cast<int>(search_queue.size()); i++)
        {
            auto current = search_queue.front();
            search_queue.pop();

            // If the current word is the target, return the number of steps
            if (current == target)
            {
                return step;
            }

            // Search for all words that differ by a single character
            for (const auto& word : word_set)
            {
                if (!visited.count(word) && IsOneCharDiff(current, word))
                {
                    search_queue.push(word);
                    visited.insert(word);
                }
            }
        }
        step++;
    }

    // If the target word is not reachable, return 0
    return 0;
}

// using namespace std;
//
// int solution(string begin, string target, vector<string> words)
// {
//     int answer = WordConversionStep(begin, target, words);
//     return answer;
// }
