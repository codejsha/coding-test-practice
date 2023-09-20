#pragma once

#include <string>
#include <vector>

/**
 * @brief Find most popular menu in order
 * @param orders order array of strings
 * @param course course menu
 * @return most popular menu in order
 */
std::vector<std::string> MenuRenewal(std::vector<std::string> orders, const std::vector<int>& course);
