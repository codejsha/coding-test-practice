#pragma once

#include <string>

/**
 * @brief Make big number by removing k digits
 * @details Make big number string by removing k digits from given number string
 * @param number string of number
 * @param k number of digits to remove
 * @return big number string
 */
auto MakeBigNumber(std::string number, int k) -> std::string;
