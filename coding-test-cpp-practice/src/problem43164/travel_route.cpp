#include "travel_route.h"

#include <algorithm>

void DepthFirstSearchEulerianPath(const std::string& node,
                                  std::map<std::string, std::vector<std::string>>& adjacency_list,
                                  std::vector<std::string>& path)
{
    while (!adjacency_list[node].empty())
    {
        auto next_node = adjacency_list[node].back();
        adjacency_list[node].pop_back();
        DepthFirstSearchEulerianPath(next_node, adjacency_list, path);
    }
    path.push_back(node);
}

std::vector<std::string> FindEulerianPath(const std::vector<std::vector<std::string>>& edges,
                                          const std::string& start)
{
    std::map<std::string, std::vector<std::string>> adjacency_list;

    // Build the adjacency list from the edges
    for (const auto& ticket : edges)
    {
        const auto& from = ticket[0];
        const auto& to = ticket[1];
        adjacency_list[from].push_back(to);
    }

    // Sort the destinations in descending order for each source
    for (auto& [fst, snd] : adjacency_list)
    {
        std::sort(snd.begin(), snd.end(), std::greater<std::string>());
    }

    std::vector<std::string> path;
    // Start the DFS to find the Eulerian path
    DepthFirstSearchEulerianPath(start, adjacency_list, path);

    // Reverse the path to get the correct order
    std::reverse(path.begin(), path.end());
    return path;
}

// using namespace std;
//
// vector<string> solution(vector<vector<string>> tickets)
// {
//     vector<string> eulerianPath = FindEulerianPath(tickets, "ICN");
//     return eulerianPath;
// }
