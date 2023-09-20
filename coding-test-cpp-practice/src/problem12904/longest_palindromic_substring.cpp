#include "longest_palindromic_substring.h"

std::string LongestPalindromicSubstring::FindLongestPalindromicSubstring(const std::string& s)
{
    auto longest = std::string{};
    for (auto i = 0; i < s.size(); ++i)
    {
        auto left = i;
        auto right = i;
        while (left >= 0 && right < s.size() && s[left] == s[right])
        {
            --left;
            ++right;
        }
        if (longest.size() < right - left - 1)
        {
            longest = s.substr(left + 1, right - left - 1);
        }

        left = i;
        right = i + 1;
        while (left >= 0 && right < s.size() && s[left] == s[right])
        {
            --left;
            ++right;
        }
        if (longest.size() < right - left - 1)
        {
            longest = s.substr(left + 1, right - left - 1);
        }
    }
    return longest;
}

int LongestPalindromicSubstring::FindLongestPalindromicSubstringLength(const std::string& s)
{
    auto longest = 0;
    for (auto i = 0; i < s.size(); ++i)
    {
        auto left = i;
        auto right = i;
        while (left >= 0 && right < s.size() && s[left] == s[right])
        {
            --left;
            ++right;
        }
        if (longest < right - left - 1)
        {
            longest = right - left - 1;
        }

        left = i;
        right = i + 1;
        while (left >= 0 && right < s.size() && s[left] == s[right])
        {
            --left;
            ++right;
        }
        if (longest < right - left - 1)
        {
            longest = right - left - 1;
        }
    }
    return longest;
}
