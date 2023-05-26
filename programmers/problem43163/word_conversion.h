#pragma once

#include <string>
#include <vector>

/**
 * @brief Calculates the minimum number of steps to convert one word into another
 * using a single character change.
 * @param begin starting word
 * @param target target word
 * @param words word list
 * @return minimum number of steps to convert begin to target
 */
int WordConversionStep(const std::string& begin, const std::string& target, std::vector<std::string>& words);

/**
 * @brief Check if two words differ by a single character.
 * @param current the current word
 * @param word the word to compare with
 * @return true if the two words differ by a single character, false otherwise
 */
bool IsOneCharDiff(const std::string& current, const std::string& word);
